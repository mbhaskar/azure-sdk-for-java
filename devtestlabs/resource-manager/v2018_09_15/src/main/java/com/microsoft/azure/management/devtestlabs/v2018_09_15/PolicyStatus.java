/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlabs.v2018_09_15;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for PolicyStatus.
 */
public final class PolicyStatus extends ExpandableStringEnum<PolicyStatus> {
    /** Static value Enabled for PolicyStatus. */
    public static final PolicyStatus ENABLED = fromString("Enabled");

    /** Static value Disabled for PolicyStatus. */
    public static final PolicyStatus DISABLED = fromString("Disabled");

    /**
     * Creates or finds a PolicyStatus from its string representation.
     * @param name a name to look for
     * @return the corresponding PolicyStatus
     */
    @JsonCreator
    public static PolicyStatus fromString(String name) {
        return fromString(name, PolicyStatus.class);
    }

    /**
     * @return known PolicyStatus values
     */
    public static Collection<PolicyStatus> values() {
        return values(PolicyStatus.class);
    }
}
