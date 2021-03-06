/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batchai.v2018_05_01.implementation;

import com.microsoft.azure.management.batchai.v2018_05_01.VmPriority;
import com.microsoft.azure.management.batchai.v2018_05_01.ScaleSettings;
import com.microsoft.azure.management.batchai.v2018_05_01.VirtualMachineConfiguration;
import com.microsoft.azure.management.batchai.v2018_05_01.NodeSetup;
import com.microsoft.azure.management.batchai.v2018_05_01.UserAccountSettings;
import com.microsoft.azure.management.batchai.v2018_05_01.ResourceId;
import org.joda.time.DateTime;
import com.microsoft.azure.management.batchai.v2018_05_01.ProvisioningState;
import com.microsoft.azure.management.batchai.v2018_05_01.AllocationState;
import java.util.List;
import com.microsoft.azure.management.batchai.v2018_05_01.BatchAIError;
import com.microsoft.azure.management.batchai.v2018_05_01.NodeStateCounts;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.ProxyResource;

/**
 * Information about a Cluster.
 */
@JsonFlatten
public class ClusterInner extends ProxyResource {
    /**
     * VM size.
     * The size of the virtual machines in the cluster. All nodes in a cluster
     * have the same VM size.
     */
    @JsonProperty(value = "properties.vmSize")
    private String vmSize;

    /**
     * VM priority.
     * VM priority of cluster nodes. Possible values include: 'dedicated',
     * 'lowpriority'.
     */
    @JsonProperty(value = "properties.vmPriority")
    private VmPriority vmPriority;

    /**
     * Scale settings.
     * Scale settings of the cluster.
     */
    @JsonProperty(value = "properties.scaleSettings")
    private ScaleSettings scaleSettings;

    /**
     * VM configuration.
     * Virtual machine configuration (OS image) of the compute nodes. All nodes
     * in a cluster have the same OS image configuration.
     */
    @JsonProperty(value = "properties.virtualMachineConfiguration")
    private VirtualMachineConfiguration virtualMachineConfiguration;

    /**
     * Node setup.
     * Setup (mount file systems, performance counters settings and custom
     * setup task) to be performed on each compute node in the cluster.
     */
    @JsonProperty(value = "properties.nodeSetup")
    private NodeSetup nodeSetup;

    /**
     * User account settings.
     * Administrator user account settings which can be used to SSH to compute
     * nodes.
     */
    @JsonProperty(value = "properties.userAccountSettings")
    private UserAccountSettings userAccountSettings;

    /**
     * Subnet.
     * Virtual network subnet resource ID the cluster nodes belong to.
     */
    @JsonProperty(value = "properties.subnet")
    private ResourceId subnet;

    /**
     * Creation time.
     * The time when the cluster was created.
     */
    @JsonProperty(value = "properties.creationTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime creationTime;

    /**
     * Provisioning state.
     * Provisioning state of the cluster. Possible value are: creating -
     * Specifies that the cluster is being created. succeeded - Specifies that
     * the cluster has been created successfully. failed - Specifies that the
     * cluster creation has failed. deleting - Specifies that the cluster is
     * being deleted. Possible values include: 'creating', 'succeeded',
     * 'failed', 'deleting'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * Provisioning State Transition time.
     * Time when the provisioning state was changed.
     */
    @JsonProperty(value = "properties.provisioningStateTransitionTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime provisioningStateTransitionTime;

    /**
     * Allocation state.
     * Allocation state of the cluster. Possible values are: steady - Indicates
     * that the cluster is not resizing. There are no changes to the number of
     * compute nodes in the cluster in progress. A cluster enters this state
     * when it is created and when no operations are being performed on the
     * cluster to change the number of compute nodes. resizing - Indicates that
     * the cluster is resizing; that is, compute nodes are being added to or
     * removed from the cluster. Possible values include: 'steady', 'resizing'.
     */
    @JsonProperty(value = "properties.allocationState", access = JsonProperty.Access.WRITE_ONLY)
    private AllocationState allocationState;

    /**
     * Allocation state transition time.
     * The time at which the cluster entered its current allocation state.
     */
    @JsonProperty(value = "properties.allocationStateTransitionTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime allocationStateTransitionTime;

    /**
     * Errors.
     * Collection of errors encountered by various compute nodes during node
     * setup.
     */
    @JsonProperty(value = "properties.errors", access = JsonProperty.Access.WRITE_ONLY)
    private List<BatchAIError> errors;

    /**
     * Current node count.
     * The number of compute nodes currently assigned to the cluster.
     */
    @JsonProperty(value = "properties.currentNodeCount", access = JsonProperty.Access.WRITE_ONLY)
    private Integer currentNodeCount;

    /**
     * Node state counts.
     * Counts of various node states on the cluster.
     */
    @JsonProperty(value = "properties.nodeStateCounts", access = JsonProperty.Access.WRITE_ONLY)
    private NodeStateCounts nodeStateCounts;

    /**
     * Get the size of the virtual machines in the cluster. All nodes in a cluster have the same VM size.
     *
     * @return the vmSize value
     */
    public String vmSize() {
        return this.vmSize;
    }

    /**
     * Set the size of the virtual machines in the cluster. All nodes in a cluster have the same VM size.
     *
     * @param vmSize the vmSize value to set
     * @return the ClusterInner object itself.
     */
    public ClusterInner withVmSize(String vmSize) {
        this.vmSize = vmSize;
        return this;
    }

    /**
     * Get vM priority of cluster nodes. Possible values include: 'dedicated', 'lowpriority'.
     *
     * @return the vmPriority value
     */
    public VmPriority vmPriority() {
        return this.vmPriority;
    }

    /**
     * Set vM priority of cluster nodes. Possible values include: 'dedicated', 'lowpriority'.
     *
     * @param vmPriority the vmPriority value to set
     * @return the ClusterInner object itself.
     */
    public ClusterInner withVmPriority(VmPriority vmPriority) {
        this.vmPriority = vmPriority;
        return this;
    }

    /**
     * Get scale settings of the cluster.
     *
     * @return the scaleSettings value
     */
    public ScaleSettings scaleSettings() {
        return this.scaleSettings;
    }

    /**
     * Set scale settings of the cluster.
     *
     * @param scaleSettings the scaleSettings value to set
     * @return the ClusterInner object itself.
     */
    public ClusterInner withScaleSettings(ScaleSettings scaleSettings) {
        this.scaleSettings = scaleSettings;
        return this;
    }

    /**
     * Get virtual machine configuration (OS image) of the compute nodes. All nodes in a cluster have the same OS image configuration.
     *
     * @return the virtualMachineConfiguration value
     */
    public VirtualMachineConfiguration virtualMachineConfiguration() {
        return this.virtualMachineConfiguration;
    }

    /**
     * Set virtual machine configuration (OS image) of the compute nodes. All nodes in a cluster have the same OS image configuration.
     *
     * @param virtualMachineConfiguration the virtualMachineConfiguration value to set
     * @return the ClusterInner object itself.
     */
    public ClusterInner withVirtualMachineConfiguration(VirtualMachineConfiguration virtualMachineConfiguration) {
        this.virtualMachineConfiguration = virtualMachineConfiguration;
        return this;
    }

    /**
     * Get setup (mount file systems, performance counters settings and custom setup task) to be performed on each compute node in the cluster.
     *
     * @return the nodeSetup value
     */
    public NodeSetup nodeSetup() {
        return this.nodeSetup;
    }

    /**
     * Set setup (mount file systems, performance counters settings and custom setup task) to be performed on each compute node in the cluster.
     *
     * @param nodeSetup the nodeSetup value to set
     * @return the ClusterInner object itself.
     */
    public ClusterInner withNodeSetup(NodeSetup nodeSetup) {
        this.nodeSetup = nodeSetup;
        return this;
    }

    /**
     * Get administrator user account settings which can be used to SSH to compute nodes.
     *
     * @return the userAccountSettings value
     */
    public UserAccountSettings userAccountSettings() {
        return this.userAccountSettings;
    }

    /**
     * Set administrator user account settings which can be used to SSH to compute nodes.
     *
     * @param userAccountSettings the userAccountSettings value to set
     * @return the ClusterInner object itself.
     */
    public ClusterInner withUserAccountSettings(UserAccountSettings userAccountSettings) {
        this.userAccountSettings = userAccountSettings;
        return this;
    }

    /**
     * Get virtual network subnet resource ID the cluster nodes belong to.
     *
     * @return the subnet value
     */
    public ResourceId subnet() {
        return this.subnet;
    }

    /**
     * Set virtual network subnet resource ID the cluster nodes belong to.
     *
     * @param subnet the subnet value to set
     * @return the ClusterInner object itself.
     */
    public ClusterInner withSubnet(ResourceId subnet) {
        this.subnet = subnet;
        return this;
    }

    /**
     * Get the time when the cluster was created.
     *
     * @return the creationTime value
     */
    public DateTime creationTime() {
        return this.creationTime;
    }

    /**
     * Get provisioning state of the cluster. Possible value are: creating - Specifies that the cluster is being created. succeeded - Specifies that the cluster has been created successfully. failed - Specifies that the cluster creation has failed. deleting - Specifies that the cluster is being deleted. Possible values include: 'creating', 'succeeded', 'failed', 'deleting'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get time when the provisioning state was changed.
     *
     * @return the provisioningStateTransitionTime value
     */
    public DateTime provisioningStateTransitionTime() {
        return this.provisioningStateTransitionTime;
    }

    /**
     * Get allocation state of the cluster. Possible values are: steady - Indicates that the cluster is not resizing. There are no changes to the number of compute nodes in the cluster in progress. A cluster enters this state when it is created and when no operations are being performed on the cluster to change the number of compute nodes. resizing - Indicates that the cluster is resizing; that is, compute nodes are being added to or removed from the cluster. Possible values include: 'steady', 'resizing'.
     *
     * @return the allocationState value
     */
    public AllocationState allocationState() {
        return this.allocationState;
    }

    /**
     * Get the time at which the cluster entered its current allocation state.
     *
     * @return the allocationStateTransitionTime value
     */
    public DateTime allocationStateTransitionTime() {
        return this.allocationStateTransitionTime;
    }

    /**
     * Get collection of errors encountered by various compute nodes during node setup.
     *
     * @return the errors value
     */
    public List<BatchAIError> errors() {
        return this.errors;
    }

    /**
     * Get the number of compute nodes currently assigned to the cluster.
     *
     * @return the currentNodeCount value
     */
    public Integer currentNodeCount() {
        return this.currentNodeCount;
    }

    /**
     * Get counts of various node states on the cluster.
     *
     * @return the nodeStateCounts value
     */
    public NodeStateCounts nodeStateCounts() {
        return this.nodeStateCounts;
    }

}
