/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.kusto.v2020_02_15;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The result returned from a data connection validation request.
 */
public class DataConnectionValidationResult {
    /**
     * A message which indicates a problem in data connection validation.
     */
    @JsonProperty(value = "errorMessage")
    private String errorMessage;

    /**
     * Get a message which indicates a problem in data connection validation.
     *
     * @return the errorMessage value
     */
    public String errorMessage() {
        return this.errorMessage;
    }

    /**
     * Set a message which indicates a problem in data connection validation.
     *
     * @param errorMessage the errorMessage value to set
     * @return the DataConnectionValidationResult object itself.
     */
    public DataConnectionValidationResult withErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

}
