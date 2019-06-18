/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor.implementation;

import com.microsoft.azure.management.monitor.Unit;
import com.microsoft.azure.management.monitor.AggregationType;
import java.util.List;
import com.microsoft.azure.management.monitor.MetricAvailability;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Metric definition class specifies the metadata for a metric.
 */
public class MetricDefinitionInner {
    /**
     * Flag to indicate whether the dimension is required.
     */
    @JsonProperty(value = "isDimensionRequired")
    private Boolean isDimensionRequired;

    /**
     * the resource identifier of the resource that emitted the metric.
     */
    @JsonProperty(value = "resourceId")
    private String resourceId;

    /**
     * the namespace the metric belongs to.
     */
    @JsonProperty(value = "namespace")
    private String namespace;

    /**
     * the name and the display name of the metric, i.e. it is a localizable
     * string.
     */
    @JsonProperty(value = "name")
    private LocalizableStringInner name;

    /**
     * the unit of the metric. Possible values include: 'Count', 'Bytes',
     * 'Seconds', 'CountPerSecond', 'BytesPerSecond', 'Percent',
     * 'MilliSeconds', 'ByteSeconds', 'Unspecified'.
     */
    @JsonProperty(value = "unit")
    private Unit unit;

    /**
     * the primary aggregation type value defining how to use the values for
     * display. Possible values include: 'None', 'Average', 'Count', 'Minimum',
     * 'Maximum', 'Total'.
     */
    @JsonProperty(value = "primaryAggregationType")
    private AggregationType primaryAggregationType;

    /**
     * the collection of what aggregation types are supported.
     */
    @JsonProperty(value = "supportedAggregationTypes")
    private List<AggregationType> supportedAggregationTypes;

    /**
     * the collection of what aggregation intervals are available to be
     * queried.
     */
    @JsonProperty(value = "metricAvailabilities")
    private List<MetricAvailability> metricAvailabilities;

    /**
     * the resource identifier of the metric definition.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * the name and the display name of the dimension, i.e. it is a localizable
     * string.
     */
    @JsonProperty(value = "dimensions")
    private List<LocalizableStringInner> dimensions;

    /**
     * Get flag to indicate whether the dimension is required.
     *
     * @return the isDimensionRequired value
     */
    public Boolean isDimensionRequired() {
        return this.isDimensionRequired;
    }

    /**
     * Set flag to indicate whether the dimension is required.
     *
     * @param isDimensionRequired the isDimensionRequired value to set
     * @return the MetricDefinitionInner object itself.
     */
    public MetricDefinitionInner withIsDimensionRequired(Boolean isDimensionRequired) {
        this.isDimensionRequired = isDimensionRequired;
        return this;
    }

    /**
     * Get the resource identifier of the resource that emitted the metric.
     *
     * @return the resourceId value
     */
    public String resourceId() {
        return this.resourceId;
    }

    /**
     * Set the resource identifier of the resource that emitted the metric.
     *
     * @param resourceId the resourceId value to set
     * @return the MetricDefinitionInner object itself.
     */
    public MetricDefinitionInner withResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * Get the namespace the metric belongs to.
     *
     * @return the namespace value
     */
    public String namespace() {
        return this.namespace;
    }

    /**
     * Set the namespace the metric belongs to.
     *
     * @param namespace the namespace value to set
     * @return the MetricDefinitionInner object itself.
     */
    public MetricDefinitionInner withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    /**
     * Get the name and the display name of the metric, i.e. it is a localizable string.
     *
     * @return the name value
     */
    public LocalizableStringInner name() {
        return this.name;
    }

    /**
     * Set the name and the display name of the metric, i.e. it is a localizable string.
     *
     * @param name the name value to set
     * @return the MetricDefinitionInner object itself.
     */
    public MetricDefinitionInner withName(LocalizableStringInner name) {
        this.name = name;
        return this;
    }

    /**
     * Get the unit of the metric. Possible values include: 'Count', 'Bytes', 'Seconds', 'CountPerSecond', 'BytesPerSecond', 'Percent', 'MilliSeconds', 'ByteSeconds', 'Unspecified'.
     *
     * @return the unit value
     */
    public Unit unit() {
        return this.unit;
    }

    /**
     * Set the unit of the metric. Possible values include: 'Count', 'Bytes', 'Seconds', 'CountPerSecond', 'BytesPerSecond', 'Percent', 'MilliSeconds', 'ByteSeconds', 'Unspecified'.
     *
     * @param unit the unit value to set
     * @return the MetricDefinitionInner object itself.
     */
    public MetricDefinitionInner withUnit(Unit unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Get the primary aggregation type value defining how to use the values for display. Possible values include: 'None', 'Average', 'Count', 'Minimum', 'Maximum', 'Total'.
     *
     * @return the primaryAggregationType value
     */
    public AggregationType primaryAggregationType() {
        return this.primaryAggregationType;
    }

    /**
     * Set the primary aggregation type value defining how to use the values for display. Possible values include: 'None', 'Average', 'Count', 'Minimum', 'Maximum', 'Total'.
     *
     * @param primaryAggregationType the primaryAggregationType value to set
     * @return the MetricDefinitionInner object itself.
     */
    public MetricDefinitionInner withPrimaryAggregationType(AggregationType primaryAggregationType) {
        this.primaryAggregationType = primaryAggregationType;
        return this;
    }

    /**
     * Get the collection of what aggregation types are supported.
     *
     * @return the supportedAggregationTypes value
     */
    public List<AggregationType> supportedAggregationTypes() {
        return this.supportedAggregationTypes;
    }

    /**
     * Set the collection of what aggregation types are supported.
     *
     * @param supportedAggregationTypes the supportedAggregationTypes value to set
     * @return the MetricDefinitionInner object itself.
     */
    public MetricDefinitionInner withSupportedAggregationTypes(List<AggregationType> supportedAggregationTypes) {
        this.supportedAggregationTypes = supportedAggregationTypes;
        return this;
    }

    /**
     * Get the collection of what aggregation intervals are available to be queried.
     *
     * @return the metricAvailabilities value
     */
    public List<MetricAvailability> metricAvailabilities() {
        return this.metricAvailabilities;
    }

    /**
     * Set the collection of what aggregation intervals are available to be queried.
     *
     * @param metricAvailabilities the metricAvailabilities value to set
     * @return the MetricDefinitionInner object itself.
     */
    public MetricDefinitionInner withMetricAvailabilities(List<MetricAvailability> metricAvailabilities) {
        this.metricAvailabilities = metricAvailabilities;
        return this;
    }

    /**
     * Get the resource identifier of the metric definition.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the resource identifier of the metric definition.
     *
     * @param id the id value to set
     * @return the MetricDefinitionInner object itself.
     */
    public MetricDefinitionInner withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the name and the display name of the dimension, i.e. it is a localizable string.
     *
     * @return the dimensions value
     */
    public List<LocalizableStringInner> dimensions() {
        return this.dimensions;
    }

    /**
     * Set the name and the display name of the dimension, i.e. it is a localizable string.
     *
     * @param dimensions the dimensions value to set
     * @return the MetricDefinitionInner object itself.
     */
    public MetricDefinitionInner withDimensions(List<LocalizableStringInner> dimensions) {
        this.dimensions = dimensions;
        return this;
    }

}
