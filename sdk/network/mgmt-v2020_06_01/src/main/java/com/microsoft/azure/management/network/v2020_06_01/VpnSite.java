/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_06_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.Resource;
import com.microsoft.azure.arm.resources.models.GroupableResourceCore;
import com.microsoft.azure.arm.resources.models.HasResourceGroup;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.network.v2020_06_01.implementation.NetworkManager;
import com.microsoft.azure.SubResource;
import java.util.List;
import com.microsoft.azure.management.network.v2020_06_01.implementation.VpnSiteLinkInner;
import com.microsoft.azure.management.network.v2020_06_01.implementation.VpnSiteInner;

/**
 * Type representing VpnSite.
 */
public interface VpnSite extends HasInner<VpnSiteInner>, Resource, GroupableResourceCore<NetworkManager, VpnSiteInner>, HasResourceGroup, Refreshable<VpnSite>, Updatable<VpnSite.Update>, HasManager<NetworkManager> {
    /**
     * @return the addressSpace value.
     */
    AddressSpace addressSpace();

    /**
     * @return the bgpProperties value.
     */
    BgpSettings bgpProperties();

    /**
     * @return the deviceProperties value.
     */
    DeviceProperties deviceProperties();

    /**
     * @return the etag value.
     */
    String etag();

    /**
     * @return the ipAddress value.
     */
    String ipAddress();

    /**
     * @return the isSecuritySite value.
     */
    Boolean isSecuritySite();

    /**
     * @return the o365Policy value.
     */
    O365PolicyProperties o365Policy();

    /**
     * @return the provisioningState value.
     */
    ProvisioningState provisioningState();

    /**
     * @return the siteKey value.
     */
    String siteKey();

    /**
     * @return the virtualWan value.
     */
    SubResource virtualWan();

    /**
     * @return the vpnSiteLinks value.
     */
    List<VpnSiteLink> vpnSiteLinks();

    /**
     * The entirety of the VpnSite definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithGroup, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of VpnSite definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a VpnSite definition.
         */
        interface Blank extends GroupableResourceCore.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of the VpnSite definition allowing to specify the resource group.
         */
        interface WithGroup extends GroupableResourceCore.DefinitionStages.WithGroup<WithCreate> {
        }

        /**
         * The stage of the vpnsite definition allowing to specify AddressSpace.
         */
        interface WithAddressSpace {
            /**
             * Specifies addressSpace.
             * @param addressSpace The AddressSpace that contains an array of IP address ranges
             * @return the next definition stage
             */
            WithCreate withAddressSpace(AddressSpace addressSpace);
        }

        /**
         * The stage of the vpnsite definition allowing to specify BgpProperties.
         */
        interface WithBgpProperties {
            /**
             * Specifies bgpProperties.
             * @param bgpProperties The set of bgp properties
             * @return the next definition stage
             */
            WithCreate withBgpProperties(BgpSettings bgpProperties);
        }

        /**
         * The stage of the vpnsite definition allowing to specify DeviceProperties.
         */
        interface WithDeviceProperties {
            /**
             * Specifies deviceProperties.
             * @param deviceProperties The device properties
             * @return the next definition stage
             */
            WithCreate withDeviceProperties(DeviceProperties deviceProperties);
        }

        /**
         * The stage of the vpnsite definition allowing to specify IpAddress.
         */
        interface WithIpAddress {
            /**
             * Specifies ipAddress.
             * @param ipAddress The ip-address for the vpn-site
             * @return the next definition stage
             */
            WithCreate withIpAddress(String ipAddress);
        }

        /**
         * The stage of the vpnsite definition allowing to specify IsSecuritySite.
         */
        interface WithIsSecuritySite {
            /**
             * Specifies isSecuritySite.
             * @param isSecuritySite IsSecuritySite flag
             * @return the next definition stage
             */
            WithCreate withIsSecuritySite(Boolean isSecuritySite);
        }

        /**
         * The stage of the vpnsite definition allowing to specify O365Policy.
         */
        interface WithO365Policy {
            /**
             * Specifies o365Policy.
             * @param o365Policy Office365 Policy
             * @return the next definition stage
             */
            WithCreate withO365Policy(O365PolicyProperties o365Policy);
        }

        /**
         * The stage of the vpnsite definition allowing to specify SiteKey.
         */
        interface WithSiteKey {
            /**
             * Specifies siteKey.
             * @param siteKey The key for vpn-site that can be used for connections
             * @return the next definition stage
             */
            WithCreate withSiteKey(String siteKey);
        }

        /**
         * The stage of the vpnsite definition allowing to specify VirtualWan.
         */
        interface WithVirtualWan {
            /**
             * Specifies virtualWan.
             * @param virtualWan The VirtualWAN to which the vpnSite belongs
             * @return the next definition stage
             */
            WithCreate withVirtualWan(SubResource virtualWan);
        }

        /**
         * The stage of the vpnsite definition allowing to specify VpnSiteLinks.
         */
        interface WithVpnSiteLinks {
            /**
             * Specifies vpnSiteLinks.
             * @param vpnSiteLinks List of all vpn site links
             * @return the next definition stage
             */
            WithCreate withVpnSiteLinks(List<VpnSiteLinkInner> vpnSiteLinks);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<VpnSite>, Resource.DefinitionWithTags<WithCreate>, DefinitionStages.WithAddressSpace, DefinitionStages.WithBgpProperties, DefinitionStages.WithDeviceProperties, DefinitionStages.WithIpAddress, DefinitionStages.WithIsSecuritySite, DefinitionStages.WithO365Policy, DefinitionStages.WithSiteKey, DefinitionStages.WithVirtualWan, DefinitionStages.WithVpnSiteLinks {
        }
    }
    /**
     * The template for a VpnSite update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<VpnSite>, Resource.UpdateWithTags<Update>, UpdateStages.WithAddressSpace, UpdateStages.WithBgpProperties, UpdateStages.WithDeviceProperties, UpdateStages.WithIpAddress, UpdateStages.WithIsSecuritySite, UpdateStages.WithO365Policy, UpdateStages.WithSiteKey, UpdateStages.WithVirtualWan, UpdateStages.WithVpnSiteLinks {
    }

    /**
     * Grouping of VpnSite update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the vpnsite update allowing to specify AddressSpace.
         */
        interface WithAddressSpace {
            /**
             * Specifies addressSpace.
             * @param addressSpace The AddressSpace that contains an array of IP address ranges
             * @return the next update stage
             */
            Update withAddressSpace(AddressSpace addressSpace);
        }

        /**
         * The stage of the vpnsite update allowing to specify BgpProperties.
         */
        interface WithBgpProperties {
            /**
             * Specifies bgpProperties.
             * @param bgpProperties The set of bgp properties
             * @return the next update stage
             */
            Update withBgpProperties(BgpSettings bgpProperties);
        }

        /**
         * The stage of the vpnsite update allowing to specify DeviceProperties.
         */
        interface WithDeviceProperties {
            /**
             * Specifies deviceProperties.
             * @param deviceProperties The device properties
             * @return the next update stage
             */
            Update withDeviceProperties(DeviceProperties deviceProperties);
        }

        /**
         * The stage of the vpnsite update allowing to specify IpAddress.
         */
        interface WithIpAddress {
            /**
             * Specifies ipAddress.
             * @param ipAddress The ip-address for the vpn-site
             * @return the next update stage
             */
            Update withIpAddress(String ipAddress);
        }

        /**
         * The stage of the vpnsite update allowing to specify IsSecuritySite.
         */
        interface WithIsSecuritySite {
            /**
             * Specifies isSecuritySite.
             * @param isSecuritySite IsSecuritySite flag
             * @return the next update stage
             */
            Update withIsSecuritySite(Boolean isSecuritySite);
        }

        /**
         * The stage of the vpnsite update allowing to specify O365Policy.
         */
        interface WithO365Policy {
            /**
             * Specifies o365Policy.
             * @param o365Policy Office365 Policy
             * @return the next update stage
             */
            Update withO365Policy(O365PolicyProperties o365Policy);
        }

        /**
         * The stage of the vpnsite update allowing to specify SiteKey.
         */
        interface WithSiteKey {
            /**
             * Specifies siteKey.
             * @param siteKey The key for vpn-site that can be used for connections
             * @return the next update stage
             */
            Update withSiteKey(String siteKey);
        }

        /**
         * The stage of the vpnsite update allowing to specify VirtualWan.
         */
        interface WithVirtualWan {
            /**
             * Specifies virtualWan.
             * @param virtualWan The VirtualWAN to which the vpnSite belongs
             * @return the next update stage
             */
            Update withVirtualWan(SubResource virtualWan);
        }

        /**
         * The stage of the vpnsite update allowing to specify VpnSiteLinks.
         */
        interface WithVpnSiteLinks {
            /**
             * Specifies vpnSiteLinks.
             * @param vpnSiteLinks List of all vpn site links
             * @return the next update stage
             */
            Update withVpnSiteLinks(List<VpnSiteLinkInner> vpnSiteLinks);
        }

    }
}