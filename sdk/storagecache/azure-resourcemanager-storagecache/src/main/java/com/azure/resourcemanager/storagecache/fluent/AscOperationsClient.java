// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagecache.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.storagecache.fluent.models.AscOperationInner;

/** An instance of this class provides access to all the operations defined in AscOperationsClient. */
public interface AscOperationsClient {
    /**
     * Gets the status of an asynchronous operation for the Azure HPC Cache.
     *
     * @param location The name of the region used to look up the operation.
     * @param operationId The operation id which uniquely identifies the asynchronous operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the status of an asynchronous operation for the Azure HPC Cache.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AscOperationInner get(String location, String operationId);

    /**
     * Gets the status of an asynchronous operation for the Azure HPC Cache.
     *
     * @param location The name of the region used to look up the operation.
     * @param operationId The operation id which uniquely identifies the asynchronous operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the status of an asynchronous operation for the Azure HPC Cache.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<AscOperationInner> getWithResponse(String location, String operationId, Context context);
}
