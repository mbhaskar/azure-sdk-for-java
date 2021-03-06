/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.v2019_01_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.apimanagement.v2019_01_01.implementation.ApiVersionSetContractInner;
import com.microsoft.azure.arm.model.Indexable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.apimanagement.v2019_01_01.implementation.ApiManagementManager;

/**
 * Type representing ApiVersionSetContract.
 */
public interface ApiVersionSetContract extends HasInner<ApiVersionSetContractInner>, Indexable, Updatable<ApiVersionSetContract.Update>, HasManager<ApiManagementManager> {
    /**
     * @return the description value.
     */
    String description();

    /**
     * @return the displayName value.
     */
    String displayName();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the type value.
     */
    String type();

    /**
     * @return the versionHeaderName value.
     */
    String versionHeaderName();

    /**
     * @return the versioningScheme value.
     */
    VersioningScheme versioningScheme();

    /**
     * @return the versionQueryName value.
     */
    String versionQueryName();

    /**
     * The entirety of the ApiVersionSetContract definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithResourceGroupName, DefinitionStages.WithServiceName, DefinitionStages.WithIfMatch, DefinitionStages.WithDisplayName, DefinitionStages.WithVersioningScheme, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of ApiVersionSetContract definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a ApiVersionSetContract definition.
         */
        interface Blank extends WithResourceGroupName {
        }

        /**
         * The stage of the apiversionsetcontract definition allowing to specify ResourceGroupName.
         */
        interface WithResourceGroupName {
           /**
            * Specifies resourceGroupName.
            * @param resourceGroupName The name of the resource group
            * @return the next definition stage
            */
            WithServiceName withResourceGroupName(String resourceGroupName);
        }

        /**
         * The stage of the apiversionsetcontract definition allowing to specify ServiceName.
         */
        interface WithServiceName {
           /**
            * Specifies serviceName.
            * @param serviceName The name of the API Management service
            * @return the next definition stage
            */
            WithIfMatch withServiceName(String serviceName);
        }

        /**
         * The stage of the apiversionsetcontract definition allowing to specify IfMatch.
         */
        interface WithIfMatch {
           /**
            * Specifies ifMatch.
            * @param ifMatch ETag of the Entity. Not required when creating an entity, but required when updating an entity
            * @return the next definition stage
            */
            WithDisplayName withIfMatch(String ifMatch);
        }

        /**
         * The stage of the apiversionsetcontract definition allowing to specify DisplayName.
         */
        interface WithDisplayName {
           /**
            * Specifies displayName.
            * @param displayName Name of API Version Set
            * @return the next definition stage
            */
            WithVersioningScheme withDisplayName(String displayName);
        }

        /**
         * The stage of the apiversionsetcontract definition allowing to specify VersioningScheme.
         */
        interface WithVersioningScheme {
           /**
            * Specifies versioningScheme.
            * @param versioningScheme An value that determines where the API Version identifer will be located in a HTTP request. Possible values include: 'Segment', 'Query', 'Header'
            * @return the next definition stage
            */
            WithCreate withVersioningScheme(VersioningScheme versioningScheme);
        }

        /**
         * The stage of the apiversionsetcontract definition allowing to specify Description.
         */
        interface WithDescription {
            /**
             * Specifies description.
             * @param description Description of API Version Set
             * @return the next definition stage
             */
            WithCreate withDescription(String description);
        }

        /**
         * The stage of the apiversionsetcontract definition allowing to specify VersionHeaderName.
         */
        interface WithVersionHeaderName {
            /**
             * Specifies versionHeaderName.
             * @param versionHeaderName Name of HTTP header parameter that indicates the API Version if versioningScheme is set to `header`
             * @return the next definition stage
             */
            WithCreate withVersionHeaderName(String versionHeaderName);
        }

        /**
         * The stage of the apiversionsetcontract definition allowing to specify VersionQueryName.
         */
        interface WithVersionQueryName {
            /**
             * Specifies versionQueryName.
             * @param versionQueryName Name of query parameter that indicates the API Version if versioningScheme is set to `query`
             * @return the next definition stage
             */
            WithCreate withVersionQueryName(String versionQueryName);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<ApiVersionSetContract>, DefinitionStages.WithDescription, DefinitionStages.WithVersionHeaderName, DefinitionStages.WithVersionQueryName {
        }
    }
    /**
     * The template for a ApiVersionSetContract update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<ApiVersionSetContract>, UpdateStages.WithIfMatch, UpdateStages.WithDescription, UpdateStages.WithVersionHeaderName, UpdateStages.WithVersionQueryName {
    }

    /**
     * Grouping of ApiVersionSetContract update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the apiversionsetcontract update allowing to specify IfMatch.
         */
        interface WithIfMatch {
            /**
             * Specifies ifMatch.
             * @param ifMatch ETag of the Entity. Not required when creating an entity, but required when updating an entity
             * @return the next update stage
             */
            Update withIfMatch(String ifMatch);
        }

        /**
         * The stage of the apiversionsetcontract update allowing to specify Description.
         */
        interface WithDescription {
            /**
             * Specifies description.
             * @param description Description of API Version Set
             * @return the next update stage
             */
            Update withDescription(String description);
        }

        /**
         * The stage of the apiversionsetcontract update allowing to specify VersionHeaderName.
         */
        interface WithVersionHeaderName {
            /**
             * Specifies versionHeaderName.
             * @param versionHeaderName Name of HTTP header parameter that indicates the API Version if versioningScheme is set to `header`
             * @return the next update stage
             */
            Update withVersionHeaderName(String versionHeaderName);
        }

        /**
         * The stage of the apiversionsetcontract update allowing to specify VersionQueryName.
         */
        interface WithVersionQueryName {
            /**
             * Specifies versionQueryName.
             * @param versionQueryName Name of query parameter that indicates the API Version if versioningScheme is set to `query`
             * @return the next update stage
             */
            Update withVersionQueryName(String versionQueryName);
        }

    }
}
