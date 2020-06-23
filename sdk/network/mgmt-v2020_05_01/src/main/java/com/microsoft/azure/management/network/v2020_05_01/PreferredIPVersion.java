/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_05_01;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for PreferredIPVersion.
 */
public final class PreferredIPVersion extends ExpandableStringEnum<PreferredIPVersion> {
    /** Static value IPv4 for PreferredIPVersion. */
    public static final PreferredIPVersion IPV4 = fromString("IPv4");

    /** Static value IPv6 for PreferredIPVersion. */
    public static final PreferredIPVersion IPV6 = fromString("IPv6");

    /**
     * Creates or finds a PreferredIPVersion from its string representation.
     * @param name a name to look for
     * @return the corresponding PreferredIPVersion
     */
    @JsonCreator
    public static PreferredIPVersion fromString(String name) {
        return fromString(name, PreferredIPVersion.class);
    }

    /**
     * @return known PreferredIPVersion values
     */
    public static Collection<PreferredIPVersion> values() {
        return values(PreferredIPVersion.class);
    }
}
