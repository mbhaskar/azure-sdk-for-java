/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.vmwarecloudsimple.v2019_04_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.vmwarecloudsimple.v2019_04_01.implementation.VirtualMachineTemplateInner;
import com.microsoft.azure.arm.model.Indexable;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.vmwarecloudsimple.v2019_04_01.implementation.VMwareCloudSimpleManager;
import java.util.List;

/**
 * Type representing VirtualMachineTemplate.
 */
public interface VirtualMachineTemplate extends HasInner<VirtualMachineTemplateInner>, Indexable, Refreshable<VirtualMachineTemplate>, HasManager<VMwareCloudSimpleManager> {
    /**
     * @return the amountOfRam value.
     */
    Integer amountOfRam();

    /**
     * @return the controllers value.
     */
    List<VirtualDiskController> controllers();

    /**
     * @return the description value.
     */
    String description();

    /**
     * @return the disks value.
     */
    List<VirtualDisk> disks();

    /**
     * @return the exposeToGuestVM value.
     */
    Boolean exposeToGuestVM();

    /**
     * @return the guestOS value.
     */
    String guestOS();

    /**
     * @return the guestOSType value.
     */
    String guestOSType();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the location value.
     */
    String location();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the nics value.
     */
    List<VirtualNic> nics();

    /**
     * @return the numberOfCores value.
     */
    Integer numberOfCores();

    /**
     * @return the path value.
     */
    String path();

    /**
     * @return the privateCloudId value.
     */
    String privateCloudId();

    /**
     * @return the type value.
     */
    String type();

    /**
     * @return the vmwaretools value.
     */
    String vmwaretools();

    /**
     * @return the vSphereNetworks value.
     */
    List<String> vSphereNetworks();

    /**
     * @return the vSphereTags value.
     */
    List<String> vSphereTags();

}
