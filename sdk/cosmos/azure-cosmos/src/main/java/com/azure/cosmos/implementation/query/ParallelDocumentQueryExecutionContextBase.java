// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.implementation.query;

import com.azure.cosmos.BridgeInternal;
import com.azure.cosmos.implementation.DiagnosticsClientContext;
import com.azure.cosmos.implementation.DocumentClientRetryPolicy;
import com.azure.cosmos.implementation.HttpConstants;
import com.azure.cosmos.implementation.PartitionKeyRange;
import com.azure.cosmos.implementation.Resource;
import com.azure.cosmos.implementation.ResourceType;
import com.azure.cosmos.implementation.RxDocumentServiceRequest;
import com.azure.cosmos.implementation.Strings;
import com.azure.cosmos.implementation.Utils;
import com.azure.cosmos.implementation.feedranges.FeedRangeEpkImpl;
import com.azure.cosmos.implementation.routing.PartitionKeyInternal;
import com.azure.cosmos.implementation.routing.Range;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.FeedRange;
import com.azure.cosmos.models.FeedResponse;
import com.azure.cosmos.models.PartitionKey;
import com.azure.cosmos.models.SqlQuerySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * While this class is public, but it is not part of our published public APIs.
 * This is meant to be internally used only by our sdk.
 */
public abstract class ParallelDocumentQueryExecutionContextBase<T extends Resource>
        extends DocumentQueryExecutionContextBase<T> implements IDocumentQueryExecutionComponent<T> {

    protected final Logger logger;
    protected final List<DocumentProducer<T>> documentProducers;
    protected final SqlQuerySpec querySpec;
    protected int pageSize;
    protected int top = -1;
    List<FeedRangeEpkImpl> feedRanges;


    protected ParallelDocumentQueryExecutionContextBase(DiagnosticsClientContext diagnosticsClientContext,
                                                        IDocumentQueryClient client,
                                                        List<PartitionKeyRange> partitionKeyRanges, ResourceType resourceTypeEnum, Class<T> resourceType,
                                                        SqlQuerySpec query, CosmosQueryRequestOptions cosmosQueryRequestOptions, String resourceLink, String rewrittenQuery,
                                                        boolean isContinuationExpected, boolean getLazyFeedResponse, UUID correlatedActivityId) {
        super(diagnosticsClientContext, client, resourceTypeEnum, resourceType, query, cosmosQueryRequestOptions, resourceLink, getLazyFeedResponse,
                correlatedActivityId);

        logger = LoggerFactory.getLogger(this.getClass());
        documentProducers = new ArrayList<>();
        if (!Strings.isNullOrEmpty(rewrittenQuery)) {
            this.querySpec = new SqlQuerySpec(rewrittenQuery, super.query.getParameters());
        } else {
            this.querySpec = super.query;
        }
    }

    protected void initialize(String collectionRid,
            Map<FeedRangeEpkImpl, String> partitionKeyRangeToContinuationTokenMap, int initialPageSize,
            SqlQuerySpec querySpecForInit) {
        this.pageSize = initialPageSize;
        Map<String, String> commonRequestHeaders = createCommonHeadersAsync(this.getFeedOptions(null, null));
        for (Map.Entry<FeedRangeEpkImpl, String> entry : partitionKeyRangeToContinuationTokenMap.entrySet()) {
            TriFunction<FeedRange, String, Integer, RxDocumentServiceRequest> createRequestFunc = (feedRange,
                                                                                                           continuationToken, pageSize) -> {
                Map<String, String> headers = new HashMap<>(commonRequestHeaders);
                headers.put(HttpConstants.HttpHeaders.CONTINUATION, continuationToken);
                headers.put(HttpConstants.HttpHeaders.PAGE_SIZE, Strings.toString(pageSize));

                PartitionKeyInternal partitionKeyInternal = null;
                if (cosmosQueryRequestOptions.getPartitionKey() != null && cosmosQueryRequestOptions.getPartitionKey() != PartitionKey.NONE) {
                    partitionKeyInternal = BridgeInternal.getPartitionKeyInternal(cosmosQueryRequestOptions.getPartitionKey());
                    headers.put(HttpConstants.HttpHeaders.PARTITION_KEY, partitionKeyInternal.toJson());
                }
                return this.createDocumentServiceRequestWithFeedRange(headers, querySpecForInit, partitionKeyInternal, feedRange,
                                                         collectionRid);
            };

            Function<RxDocumentServiceRequest, Mono<FeedResponse<T>>> executeFunc = (request) -> {
                return this.executeRequestAsync(request);
            };
            final FeedRangeEpkImpl targetRange = entry.getKey();
            final String continuationToken = entry.getValue();
            DocumentProducer<T> dp = createDocumentProducer(collectionRid,
                                                            null,
                                                            continuationToken, initialPageSize, cosmosQueryRequestOptions,
                                                            querySpecForInit, commonRequestHeaders, createRequestFunc, executeFunc,
                                                            () -> client.getResetSessionTokenRetryPolicy().getRequestPolicy(), targetRange);

            documentProducers.add(dp);
        }

    }

    protected <TContinuationToken> FeedRangeEpkImpl findTargetRangeAndExtractContinuationTokens(
        List<FeedRangeEpkImpl> feedRanges, Range<String> range,
        Utils.ValueHolder<Map<FeedRangeEpkImpl, TContinuationToken>> outPartitionRangeToContinuation,
        TContinuationToken continuation) {
        if (feedRanges == null) {
            throw new IllegalArgumentException("partitionKeyRanges can not be null.");
        }

        if (feedRanges.size() < 1) {
            throw new IllegalArgumentException("partitionKeyRanges must have atleast one element.");
        }

        for (FeedRangeEpkImpl feedRangeEpk : feedRanges) {
            if (feedRangeEpk == null) {
                throw new IllegalArgumentException("partitionKeyRanges can not have null elements.");
            }
        }

        // Find the minimum index.
        PartitionKeyRange needle = new PartitionKeyRange(/* id */ null, range.getMin(), range.getMax());
        FeedRangeEpkImpl feedRangeEpk = null;
        int minIndex;
        for (minIndex = 0; minIndex < feedRanges.size(); minIndex++) {
            feedRangeEpk = feedRanges.get(minIndex);
            if (needle.getMinInclusive().equals(feedRanges.get(minIndex).getRange().getMin())) {
                break;
            }
        }

        if (minIndex == feedRanges.size()) {
            throw BridgeInternal.createCosmosException(HttpConstants.StatusCodes.BADREQUEST,
                    String.format("Could not find partition key range for continuation token: {0}", needle));
        }

        List<FeedRangeEpkImpl> replacementRanges;

        // find what ranges make up the supplied continuation token
        replacementRanges = feedRanges.stream()
                                .filter(p -> range.getMin().compareTo(p.getRange().getMin()) <= 0 &&
                                                 range.getMax().compareTo(p.getRange().getMax()) >= 0)
//                                .sorted(Comparator.comparing(PartitionKeyRange::getId))
                                .collect(Collectors.toList());

        if (replacementRanges.isEmpty()) {
            throw BridgeInternal.createCosmosException(HttpConstants.StatusCodes.BADREQUEST,
                                                       String.format("Cannot find ranges for continuation {}", continuation));
        }

        replacementRanges.forEach(r -> outPartitionRangeToContinuation.v.put(r, continuation));

        return feedRangeEpk;
    }

    abstract protected DocumentProducer<T> createDocumentProducer(String collectionRid, PartitionKeyRange targetRange,
                                                                  String initialContinuationToken, int initialPageSize,
                                                                  CosmosQueryRequestOptions cosmosQueryRequestOptions,
                                                                  SqlQuerySpec querySpecForInit,
                                                                  Map<String, String> commonRequestHeaders,
                                                                  TriFunction<FeedRange, String, Integer,
                                                                                 RxDocumentServiceRequest> createRequestFunc,
                                                                  Function<RxDocumentServiceRequest, Mono<FeedResponse<T>>> executeFunc,
                                                                  Callable<DocumentClientRetryPolicy> createRetryPolicyFunc, FeedRange feedRange);

    @Override
    abstract public Flux<FeedResponse<T>> drainAsync(int maxPageSize);

    public void setTop(int newTop) {
        this.top = newTop;

        for (DocumentProducer<T> producer : this.documentProducers) {
            producer.top = newTop;
        }
    }

    protected void initializeReadMany(
        IDocumentQueryClient queryClient, String collectionResourceId, SqlQuerySpec sqlQuerySpec,
        Map<PartitionKeyRange, SqlQuerySpec> rangeQueryMap,
        CosmosQueryRequestOptions cosmosQueryRequestOptions,
        UUID activityId,
        String collectionRid) {
        Map<String, String> commonRequestHeaders = createCommonHeadersAsync(this.getFeedOptions(null, null));

        for (Map.Entry<PartitionKeyRange, SqlQuerySpec> entry : rangeQueryMap.entrySet()) {
            final PartitionKeyRange targetRange = entry.getKey();
            final SqlQuerySpec querySpec = entry.getValue();
            TriFunction<FeedRange, String, Integer, RxDocumentServiceRequest> createRequestFunc = (
                partitionKeyRange,
                continuationToken, pageSize) -> {
                Map<String, String> headers = new HashMap<>(commonRequestHeaders);
                headers.put(HttpConstants.HttpHeaders.CONTINUATION, continuationToken);
                headers.put(HttpConstants.HttpHeaders.PAGE_SIZE, Strings.toString(pageSize));

                return this.createDocumentServiceRequest(headers,
                    querySpec,
                    null,
                    null,
                    collectionRid);
            };

            Function<RxDocumentServiceRequest, Mono<FeedResponse<T>>> executeFunc = (request) -> {
                return this.executeRequestAsync(request);
            };

            // TODO: Review pagesize -1
            DocumentProducer<T> dp = createDocumentProducer(collectionRid, targetRange,
                                                            null, -1, cosmosQueryRequestOptions,
                                                            querySpec,
                                                            commonRequestHeaders, createRequestFunc, executeFunc,
                                                            () -> client.getResetSessionTokenRetryPolicy()
                                                                      .getRequestPolicy(), null);

            documentProducers.add(dp);
        }
    }
}
