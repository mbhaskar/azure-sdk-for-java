// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.search.documents.indexes.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

/**
 * A token filter that only keeps tokens with text contained in a specified
 * list of words. This token filter is implemented using Apache Lucene.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata.type")
@JsonTypeName("#Microsoft.Azure.Search.KeepTokenFilter")
@Fluent
public final class KeepTokenFilter extends TokenFilter {
    /*
     * The list of words to keep.
     */
    @JsonProperty(value = "keepWords", required = true)
    private List<String> keepWords;

    /*
     * A value indicating whether to lower case all words first. Default is
     * false.
     */
    @JsonProperty(value = "keepWordsCase")
    private Boolean lowerCaseKeepWords;

    /**
     * Get the keepWords property: The list of words to keep.
     *
     * @return the keepWords value.
     */
    public List<String> getKeepWords() {
        return this.keepWords;
    }

    /**
     * Set the keepWords property: The list of words to keep.
     *
     * @param keepWords the keepWords value to set.
     * @return the KeepTokenFilter object itself.
     */
    public KeepTokenFilter setKeepWords(List<String> keepWords) {
        this.keepWords = keepWords;
        return this;
    }

    /**
     * Get the lowerCaseKeepWords property: A value indicating whether to lower
     * case all words first. Default is false.
     *
     * @return the lowerCaseKeepWords value.
     */
    public Boolean isLowerCaseKeepWords() {
        return this.lowerCaseKeepWords;
    }

    /**
     * Set the lowerCaseKeepWords property: A value indicating whether to lower
     * case all words first. Default is false.
     *
     * @param lowerCaseKeepWords the lowerCaseKeepWords value to set.
     * @return the KeepTokenFilter object itself.
     */
    public KeepTokenFilter setLowerCaseKeepWords(Boolean lowerCaseKeepWords) {
        this.lowerCaseKeepWords = lowerCaseKeepWords;
        return this;
    }
}
