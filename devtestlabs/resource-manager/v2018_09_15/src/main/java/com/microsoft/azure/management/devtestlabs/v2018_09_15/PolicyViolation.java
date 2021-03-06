/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlabs.v2018_09_15;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Policy violation.
 */
public class PolicyViolation {
    /**
     * The code of the policy violation.
     */
    @JsonProperty(value = "code")
    private String code;

    /**
     * The message of the policy violation.
     */
    @JsonProperty(value = "message")
    private String message;

    /**
     * Get the code of the policy violation.
     *
     * @return the code value
     */
    public String code() {
        return this.code;
    }

    /**
     * Set the code of the policy violation.
     *
     * @param code the code value to set
     * @return the PolicyViolation object itself.
     */
    public PolicyViolation withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get the message of the policy violation.
     *
     * @return the message value
     */
    public String message() {
        return this.message;
    }

    /**
     * Set the message of the policy violation.
     *
     * @param message the message value to set
     * @return the PolicyViolation object itself.
     */
    public PolicyViolation withMessage(String message) {
        this.message = message;
        return this;
    }

}
