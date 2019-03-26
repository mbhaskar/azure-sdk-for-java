/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.billing.v2018_11_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Request parameters to transfer billing subscription.
 */
@JsonFlatten
public class TransferBillingSubscriptionRequest {
    /**
     * The destination invoiceSectionName.
     */
    @JsonProperty(value = "properties.destinationInvoiceSectionName")
    private String destinationInvoiceSectionName;

    /**
     * Get the destination invoiceSectionName.
     *
     * @return the destinationInvoiceSectionName value
     */
    public String destinationInvoiceSectionName() {
        return this.destinationInvoiceSectionName;
    }

    /**
     * Set the destination invoiceSectionName.
     *
     * @param destinationInvoiceSectionName the destinationInvoiceSectionName value to set
     * @return the TransferBillingSubscriptionRequest object itself.
     */
    public TransferBillingSubscriptionRequest withDestinationInvoiceSectionName(String destinationInvoiceSectionName) {
        this.destinationInvoiceSectionName = destinationInvoiceSectionName;
        return this;
    }

}
