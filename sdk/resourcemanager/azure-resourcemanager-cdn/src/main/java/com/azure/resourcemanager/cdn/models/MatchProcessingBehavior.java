// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for MatchProcessingBehavior. */
public final class MatchProcessingBehavior extends ExpandableStringEnum<MatchProcessingBehavior> {
    /** Static value Continue for MatchProcessingBehavior. */
    public static final MatchProcessingBehavior CONTINUE = fromString("Continue");

    /** Static value Stop for MatchProcessingBehavior. */
    public static final MatchProcessingBehavior STOP = fromString("Stop");

    /**
     * Creates or finds a MatchProcessingBehavior from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding MatchProcessingBehavior.
     */
    @JsonCreator
    public static MatchProcessingBehavior fromString(String name) {
        return fromString(name, MatchProcessingBehavior.class);
    }

    /** @return known MatchProcessingBehavior values. */
    public static Collection<MatchProcessingBehavior> values() {
        return values(MatchProcessingBehavior.class);
    }
}
