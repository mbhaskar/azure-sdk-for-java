/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_05_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Properties of the FirewallPolicyNatRuleCollectionAction.
 */
public class FirewallPolicyNatRuleCollectionAction {
    /**
     * The type of action. Possible values include: 'DNAT'.
     */
    @JsonProperty(value = "type")
    private FirewallPolicyNatRuleCollectionActionType type;

    /**
     * Get the type of action. Possible values include: 'DNAT'.
     *
     * @return the type value
     */
    public FirewallPolicyNatRuleCollectionActionType type() {
        return this.type;
    }

    /**
     * Set the type of action. Possible values include: 'DNAT'.
     *
     * @param type the type value to set
     * @return the FirewallPolicyNatRuleCollectionAction object itself.
     */
    public FirewallPolicyNatRuleCollectionAction withType(FirewallPolicyNatRuleCollectionActionType type) {
        this.type = type;
        return this;
    }

}
