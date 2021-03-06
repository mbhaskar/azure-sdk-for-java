/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute.v2017_12_01;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes a virtual machine scale set OS profile.
 */
public class VirtualMachineScaleSetUpdateOSProfile {
    /**
     * A base-64 encoded string of custom data.
     */
    @JsonProperty(value = "customData")
    private String customData;

    /**
     * The Windows Configuration of the OS profile.
     */
    @JsonProperty(value = "windowsConfiguration")
    private WindowsConfiguration windowsConfiguration;

    /**
     * The Linux Configuration of the OS profile.
     */
    @JsonProperty(value = "linuxConfiguration")
    private LinuxConfiguration linuxConfiguration;

    /**
     * The List of certificates for addition to the VM.
     */
    @JsonProperty(value = "secrets")
    private List<VaultSecretGroup> secrets;

    /**
     * Get the customData value.
     *
     * @return the customData value
     */
    public String customData() {
        return this.customData;
    }

    /**
     * Set the customData value.
     *
     * @param customData the customData value to set
     * @return the VirtualMachineScaleSetUpdateOSProfile object itself.
     */
    public VirtualMachineScaleSetUpdateOSProfile withCustomData(String customData) {
        this.customData = customData;
        return this;
    }

    /**
     * Get the windowsConfiguration value.
     *
     * @return the windowsConfiguration value
     */
    public WindowsConfiguration windowsConfiguration() {
        return this.windowsConfiguration;
    }

    /**
     * Set the windowsConfiguration value.
     *
     * @param windowsConfiguration the windowsConfiguration value to set
     * @return the VirtualMachineScaleSetUpdateOSProfile object itself.
     */
    public VirtualMachineScaleSetUpdateOSProfile withWindowsConfiguration(WindowsConfiguration windowsConfiguration) {
        this.windowsConfiguration = windowsConfiguration;
        return this;
    }

    /**
     * Get the linuxConfiguration value.
     *
     * @return the linuxConfiguration value
     */
    public LinuxConfiguration linuxConfiguration() {
        return this.linuxConfiguration;
    }

    /**
     * Set the linuxConfiguration value.
     *
     * @param linuxConfiguration the linuxConfiguration value to set
     * @return the VirtualMachineScaleSetUpdateOSProfile object itself.
     */
    public VirtualMachineScaleSetUpdateOSProfile withLinuxConfiguration(LinuxConfiguration linuxConfiguration) {
        this.linuxConfiguration = linuxConfiguration;
        return this;
    }

    /**
     * Get the secrets value.
     *
     * @return the secrets value
     */
    public List<VaultSecretGroup> secrets() {
        return this.secrets;
    }

    /**
     * Set the secrets value.
     *
     * @param secrets the secrets value to set
     * @return the VirtualMachineScaleSetUpdateOSProfile object itself.
     */
    public VirtualMachineScaleSetUpdateOSProfile withSecrets(List<VaultSecretGroup> secrets) {
        this.secrets = secrets;
        return this;
    }

}
