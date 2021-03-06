/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.logic.v2018_07_01_preview.implementation;

import com.microsoft.azure.management.logic.v2018_07_01_preview.WorkflowTriggerProvisioningState;
import org.joda.time.DateTime;
import com.microsoft.azure.management.logic.v2018_07_01_preview.WorkflowState;
import com.microsoft.azure.management.logic.v2018_07_01_preview.WorkflowStatus;
import com.microsoft.azure.management.logic.v2018_07_01_preview.WorkflowTriggerRecurrence;
import com.microsoft.azure.management.logic.v2018_07_01_preview.ResourceReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.SubResource;

/**
 * The workflow trigger.
 */
@JsonFlatten
public class WorkflowTriggerInner extends SubResource {
    /**
     * Gets the provisioning state. Possible values include: 'NotSpecified',
     * 'Accepted', 'Running', 'Ready', 'Creating', 'Created', 'Deleting',
     * 'Deleted', 'Canceled', 'Failed', 'Succeeded', 'Moving', 'Updating',
     * 'Registering', 'Registered', 'Unregistering', 'Unregistered',
     * 'Completed'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private WorkflowTriggerProvisioningState provisioningState;

    /**
     * Gets the created time.
     */
    @JsonProperty(value = "properties.createdTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime createdTime;

    /**
     * Gets the changed time.
     */
    @JsonProperty(value = "properties.changedTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime changedTime;

    /**
     * Gets the state. Possible values include: 'NotSpecified', 'Completed',
     * 'Enabled', 'Disabled', 'Deleted', 'Suspended'.
     */
    @JsonProperty(value = "properties.state", access = JsonProperty.Access.WRITE_ONLY)
    private WorkflowState state;

    /**
     * Gets the status. Possible values include: 'NotSpecified', 'Paused',
     * 'Running', 'Waiting', 'Succeeded', 'Skipped', 'Suspended', 'Cancelled',
     * 'Failed', 'Faulted', 'TimedOut', 'Aborted', 'Ignored'.
     */
    @JsonProperty(value = "properties.status", access = JsonProperty.Access.WRITE_ONLY)
    private WorkflowStatus status;

    /**
     * Gets the last execution time.
     */
    @JsonProperty(value = "properties.lastExecutionTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime lastExecutionTime;

    /**
     * Gets the next execution time.
     */
    @JsonProperty(value = "properties.nextExecutionTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime nextExecutionTime;

    /**
     * Gets the workflow trigger recurrence.
     */
    @JsonProperty(value = "properties.recurrence", access = JsonProperty.Access.WRITE_ONLY)
    private WorkflowTriggerRecurrence recurrence;

    /**
     * Gets the reference to workflow.
     */
    @JsonProperty(value = "properties.workflow", access = JsonProperty.Access.WRITE_ONLY)
    private ResourceReference workflow;

    /**
     * Gets the workflow trigger name.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /**
     * Gets the workflow trigger type.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    /**
     * Get gets the provisioning state. Possible values include: 'NotSpecified', 'Accepted', 'Running', 'Ready', 'Creating', 'Created', 'Deleting', 'Deleted', 'Canceled', 'Failed', 'Succeeded', 'Moving', 'Updating', 'Registering', 'Registered', 'Unregistering', 'Unregistered', 'Completed'.
     *
     * @return the provisioningState value
     */
    public WorkflowTriggerProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get gets the created time.
     *
     * @return the createdTime value
     */
    public DateTime createdTime() {
        return this.createdTime;
    }

    /**
     * Get gets the changed time.
     *
     * @return the changedTime value
     */
    public DateTime changedTime() {
        return this.changedTime;
    }

    /**
     * Get gets the state. Possible values include: 'NotSpecified', 'Completed', 'Enabled', 'Disabled', 'Deleted', 'Suspended'.
     *
     * @return the state value
     */
    public WorkflowState state() {
        return this.state;
    }

    /**
     * Get gets the status. Possible values include: 'NotSpecified', 'Paused', 'Running', 'Waiting', 'Succeeded', 'Skipped', 'Suspended', 'Cancelled', 'Failed', 'Faulted', 'TimedOut', 'Aborted', 'Ignored'.
     *
     * @return the status value
     */
    public WorkflowStatus status() {
        return this.status;
    }

    /**
     * Get gets the last execution time.
     *
     * @return the lastExecutionTime value
     */
    public DateTime lastExecutionTime() {
        return this.lastExecutionTime;
    }

    /**
     * Get gets the next execution time.
     *
     * @return the nextExecutionTime value
     */
    public DateTime nextExecutionTime() {
        return this.nextExecutionTime;
    }

    /**
     * Get gets the workflow trigger recurrence.
     *
     * @return the recurrence value
     */
    public WorkflowTriggerRecurrence recurrence() {
        return this.recurrence;
    }

    /**
     * Get gets the reference to workflow.
     *
     * @return the workflow value
     */
    public ResourceReference workflow() {
        return this.workflow;
    }

    /**
     * Get gets the workflow trigger name.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Get gets the workflow trigger type.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

}
