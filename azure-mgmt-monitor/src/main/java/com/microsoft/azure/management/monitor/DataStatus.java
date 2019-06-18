/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for DataStatus.
 */
public final class DataStatus extends ExpandableStringEnum<DataStatus> {
    /** Static value present for DataStatus. */
    public static final DataStatus PRESENT = fromString("present");

    /** Static value notPresent for DataStatus. */
    public static final DataStatus NOT_PRESENT = fromString("notPresent");

    /**
     * Creates or finds a DataStatus from its string representation.
     * @param name a name to look for
     * @return the corresponding DataStatus
     */
    @JsonCreator
    public static DataStatus fromString(String name) {
        return fromString(name, DataStatus.class);
    }

    /**
     * @return known DataStatus values
     */
    public static Collection<DataStatus> values() {
        return values(DataStatus.class);
    }
}
