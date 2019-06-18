/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.billing.v2018_11_01_preview.implementation;

import java.util.List;
import com.microsoft.azure.management.billing.v2018_11_01_preview.EnabledAzureSKUs;
import com.microsoft.azure.management.billing.v2018_11_01_preview.ServiceProvider;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.ProxyResource;

/**
 * A partner's customer.
 */
@JsonFlatten
public class CustomerInner extends ProxyResource {
    /**
     * The name of the customer.
     */
    @JsonProperty(value = "properties.displayName")
    private String displayName;

    /**
     * Information about the product.
     */
    @JsonProperty(value = "properties.enabledAzureSKUs")
    private List<EnabledAzureSKUs> enabledAzureSKUs;

    /**
     * The service providers which are allowed to provide service to this
     * customer.
     */
    @JsonProperty(value = "properties.serviceProviders")
    private List<ServiceProvider> serviceProviders;

    /**
     * Get the name of the customer.
     *
     * @return the displayName value
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the name of the customer.
     *
     * @param displayName the displayName value to set
     * @return the CustomerInner object itself.
     */
    public CustomerInner withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get information about the product.
     *
     * @return the enabledAzureSKUs value
     */
    public List<EnabledAzureSKUs> enabledAzureSKUs() {
        return this.enabledAzureSKUs;
    }

    /**
     * Set information about the product.
     *
     * @param enabledAzureSKUs the enabledAzureSKUs value to set
     * @return the CustomerInner object itself.
     */
    public CustomerInner withEnabledAzureSKUs(List<EnabledAzureSKUs> enabledAzureSKUs) {
        this.enabledAzureSKUs = enabledAzureSKUs;
        return this;
    }

    /**
     * Get the service providers which are allowed to provide service to this customer.
     *
     * @return the serviceProviders value
     */
    public List<ServiceProvider> serviceProviders() {
        return this.serviceProviders;
    }

    /**
     * Set the service providers which are allowed to provide service to this customer.
     *
     * @param serviceProviders the serviceProviders value to set
     * @return the CustomerInner object itself.
     */
    public CustomerInner withServiceProviders(List<ServiceProvider> serviceProviders) {
        this.serviceProviders = serviceProviders;
        return this;
    }

}
