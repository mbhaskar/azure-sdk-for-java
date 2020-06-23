/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_05_01.implementation;

import com.microsoft.azure.management.network.v2020_05_01.ProvisioningState;
import java.util.List;
import com.microsoft.azure.management.network.v2020_05_01.PrivateDnsZoneConfig;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.SubResource;

/**
 * Private dns zone group resource.
 */
@JsonFlatten
public class PrivateDnsZoneGroupInner extends SubResource {
    /**
     * Name of the resource that is unique within a resource group. This name
     * can be used to access the resource.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /**
     * The provisioning state of the private dns zone group resource. Possible
     * values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * A collection of private dns zone configurations of the private dns zone
     * group.
     */
    @JsonProperty(value = "properties.privateDnsZoneConfigs")
    private List<PrivateDnsZoneConfig> privateDnsZoneConfigs;

    /**
     * Get name of the resource that is unique within a resource group. This name can be used to access the resource.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set name of the resource that is unique within a resource group. This name can be used to access the resource.
     *
     * @param name the name value to set
     * @return the PrivateDnsZoneGroupInner object itself.
     */
    public PrivateDnsZoneGroupInner withName(String name) {
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
     * Get the provisioning state of the private dns zone group resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get a collection of private dns zone configurations of the private dns zone group.
     *
     * @return the privateDnsZoneConfigs value
     */
    public List<PrivateDnsZoneConfig> privateDnsZoneConfigs() {
        return this.privateDnsZoneConfigs;
    }

    /**
     * Set a collection of private dns zone configurations of the private dns zone group.
     *
     * @param privateDnsZoneConfigs the privateDnsZoneConfigs value to set
     * @return the PrivateDnsZoneGroupInner object itself.
     */
    public PrivateDnsZoneGroupInner withPrivateDnsZoneConfigs(List<PrivateDnsZoneConfig> privateDnsZoneConfigs) {
        this.privateDnsZoneConfigs = privateDnsZoneConfigs;
        return this;
    }

}
