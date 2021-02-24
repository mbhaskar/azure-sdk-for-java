// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.storage.fluent.models.ListQueueInner;
import com.azure.resourcemanager.storage.fluent.models.StorageQueueInner;
import java.util.Map;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in QueuesClient. */
public interface QueuesClient {
    /**
     * Creates a new queue with the specified queue name, under the specified account.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @param metadata A name-value pair that represents queue metadata.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<StorageQueueInner>> createWithResponseAsync(
        String resourceGroupName, String accountName, String queueName, Map<String, String> metadata);

    /**
     * Creates a new queue with the specified queue name, under the specified account.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @param metadata A name-value pair that represents queue metadata.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<StorageQueueInner> createAsync(
        String resourceGroupName, String accountName, String queueName, Map<String, String> metadata);

    /**
     * Creates a new queue with the specified queue name, under the specified account.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<StorageQueueInner> createAsync(String resourceGroupName, String accountName, String queueName);

    /**
     * Creates a new queue with the specified queue name, under the specified account.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    StorageQueueInner create(String resourceGroupName, String accountName, String queueName);

    /**
     * Creates a new queue with the specified queue name, under the specified account.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @param metadata A name-value pair that represents queue metadata.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<StorageQueueInner> createWithResponse(
        String resourceGroupName, String accountName, String queueName, Map<String, String> metadata, Context context);

    /**
     * Creates a new queue with the specified queue name, under the specified account.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @param metadata A name-value pair that represents queue metadata.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<StorageQueueInner>> updateWithResponseAsync(
        String resourceGroupName, String accountName, String queueName, Map<String, String> metadata);

    /**
     * Creates a new queue with the specified queue name, under the specified account.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @param metadata A name-value pair that represents queue metadata.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<StorageQueueInner> updateAsync(
        String resourceGroupName, String accountName, String queueName, Map<String, String> metadata);

    /**
     * Creates a new queue with the specified queue name, under the specified account.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<StorageQueueInner> updateAsync(String resourceGroupName, String accountName, String queueName);

    /**
     * Creates a new queue with the specified queue name, under the specified account.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    StorageQueueInner update(String resourceGroupName, String accountName, String queueName);

    /**
     * Creates a new queue with the specified queue name, under the specified account.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @param metadata A name-value pair that represents queue metadata.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<StorageQueueInner> updateWithResponse(
        String resourceGroupName, String accountName, String queueName, Map<String, String> metadata, Context context);

    /**
     * Gets the queue with the specified queue name, under the specified account if it exists.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the queue with the specified queue name, under the specified account if it exists.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<StorageQueueInner>> getWithResponseAsync(
        String resourceGroupName, String accountName, String queueName);

    /**
     * Gets the queue with the specified queue name, under the specified account if it exists.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the queue with the specified queue name, under the specified account if it exists.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<StorageQueueInner> getAsync(String resourceGroupName, String accountName, String queueName);

    /**
     * Gets the queue with the specified queue name, under the specified account if it exists.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the queue with the specified queue name, under the specified account if it exists.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    StorageQueueInner get(String resourceGroupName, String accountName, String queueName);

    /**
     * Gets the queue with the specified queue name, under the specified account if it exists.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the queue with the specified queue name, under the specified account if it exists.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<StorageQueueInner> getWithResponse(
        String resourceGroupName, String accountName, String queueName, Context context);

    /**
     * Deletes the queue with the specified queue name, under the specified account if it exists.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Void>> deleteWithResponseAsync(String resourceGroupName, String accountName, String queueName);

    /**
     * Deletes the queue with the specified queue name, under the specified account if it exists.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> deleteAsync(String resourceGroupName, String accountName, String queueName);

    /**
     * Deletes the queue with the specified queue name, under the specified account if it exists.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String accountName, String queueName);

    /**
     * Deletes the queue with the specified queue name, under the specified account if it exists.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param queueName A queue name must be unique within a storage account and must be between 3 and 63 characters.The
     *     name must comprise of lowercase alphanumeric and dash(-) characters only, it should begin and end with an
     *     alphanumeric character and it cannot have two consecutive dash(-) characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String resourceGroupName, String accountName, String queueName, Context context);

    /**
     * Gets a list of all the queues under the specified storage account.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param maxpagesize Optional, a maximum number of queues that should be included in a list queue response.
     * @param filter Optional, When specified, only the queues with a name starting with the given filter will be
     *     listed.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of all the queues under the specified storage account.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<ListQueueInner> listAsync(
        String resourceGroupName, String accountName, String maxpagesize, String filter);

    /**
     * Gets a list of all the queues under the specified storage account.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of all the queues under the specified storage account.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<ListQueueInner> listAsync(String resourceGroupName, String accountName);

    /**
     * Gets a list of all the queues under the specified storage account.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of all the queues under the specified storage account.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ListQueueInner> list(String resourceGroupName, String accountName);

    /**
     * Gets a list of all the queues under the specified storage account.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param accountName The name of the storage account within the specified resource group. Storage account names
     *     must be between 3 and 24 characters in length and use numbers and lower-case letters only.
     * @param maxpagesize Optional, a maximum number of queues that should be included in a list queue response.
     * @param filter Optional, When specified, only the queues with a name starting with the given filter will be
     *     listed.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of all the queues under the specified storage account.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ListQueueInner> list(
        String resourceGroupName, String accountName, String maxpagesize, String filter, Context context);
}
