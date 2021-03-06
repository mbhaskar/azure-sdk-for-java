/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.v2017_03_01_preview;

import rx.Observable;
import com.microsoft.azure.management.sql.v2017_03_01_preview.implementation.ServerAutomaticTuningInner;
import com.microsoft.azure.management.sql.v2017_03_01_preview.implementation.ServerAutomaticTuningsInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing ServerAutomaticTunings.
 */
public interface ServerAutomaticTunings extends HasInner<ServerAutomaticTuningsInner> {
    /**
     * Retrieves server automatic tuning options.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ServerAutomaticTuning> getAsync(String resourceGroupName, String serverName);

    /**
     * Update automatic tuning options on server.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param parameters The requested automatic tuning resource state.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ServerAutomaticTuning> updateAsync(String resourceGroupName, String serverName, ServerAutomaticTuningInner parameters);

}
