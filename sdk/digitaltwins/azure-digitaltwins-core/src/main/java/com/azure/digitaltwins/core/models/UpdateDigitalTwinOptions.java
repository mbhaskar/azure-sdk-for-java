// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.digitaltwins.core.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.Context;
import com.azure.digitaltwins.core.implementation.models.DigitalTwinsUpdateOptions;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The optional parameters for
 * {@link com.azure.digitaltwins.core.DigitalTwinsClient#updateDigitalTwinWithResponse(String, List, UpdateDigitalTwinOptions, Context)} and
 * {@link com.azure.digitaltwins.core.DigitalTwinsAsyncClient#updateDigitalTwinWithResponse(String, List, UpdateDigitalTwinOptions)}
 */
@Fluent
public final class UpdateDigitalTwinOptions {
    /*
     * Identifies the request in a distributed tracing system.
     */
    @JsonProperty(value = "traceparent")
    private String traceparent;

    /*
     * Provides vendor-specific trace identification information and is a
     * companion to traceparent.
     */
    @JsonProperty(value = "tracestate")
    private String tracestate;

    /*
     * Only perform the operation if the entity's etag matches one of the etags
     * provided or * is provided.
     */
    @JsonProperty(value = "If-Match")
    private String ifMatch;

    /**
     * Get the traceparent property: Identifies the request in a distributed tracing system.
     *
     * @return the traceparent value.
     */
    public String getTraceparent() {
        return this.traceparent;
    }

    /**
     * Set the traceparent property: Identifies the request in a distributed tracing system.
     *
     * @param traceparent the traceparent value to set.
     * @return the UpdateDigitalTwinOptions object itself.
     */
    public UpdateDigitalTwinOptions setTraceparent(String traceparent) {
        this.traceparent = traceparent;
        return this;
    }

    /**
     * Get the tracestate property: Provides vendor-specific trace identification information and is a companion to
     * traceparent.
     *
     * @return the tracestate value.
     */
    public String getTracestate() {
        return this.tracestate;
    }

    /**
     * Set the tracestate property: Provides vendor-specific trace identification information and is a companion to
     * traceparent.
     *
     * @param tracestate the tracestate value to set.
     * @return the UpdateDigitalTwinOptions object itself.
     */
    public UpdateDigitalTwinOptions setTracestate(String tracestate) {
        this.tracestate = tracestate;
        return this;
    }

    /**
     * Get the ifMatch property: Only perform the operation if the entity's etag matches one of the etags provided or *
     * is provided.
     *
     * @return the ifMatch value.
     */
    public String getIfMatch() {
        return this.ifMatch;
    }

    /**
     * Set the ifMatch property: Only perform the operation if the entity's etag matches one of the etags provided or *
     * is provided.
     *
     * @param ifMatch the ifMatch value to set.
     * @return the UpdateDigitalTwinOptions object itself.
     */
    public UpdateDigitalTwinOptions setIfMatch(String ifMatch) {
        this.ifMatch = ifMatch;
        return this;
    }
}
