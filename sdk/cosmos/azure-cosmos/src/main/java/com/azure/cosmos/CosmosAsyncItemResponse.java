// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos;

import com.azure.cosmos.implementation.Document;
import com.azure.cosmos.implementation.ResourceResponse;

public class CosmosAsyncItemResponse extends CosmosResponse<CosmosItemProperties> {
    private final CosmosAsyncItem itemClient;

    CosmosAsyncItemResponse(ResourceResponse<Document> response, PartitionKey partitionKey,
                            CosmosAsyncContainer container) {
        super(response);
        if (response.getResource() == null) {
            super.setProperties(null);
            itemClient = null;
        } else {
            super.setProperties(new CosmosItemProperties(response.getResource().toJson()));
            itemClient = new CosmosAsyncItem(response.getResource().getId(), partitionKey, container);
        }
    }

    /**
     * Gets the itemSettings
     *
     * @return the itemSettings
     */
    public CosmosItemProperties getProperties() {
        return super.getProperties();
    }
    
    /**
     * Gets the CosmosAsyncItem
     *
     * @return the cosmos item
     */
    public CosmosAsyncItem getItem() {
        return itemClient;
    }
}
