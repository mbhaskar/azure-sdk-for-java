// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.PollerFlux;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.network.fluent.models.ExpressRoutePortInner;
import com.azure.resourcemanager.network.fluent.models.GenerateExpressRoutePortsLoaResultInner;
import com.azure.resourcemanager.resources.fluentcore.collection.InnerSupportsDelete;
import com.azure.resourcemanager.resources.fluentcore.collection.InnerSupportsGet;
import com.azure.resourcemanager.resources.fluentcore.collection.InnerSupportsListing;
import java.nio.ByteBuffer;
import java.util.Map;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in ExpressRoutePortsClient. */
public interface ExpressRoutePortsClient
    extends InnerSupportsGet<ExpressRoutePortInner>,
        InnerSupportsListing<ExpressRoutePortInner>,
        InnerSupportsDelete<Void> {
    /**
     * Deletes the specified ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Flux<ByteBuffer>>> deleteWithResponseAsync(String resourceGroupName, String expressRoutePortName);

    /**
     * Deletes the specified ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    PollerFlux<PollResult<Void>, Void> beginDeleteAsync(String resourceGroupName, String expressRoutePortName);

    /**
     * Deletes the specified ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String expressRoutePortName);

    /**
     * Deletes the specified ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<Void>, Void> beginDelete(
        String resourceGroupName, String expressRoutePortName, Context context);

    /**
     * Deletes the specified ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> deleteAsync(String resourceGroupName, String expressRoutePortName);

    /**
     * Deletes the specified ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String expressRoutePortName);

    /**
     * Deletes the specified ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String expressRoutePortName, Context context);

    /**
     * Retrieves the requested ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of ExpressRoutePort.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<ExpressRoutePortInner>> getByResourceGroupWithResponseAsync(
        String resourceGroupName, String expressRoutePortName);

    /**
     * Retrieves the requested ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of ExpressRoutePort.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<ExpressRoutePortInner> getByResourceGroupAsync(String resourceGroupName, String expressRoutePortName);

    /**
     * Retrieves the requested ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of ExpressRoutePort.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ExpressRoutePortInner getByResourceGroup(String resourceGroupName, String expressRoutePortName);

    /**
     * Retrieves the requested ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of ExpressRoutePort.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ExpressRoutePortInner> getByResourceGroupWithResponse(
        String resourceGroupName, String expressRoutePortName, Context context);

    /**
     * Creates or updates the specified ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @param parameters Parameters supplied to the create ExpressRoutePort operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Flux<ByteBuffer>>> createOrUpdateWithResponseAsync(
        String resourceGroupName, String expressRoutePortName, ExpressRoutePortInner parameters);

    /**
     * Creates or updates the specified ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @param parameters Parameters supplied to the create ExpressRoutePort operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    PollerFlux<PollResult<ExpressRoutePortInner>, ExpressRoutePortInner> beginCreateOrUpdateAsync(
        String resourceGroupName, String expressRoutePortName, ExpressRoutePortInner parameters);

    /**
     * Creates or updates the specified ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @param parameters Parameters supplied to the create ExpressRoutePort operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<ExpressRoutePortInner>, ExpressRoutePortInner> beginCreateOrUpdate(
        String resourceGroupName, String expressRoutePortName, ExpressRoutePortInner parameters);

    /**
     * Creates or updates the specified ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @param parameters Parameters supplied to the create ExpressRoutePort operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<ExpressRoutePortInner>, ExpressRoutePortInner> beginCreateOrUpdate(
        String resourceGroupName, String expressRoutePortName, ExpressRoutePortInner parameters, Context context);

    /**
     * Creates or updates the specified ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @param parameters Parameters supplied to the create ExpressRoutePort operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<ExpressRoutePortInner> createOrUpdateAsync(
        String resourceGroupName, String expressRoutePortName, ExpressRoutePortInner parameters);

    /**
     * Creates or updates the specified ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @param parameters Parameters supplied to the create ExpressRoutePort operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ExpressRoutePortInner createOrUpdate(
        String resourceGroupName, String expressRoutePortName, ExpressRoutePortInner parameters);

    /**
     * Creates or updates the specified ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @param parameters Parameters supplied to the create ExpressRoutePort operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ExpressRoutePortInner createOrUpdate(
        String resourceGroupName, String expressRoutePortName, ExpressRoutePortInner parameters, Context context);

    /**
     * Update ExpressRoutePort tags.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @param tags Resource tags.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<ExpressRoutePortInner>> updateTagsWithResponseAsync(
        String resourceGroupName, String expressRoutePortName, Map<String, String> tags);

    /**
     * Update ExpressRoutePort tags.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @param tags Resource tags.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<ExpressRoutePortInner> updateTagsAsync(
        String resourceGroupName, String expressRoutePortName, Map<String, String> tags);

    /**
     * Update ExpressRoutePort tags.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<ExpressRoutePortInner> updateTagsAsync(String resourceGroupName, String expressRoutePortName);

    /**
     * Update ExpressRoutePort tags.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ExpressRoutePortInner updateTags(String resourceGroupName, String expressRoutePortName);

    /**
     * Update ExpressRoutePort tags.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of the ExpressRoutePort resource.
     * @param tags Resource tags.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return expressRoutePort resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ExpressRoutePortInner> updateTagsWithResponse(
        String resourceGroupName, String expressRoutePortName, Map<String, String> tags, Context context);

    /**
     * List all the ExpressRoutePort resources in the specified resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for ListExpressRoutePorts API service call.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<ExpressRoutePortInner> listByResourceGroupAsync(String resourceGroupName);

    /**
     * List all the ExpressRoutePort resources in the specified resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for ListExpressRoutePorts API service call.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ExpressRoutePortInner> listByResourceGroup(String resourceGroupName);

    /**
     * List all the ExpressRoutePort resources in the specified resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for ListExpressRoutePorts API service call.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ExpressRoutePortInner> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * List all the ExpressRoutePort resources in the specified subscription.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for ListExpressRoutePorts API service call.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<ExpressRoutePortInner> listAsync();

    /**
     * List all the ExpressRoutePort resources in the specified subscription.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for ListExpressRoutePorts API service call.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ExpressRoutePortInner> list();

    /**
     * List all the ExpressRoutePort resources in the specified subscription.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for ListExpressRoutePorts API service call.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ExpressRoutePortInner> list(Context context);

    /**
     * Generate a letter of authorization for the requested ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of ExpressRoutePort.
     * @param customerName The customer name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for GenerateExpressRoutePortsLOA API service call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<GenerateExpressRoutePortsLoaResultInner>> generateLoaWithResponseAsync(
        String resourceGroupName, String expressRoutePortName, String customerName);

    /**
     * Generate a letter of authorization for the requested ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of ExpressRoutePort.
     * @param customerName The customer name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for GenerateExpressRoutePortsLOA API service call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<GenerateExpressRoutePortsLoaResultInner> generateLoaAsync(
        String resourceGroupName, String expressRoutePortName, String customerName);

    /**
     * Generate a letter of authorization for the requested ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of ExpressRoutePort.
     * @param customerName The customer name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for GenerateExpressRoutePortsLOA API service call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    GenerateExpressRoutePortsLoaResultInner generateLoa(
        String resourceGroupName, String expressRoutePortName, String customerName);

    /**
     * Generate a letter of authorization for the requested ExpressRoutePort resource.
     *
     * @param resourceGroupName The name of the resource group.
     * @param expressRoutePortName The name of ExpressRoutePort.
     * @param customerName The customer name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return response for GenerateExpressRoutePortsLOA API service call.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<GenerateExpressRoutePortsLoaResultInner> generateLoaWithResponse(
        String resourceGroupName, String expressRoutePortName, String customerName, Context context);
}
