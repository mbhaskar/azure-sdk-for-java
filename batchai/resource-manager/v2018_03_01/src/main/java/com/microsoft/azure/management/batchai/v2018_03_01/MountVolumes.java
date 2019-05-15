/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batchai.v2018_03_01;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Details of volumes to mount on the cluster.
 */
public class MountVolumes {
    /**
     * Azure File Share setup configuration.
     * References to Azure File Shares that are to be mounted to the cluster
     * nodes.
     */
    @JsonProperty(value = "azureFileShares")
    private List<AzureFileShareReference> azureFileShares;

    /**
     * Azure Blob FileSystem setup configuration.
     * References to Azure Blob FUSE that are to be mounted to the cluster
     * nodes.
     */
    @JsonProperty(value = "azureBlobFileSystems")
    private List<AzureBlobFileSystemReference> azureBlobFileSystems;

    /**
     * References to a list of file servers that are mounted to the cluster
     * node.
     */
    @JsonProperty(value = "fileServers")
    private List<FileServerReference> fileServers;

    /**
     * References to a list of file servers that are mounted to the cluster
     * node.
     */
    @JsonProperty(value = "unmanagedFileSystems")
    private List<UnmanagedFileSystemReference> unmanagedFileSystems;

    /**
     * Get references to Azure File Shares that are to be mounted to the cluster nodes.
     *
     * @return the azureFileShares value
     */
    public List<AzureFileShareReference> azureFileShares() {
        return this.azureFileShares;
    }

    /**
     * Set references to Azure File Shares that are to be mounted to the cluster nodes.
     *
     * @param azureFileShares the azureFileShares value to set
     * @return the MountVolumes object itself.
     */
    public MountVolumes withAzureFileShares(List<AzureFileShareReference> azureFileShares) {
        this.azureFileShares = azureFileShares;
        return this;
    }

    /**
     * Get references to Azure Blob FUSE that are to be mounted to the cluster nodes.
     *
     * @return the azureBlobFileSystems value
     */
    public List<AzureBlobFileSystemReference> azureBlobFileSystems() {
        return this.azureBlobFileSystems;
    }

    /**
     * Set references to Azure Blob FUSE that are to be mounted to the cluster nodes.
     *
     * @param azureBlobFileSystems the azureBlobFileSystems value to set
     * @return the MountVolumes object itself.
     */
    public MountVolumes withAzureBlobFileSystems(List<AzureBlobFileSystemReference> azureBlobFileSystems) {
        this.azureBlobFileSystems = azureBlobFileSystems;
        return this;
    }

    /**
     * Get the fileServers value.
     *
     * @return the fileServers value
     */
    public List<FileServerReference> fileServers() {
        return this.fileServers;
    }

    /**
     * Set the fileServers value.
     *
     * @param fileServers the fileServers value to set
     * @return the MountVolumes object itself.
     */
    public MountVolumes withFileServers(List<FileServerReference> fileServers) {
        this.fileServers = fileServers;
        return this;
    }

    /**
     * Get the unmanagedFileSystems value.
     *
     * @return the unmanagedFileSystems value
     */
    public List<UnmanagedFileSystemReference> unmanagedFileSystems() {
        return this.unmanagedFileSystems;
    }

    /**
     * Set the unmanagedFileSystems value.
     *
     * @param unmanagedFileSystems the unmanagedFileSystems value to set
     * @return the MountVolumes object itself.
     */
    public MountVolumes withUnmanagedFileSystems(List<UnmanagedFileSystemReference> unmanagedFileSystems) {
        this.unmanagedFileSystems = unmanagedFileSystems;
        return this;
    }

}
