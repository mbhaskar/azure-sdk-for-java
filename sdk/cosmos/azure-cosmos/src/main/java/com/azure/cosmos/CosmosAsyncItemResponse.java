// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos;

import com.azure.cosmos.implementation.CosmosItemProperties;
import com.azure.cosmos.implementation.Document;
import com.azure.cosmos.implementation.ResourceResponse;
import com.azure.cosmos.implementation.Utils;

import java.time.Duration;
import java.util.Map;

/**
 * The type Cosmos async item response. This contains the item and response methods
 *
 * @param <T> the type parameter
 */
public class CosmosAsyncItemResponse<T> {
    private final Class<T> itemClassType;
    private final byte[] responseBodyAsByteArray;
    private T item;
    private final ResourceResponse<Document> resourceResponse;
    private CosmosItemProperties props;

    CosmosAsyncItemResponse(ResourceResponse<Document> response, Class<T> classType) {
        this.itemClassType = classType;
        this.responseBodyAsByteArray = response.getBodyAsByteArray();
        this.resourceResponse = response;
    }

    /**
     * Gets the resource .
     *
     * @return the resource
     */
    public T getResource() {
        if (item != null) {
            return item;
        }

        if (this.itemClassType == CosmosItemProperties.class) {
            item = (T) getProperties();
            return item;
        }

        if (item == null) {
            synchronized (this) {
                if (item == null && !Utils.isEmpty(responseBodyAsByteArray)) {
                    item = Utils.parse(responseBodyAsByteArray, itemClassType);
                }
            }
        }

        return item;
    }

    /**
     * Gets the itemProperties
     *
     * @return the itemProperties
     */
    CosmosItemProperties getProperties() {
        ensureCosmosItemPropertiesInitialized();
        return props;
    }

    private void ensureCosmosItemPropertiesInitialized() {
        synchronized (this) {
            if (Utils.isEmpty(responseBodyAsByteArray)) {
                props = null;
            } else {
                props = new CosmosItemProperties(responseBodyAsByteArray);
            }

        }
    }

    /**
     * Gets the maximum size limit for this entity (in megabytes (MB) for server resources and in count for master
     * resources).
     *
     * @return the max resource quota.
     */
    public String getMaxResourceQuota() {
        return resourceResponse.getMaxResourceQuota();
    }

    /**
     * Gets the current size of this entity (in megabytes (MB) for server resources and in count for master resources)
     *
     * @return the current resource quota usage.
     */
    public String getCurrentResourceQuotaUsage() {
        return resourceResponse.getCurrentResourceQuotaUsage();
    }

    /**
     * Gets the Activity ID for the request.
     *
     * @return the activity getId.
     */
    public String getActivityId() {
        return resourceResponse.getActivityId();
    }

    /**
     * Gets the number of index paths (terms) generated by the operation.
     *
     * @return the request charge.
     */
    public double getRequestCharge() {
        return resourceResponse.getRequestCharge();
    }

    /**
     * Gets the HTTP status code associated with the response.
     *
     * @return the status code.
     */
    public int getStatusCode() {
        return resourceResponse.getStatusCode();
    }

    /**
     * Gets the token used for managing client's consistency requirements.
     *
     * @return the session token.
     */
    public String getSessionToken() {
        return resourceResponse.getSessionToken();
    }

    /**
     * Gets the headers associated with the response.
     *
     * @return the response headers.
     */
    public Map<String, String> getResponseHeaders() {
        return resourceResponse.getResponseHeaders();
    }

    /**
     * Gets the diagnostics information for the current request to Azure Cosmos DB service.
     *
     * @return diagnostics information for the current request to Azure Cosmos DB service.
     */
    public CosmosResponseDiagnostics getCosmosResponseDiagnostics() {
        return resourceResponse.getCosmosResponseDiagnostics();
    }

    /**
     * Gets the end-to-end request latency for the current request to Azure Cosmos DB service.
     *
     * @return end-to-end request latency for the current request to Azure Cosmos DB service.
     */
    public Duration getRequestLatency() {
        return resourceResponse.getRequestLatency();
    }
}
