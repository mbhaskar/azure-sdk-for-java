// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos;

import com.azure.cosmos.implementation.QueryMetrics;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * The type Feed response diagnostics.
 */
public final class FeedResponseDiagnostics {

    private Map<String, QueryMetrics> queryMetricsMap;

    FeedResponseDiagnostics(Map<String, QueryMetrics> queryMetricsMap) {
        this.queryMetricsMap = queryMetricsMap;
    }

    Map<String, QueryMetrics> getQueryMetricsMap() {
        return queryMetricsMap;
    }

    FeedResponseDiagnostics setQueryMetricsMap(Map<String, QueryMetrics> queryMetricsMap) {
        this.queryMetricsMap = queryMetricsMap;
        return this;
    }

    /**
     * Returns the textual representation of feed response metrics
     * End users are not advised to parse return value and take dependency on parsed object.
     * Since feed response metrics contain some internal metrics, they may change across different versions.
     * @return Textual representation of feed response metrics
     */
    @Override
    public String toString() {
        if (queryMetricsMap == null || queryMetricsMap.isEmpty()) {
            return StringUtils.EMPTY;
        }
        StringBuilder stringBuilder = new StringBuilder();
        queryMetricsMap.forEach((key, value) -> stringBuilder.append(key)
                                                    .append("=")
                                                    .append(value.toString())
                                                    .append("\n"));
        return stringBuilder.toString();
    }
}
