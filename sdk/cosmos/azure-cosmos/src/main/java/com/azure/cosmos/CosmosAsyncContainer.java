// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos;

import com.azure.cosmos.implementation.Document;
import com.azure.cosmos.implementation.HttpConstants;
import com.azure.cosmos.implementation.Offer;
import com.azure.cosmos.implementation.Paths;
import com.azure.cosmos.implementation.RequestOptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.azure.cosmos.Resource.validateResource;

/**
 * Provides methods for reading, deleting, and replacing existing Containers.
 * Provides methods for interacting with child resources (Items, Scripts, Conflicts)
 */
public class CosmosAsyncContainer {

    private final CosmosAsyncDatabase database;
    private String id;
    private CosmosAsyncScripts scripts;

    CosmosAsyncContainer(String id, CosmosAsyncDatabase database) {
        this.id = id;
        this.database = database;
    }

    /**
     * Get the id of the {@link CosmosAsyncContainer}
     *
     * @return the id of the {@link CosmosAsyncContainer}
     */
    public String getId() {
        return id;
    }

    /**
     * Set the id of the {@link CosmosAsyncContainer}
     *
     * @param id the id of the {@link CosmosAsyncContainer}
     * @return the same {@link CosmosAsyncContainer} that had the id set
     */
    CosmosAsyncContainer setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Reads the document container
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a single cosmos container response with
     * the read container. In case of failure the {@link Mono} will error.
     *
     * @return an {@link Mono} containing the single cosmos container response with
     * the read container or an error.
     */
    public Mono<CosmosAsyncContainerResponse> read() {
        return read(new CosmosContainerRequestOptions());
    }

    /**
     * Reads the document container by the container link.
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a single cosmos container response with
     * the read container. In case of failure the {@link Mono} will error.
     *
     * @param options The cosmos container request options.
     * @return an {@link Mono} containing the single cosmos container response with
     * the read container or an error.
     */
    public Mono<CosmosAsyncContainerResponse> read(CosmosContainerRequestOptions options) {
        if (options == null) {
            options = new CosmosContainerRequestOptions();
        }
        return database.getDocClientWrapper().readCollection(getLink(), options.toRequestOptions())
                   .map(response -> new CosmosAsyncContainerResponse(response, database)).single();
    }

    /**
     * Deletes the item container
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a single cosmos container response for the
     * deleted database. In case of failure the {@link Mono} will error.
     *
     * @param options the request options.
     * @return an {@link Mono} containing the single cosmos container response for
     * the deleted database or an error.
     */
    public Mono<CosmosAsyncContainerResponse> delete(CosmosContainerRequestOptions options) {
        if (options == null) {
            options = new CosmosContainerRequestOptions();
        }
        return database.getDocClientWrapper().deleteCollection(getLink(), options.toRequestOptions())
                   .map(response -> new CosmosAsyncContainerResponse(response, database)).single();
    }

    /**
     * Deletes the item container
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a single cosmos container response for the
     * deleted container. In case of failure the {@link Mono} will error.
     *
     * @return an {@link Mono} containing the single cosmos container response for
     * the deleted container or an error.
     */
    public Mono<CosmosAsyncContainerResponse> delete() {
        return delete(new CosmosContainerRequestOptions());
    }

    /**
     * Replaces a document container.
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a single cosmos container response with
     * the replaced document container. In case of failure the {@link Mono} will
     * error.
     *
     * @param containerSettings the item container properties
     * @return an {@link Mono} containing the single cosmos container response with
     * the replaced document container or an error.
     */
    public Mono<CosmosAsyncContainerResponse> replace(CosmosContainerProperties containerSettings) {
        return replace(containerSettings, null);
    }

    /**
     * Replaces a document container.
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a single cosmos container response with
     * the replaced document container. In case of failure the {@link Mono} will
     * error.
     *
     * @param containerSettings the item container properties
     * @param options the cosmos container request options.
     * @return an {@link Mono} containing the single cosmos container response with
     * the replaced document container or an error.
     */
    public Mono<CosmosAsyncContainerResponse> replace(CosmosContainerProperties containerSettings,
                                                      CosmosContainerRequestOptions options) {
        validateResource(containerSettings);
        if (options == null) {
            options = new CosmosContainerRequestOptions();
        }
        return database.getDocClientWrapper()
                   .replaceCollection(containerSettings.getV2Collection(), options.toRequestOptions())
                   .map(response -> new CosmosAsyncContainerResponse(response, database)).single();
    }

    /* CosmosAsyncItem operations */

    /**
     * Creates a cosmos item.
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a single resource response with the
     * created cosmos item. In case of failure the {@link Mono} will error.
     *
     * @param item the cosmos item represented as a POJO or cosmos item object.
     * @return an {@link Mono} containing the single resource response with the
     * created cosmos item or an error.
     */
    public Mono<CosmosAsyncItemResponse> createItem(Object item) {
        return createItem(item, new CosmosItemRequestOptions());
    }

    /**
     * Creates a cosmos item.
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a single resource response with the
     * created cosmos item. In case of failure the {@link Mono} will error.
     *
     * @param item the cosmos item represented as a POJO or cosmos item object.
     * @param options the request options.
     * @return an {@link Mono} containing the single resource response with the
     * created cosmos item or an error.
     */
    public Mono<CosmosAsyncItemResponse> createItem(Object item, CosmosItemRequestOptions options) {
        if (options == null) {
            options = new CosmosItemRequestOptions();
        }
        RequestOptions requestOptions = options.toRequestOptions();
        return database.getDocClientWrapper()
                   .createDocument(getLink(),
                       CosmosItemProperties.fromObject(item),
                       requestOptions,
                       true)
                   .map(response -> new CosmosAsyncItemResponse(response,
                       requestOptions.getPartitionKey(), this))
                   .single();
    }

    /**
     * Upserts an item.
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a single resource response with the
     * upserted item. In case of failure the {@link Mono} will error.
     *
     * @param item the item represented as a POJO or Item object to upsert.
     * @return an {@link Mono} containing the single resource response with the upserted document or an error.
     */
    public Mono<CosmosAsyncItemResponse> upsertItem(Object item) {
        return upsertItem(item, null);
    }

    /**
     * Upserts a cosmos item.
     * <p>
     * After subscription the operation will be performed. The {@link Mono} upon
     * successful completion will contain a single resource response with the
     * upserted item. In case of failure the {@link Mono} will error.
     *
     * @param item the item represented as a POJO or Item object to upsert.
     * @param options the request options.
     * @return an {@link Mono} containing the single resource response with the upserted document or an error.
     */
    public Mono<CosmosAsyncItemResponse> upsertItem(Object item, CosmosItemRequestOptions options) {
        if (options == null) {
            options = new CosmosItemRequestOptions();
        }
        RequestOptions requestOptions = options.toRequestOptions();

        return this.getDatabase().getDocClientWrapper()
                   .upsertDocument(this.getLink(), CosmosItemProperties.fromObject(item), options.toRequestOptions(),
                       true)
                   .map(response -> new CosmosAsyncItemResponse(response,
                       requestOptions.getPartitionKey(),
                       this))
                   .single();
    }

    /**
     * Reads all cosmos items in the container.
     * <p>
     * After subscription the operation will be performed. The {@link Flux} will
     * contain one or several feed response of the read cosmos items. In case of
     * failure the {@link Flux} will error.
     *
     * @param <T> the type parameter
     * @param klass the class type
     * @return an {@link Flux} containing one or several feed response pages of the read cosmos items or an error.
     */
    public <T> Flux<FeedResponse<T>> readAllItems(Class<T> klass) {
        return readAllItems(new FeedOptions(), klass);
    }

    /**
     * Reads all cosmos items in a container.
     * <p>
     * After subscription the operation will be performed. The {@link Flux} will
     * contain one or several feed response of the read cosmos items. In case of
     * failure the {@link Flux} will error.
     *
     * @param <T> the type parameter
     * @param options the feed options.
     * @param klass the class type
     * @return an {@link Flux} containing one or several feed response pages of the read cosmos items or an error.
     */
    public <T> Flux<FeedResponse<T>> readAllItems(FeedOptions options, Class<T> klass) {
        return getDatabase().getDocClientWrapper().readDocuments(getLink(), options).map(
            response -> BridgeInternal
                            .createFeedResponse(CosmosItemProperties
                                                    .getTypedResultsFromV2Results(response.getResults(),
                                                                                  klass),
                                                response.getResponseHeaders()));
    }

    /**
     * Query for documents in a items in a container
     * <p>
     * After subscription the operation will be performed. The {@link Flux} will
     * contain one or several feed response of the obtained items. In case of
     * failure the {@link Flux} will error.
     *
     * @param <T> the type parameter
     * @param query the query.
     * @param klass the class type
     * @return an {@link Flux} containing one or several feed response pages of the obtained items or an error.
     */
    public <T> Flux<FeedResponse<T>> queryItems(String query, Class<T> klass) {
        return queryItems(new SqlQuerySpec(query), null);
    }

    /**
     * Query for documents in a items in a container
     * <p>
     * After subscription the operation will be performed. The {@link Flux} will
     * contain one or several feed response of the obtained items. In case of
     * failure the {@link Flux} will error.
     *
     * @param <T> the type parameter
     * @param query the query.
     * @param options the feed options.
     * @param klass the class type
     * @return an {@link Flux} containing one or several feed response pages of the obtained items or an error.
     */
    public <T> Flux<FeedResponse<T>> queryItems(String query, FeedOptions options, Class<T> klass) {
        return queryItems(new SqlQuerySpec(query), options, klass);
    }

    /**
     * Query for documents in a items in a container
     * <p>
     * After subscription the operation will be performed. The {@link Flux} will
     * contain one or several feed response of the obtained items. In case of
     * failure the {@link Flux} will error.
     *
     * @param <T> the type parameter
     * @param querySpec the SQL query specification.
     * @param klass the class type
     * @return an {@link Flux} containing one or several feed response pages of the obtained items or an error.
     */
    public <T> Flux<FeedResponse<T>> queryItems(SqlQuerySpec querySpec, Class<T> klass) {
        return queryItems(querySpec, klass);
    }

    /**
     * Query for documents in a items in a container
     * <p>
     * After subscription the operation will be performed. The {@link Flux} will
     * contain one or several feed response of the obtained items. In case of
     * failure the {@link Flux} will error.
     *
     * @param <T> the type parameter
     * @param querySpec the SQL query specification.
     * @param options the feed options.
     * @param klass the class type
     * @return an {@link Flux} containing one or several feed response pages of the obtained items or an error.
     */
    public <T> Flux<FeedResponse<T>> queryItems(SqlQuerySpec querySpec, FeedOptions options, Class<T> klass) {
        return getDatabase().getDocClientWrapper().queryDocuments(getLink(),
                                                                  querySpec, options)
                   .map(response -> BridgeInternal.createFeedResponseWithQueryMetrics(
                       (CosmosItemProperties
                            .getTypedResultsFromV2Results((List<Document>) (Object) response.getResults(),
                                                          klass)), response.getResponseHeaders(),
                       response.queryMetrics()));
    }

    /**
     * Query for documents in a items in a container
     * <p>
     * After subscription the operation will be performed. The {@link Flux} will
     * contain one or several feed response of the obtained items. In case of
     * failure the {@link Flux} will error.
     *
     * @param changeFeedOptions the feed options.
     * @return an {@link Flux} containing one or several feed response pages of the
     * obtained items or an error.
     */
    public Flux<FeedResponse<CosmosItemProperties>> queryChangeFeedItems(ChangeFeedOptions changeFeedOptions) {
        return getDatabase().getDocClientWrapper().queryDocumentChangeFeed(getLink(), changeFeedOptions)
                   .map(response -> new FeedResponse<CosmosItemProperties>(
                       CosmosItemProperties.getFromV2Results(response.getResults()), response.getResponseHeaders(),
                       false));
    }

    /**
     * Gets a CosmosAsyncItem object without making a service call
     *
     * @param id id of the item
     * @param partitionKey the partition key
     * @return a cosmos item
     */
    public CosmosAsyncItem getItem(String id, Object partitionKey) {
        return new CosmosAsyncItem(id, partitionKey, this);
    }

    public CosmosAsyncScripts getScripts() {
        if (this.scripts == null) {
            this.scripts = new CosmosAsyncScripts(this);
        }
        return this.scripts;
    }

    /**
     * Lists all the conflicts in the container
     *
     * @param options the feed options
     * @return a {@link Flux} containing one or several feed response pages of the
     * obtained conflicts or an error.
     */
    public Flux<FeedResponse<CosmosConflictProperties>> readAllConflicts(FeedOptions options) {
        return database.getDocClientWrapper().readConflicts(getLink(), options)
                   .map(response -> BridgeInternal.createFeedResponse(
                       CosmosConflictProperties.getFromV2Results(response.getResults()),
                       response.getResponseHeaders()));
    }

    /**
     * Queries all the conflicts in the container
     *
     * @param query the query
     * @return a {@link Flux} containing one or several feed response pages of the
     * obtained conflicts or an error.
     */
    public Flux<FeedResponse<CosmosConflictProperties>> queryConflicts(String query) {
        return queryConflicts(query, null);
    }

    /**
     * Queries all the conflicts in the container
     *
     * @param query the query
     * @param options the feed options
     * @return a {@link Flux} containing one or several feed response pages of the
     * obtained conflicts or an error.
     */
    public Flux<FeedResponse<CosmosConflictProperties>> queryConflicts(String query, FeedOptions options) {
        return database.getDocClientWrapper().queryConflicts(getLink(), query, options)
                   .map(response -> BridgeInternal.createFeedResponse(
                       CosmosConflictProperties.getFromV2Results(response.getResults()),
                       response.getResponseHeaders()));
    }

    /**
     * Gets a CosmosAsyncConflict object without making a service call
     *
     * @param id id of the cosmos conflict
     * @return a cosmos conflict
     */
    public CosmosAsyncConflict getConflict(String id) {
        return new CosmosAsyncConflict(id, this);
    }

    /**
     * Gets the throughput of the container
     *
     * @return a {@link Mono} containing throughput or an error.
     */
    public Mono<Integer> readProvisionedThroughput() {
        return this.read()
                   .flatMap(cosmosContainerResponse ->
                                database.getDocClientWrapper()
                                    .queryOffers("select * from c where c.offerResourceId = '"
                                                     + cosmosContainerResponse.getProperties()
                                                           .getResourceId() + "'", new FeedOptions())
                                    .single())
                   .flatMap(offerFeedResponse -> {
                       if (offerFeedResponse.getResults().isEmpty()) {
                           return Mono.error(
                               BridgeInternal.createCosmosClientException(HttpConstants.StatusCodes.BADREQUEST,
                               "No offers found for the resource"));
                       }
                       return database.getDocClientWrapper()
                                  .readOffer(offerFeedResponse.getResults().get(0).getSelfLink())
                                  .single();
                   }).map(cosmosOfferResponse -> cosmosOfferResponse.getResource().getThroughput());
    }

    /**
     * Sets throughput provisioned for a container in measurement of
     * Requests-per-Unit in the Azure Cosmos service.
     *
     * @param requestUnitsPerSecond the cosmos container throughput, expressed in
     * Request Units per second
     * @return a {@link Mono} containing throughput or an error.
     */
    public Mono<Integer> replaceProvisionedThroughput(int requestUnitsPerSecond) {
        return this.read()
                   .flatMap(cosmosContainerResponse ->
                                database.getDocClientWrapper()
                                    .queryOffers("select * from c where c.offerResourceId = '"
                                                     + cosmosContainerResponse.getProperties()
                                                           .getResourceId() + "'", new FeedOptions())
                                    .single())
                   .flatMap(offerFeedResponse -> {
                       if (offerFeedResponse.getResults().isEmpty()) {
                           return Mono.error(
                               BridgeInternal.createCosmosClientException(HttpConstants.StatusCodes.BADREQUEST,
                               "No offers found for the resource"));
                       }
                       Offer offer = offerFeedResponse.getResults().get(0);
                       offer.setThroughput(requestUnitsPerSecond);
                       return database.getDocClientWrapper().replaceOffer(offer).single();
                   }).map(offerResourceResponse -> offerResourceResponse.getResource().getThroughput());
    }

    /**
     * Gets the parent Database
     *
     * @return the {@link CosmosAsyncDatabase}
     */
    public CosmosAsyncDatabase getDatabase() {
        return database;
    }

    String getURIPathSegment() {
        return Paths.COLLECTIONS_PATH_SEGMENT;
    }

    String getParentLink() {
        return database.getLink();
    }

    String getLink() {
        StringBuilder builder = new StringBuilder();
        builder.append(getParentLink());
        builder.append("/");
        builder.append(getURIPathSegment());
        builder.append("/");
        builder.append(getId());
        return builder.toString();
    }

}
