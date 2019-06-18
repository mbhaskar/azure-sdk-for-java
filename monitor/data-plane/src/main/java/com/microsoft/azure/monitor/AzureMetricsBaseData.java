/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.monitor;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The AzureMetricsBaseData model.
 */
public class AzureMetricsBaseData {
    /**
     * Gets or sets the Metric name.
     */
    @JsonProperty(value = "metric", required = true)
    private String metric;

    /**
     * Gets or sets the Metric namespace.
     */
    @JsonProperty(value = "namespace", required = true)
    private String namespace;

    /**
     * Gets or sets the list of dimension names (optional).
     */
    @JsonProperty(value = "dimNames")
    private List<String> dimNames;

    /**
     * Gets or sets the list of time series data for the metric (one per unique
     * dimension combination).
     */
    @JsonProperty(value = "series", required = true)
    private List<AzureTimeSeriesData> series;

    /**
     * Get gets or sets the Metric name.
     *
     * @return the metric value
     */
    public String metric() {
        return this.metric;
    }

    /**
     * Set gets or sets the Metric name.
     *
     * @param metric the metric value to set
     * @return the AzureMetricsBaseData object itself.
     */
    public AzureMetricsBaseData withMetric(String metric) {
        this.metric = metric;
        return this;
    }

    /**
     * Get gets or sets the Metric namespace.
     *
     * @return the namespace value
     */
    public String namespace() {
        return this.namespace;
    }

    /**
     * Set gets or sets the Metric namespace.
     *
     * @param namespace the namespace value to set
     * @return the AzureMetricsBaseData object itself.
     */
    public AzureMetricsBaseData withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    /**
     * Get gets or sets the list of dimension names (optional).
     *
     * @return the dimNames value
     */
    public List<String> dimNames() {
        return this.dimNames;
    }

    /**
     * Set gets or sets the list of dimension names (optional).
     *
     * @param dimNames the dimNames value to set
     * @return the AzureMetricsBaseData object itself.
     */
    public AzureMetricsBaseData withDimNames(List<String> dimNames) {
        this.dimNames = dimNames;
        return this;
    }

    /**
     * Get gets or sets the list of time series data for the metric (one per unique dimension combination).
     *
     * @return the series value
     */
    public List<AzureTimeSeriesData> series() {
        return this.series;
    }

    /**
     * Set gets or sets the list of time series data for the metric (one per unique dimension combination).
     *
     * @param series the series value to set
     * @return the AzureMetricsBaseData object itself.
     */
    public AzureMetricsBaseData withSeries(List<AzureTimeSeriesData> series) {
        this.series = series;
        return this;
    }

}
