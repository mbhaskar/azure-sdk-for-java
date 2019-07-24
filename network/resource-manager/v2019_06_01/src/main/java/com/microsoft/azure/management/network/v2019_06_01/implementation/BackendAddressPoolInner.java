/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2019_06_01.implementation;

import java.util.List;
import com.microsoft.azure.SubResource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Pool of backend IP addresses.
 */
@JsonFlatten
public class BackendAddressPoolInner extends SubResource {
    /**
     * Gets collection of references to IP addresses defined in network
     * interfaces.
     */
    @JsonProperty(value = "properties.backendIPConfigurations", access = JsonProperty.Access.WRITE_ONLY)
    private List<NetworkInterfaceIPConfigurationInner> backendIPConfigurations;

    /**
     * Gets load balancing rules that use this backend address pool.
     */
    @JsonProperty(value = "properties.loadBalancingRules", access = JsonProperty.Access.WRITE_ONLY)
    private List<SubResource> loadBalancingRules;

    /**
     * Gets outbound rules that use this backend address pool.
     */
    @JsonProperty(value = "properties.outboundRule", access = JsonProperty.Access.WRITE_ONLY)
    private SubResource outboundRule;

    /**
     * Gets outbound rules that use this backend address pool.
     */
    @JsonProperty(value = "properties.outboundRules", access = JsonProperty.Access.WRITE_ONLY)
    private List<SubResource> outboundRules;

    /**
     * Get provisioning state of the public IP resource. Possible values are:
     * 'Updating', 'Deleting', and 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState")
    private String provisioningState;

    /**
     * Gets name of the resource that is unique within the set of backend
     * address pools used by the load balancer. This name can be used to access
     * the resource.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag")
    private String etag;

    /**
     * Type of the resource.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    /**
     * Get gets collection of references to IP addresses defined in network interfaces.
     *
     * @return the backendIPConfigurations value
     */
    public List<NetworkInterfaceIPConfigurationInner> backendIPConfigurations() {
        return this.backendIPConfigurations;
    }

    /**
     * Get gets load balancing rules that use this backend address pool.
     *
     * @return the loadBalancingRules value
     */
    public List<SubResource> loadBalancingRules() {
        return this.loadBalancingRules;
    }

    /**
     * Get gets outbound rules that use this backend address pool.
     *
     * @return the outboundRule value
     */
    public SubResource outboundRule() {
        return this.outboundRule;
    }

    /**
     * Get gets outbound rules that use this backend address pool.
     *
     * @return the outboundRules value
     */
    public List<SubResource> outboundRules() {
        return this.outboundRules;
    }

    /**
     * Get get provisioning state of the public IP resource. Possible values are: 'Updating', 'Deleting', and 'Failed'.
     *
     * @return the provisioningState value
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Set get provisioning state of the public IP resource. Possible values are: 'Updating', 'Deleting', and 'Failed'.
     *
     * @param provisioningState the provisioningState value to set
     * @return the BackendAddressPoolInner object itself.
     */
    public BackendAddressPoolInner withProvisioningState(String provisioningState) {
        this.provisioningState = provisioningState;
        return this;
    }

    /**
     * Get gets name of the resource that is unique within the set of backend address pools used by the load balancer. This name can be used to access the resource.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set gets name of the resource that is unique within the set of backend address pools used by the load balancer. This name can be used to access the resource.
     *
     * @param name the name value to set
     * @return the BackendAddressPoolInner object itself.
     */
    public BackendAddressPoolInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get a unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Set a unique read-only string that changes whenever the resource is updated.
     *
     * @param etag the etag value to set
     * @return the BackendAddressPoolInner object itself.
     */
    public BackendAddressPoolInner withEtag(String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * Get type of the resource.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

}
