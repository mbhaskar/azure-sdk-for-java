/**
 * Copyright 2011 Microsoft Corporation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.microsoft.windowsazure.services.serviceBus;

import com.microsoft.windowsazure.services.core.FilterableService;
import com.microsoft.windowsazure.services.core.ServiceException;

/**
 * 
 * Defines the Media  contract.
 * 
 */
public interface MediaServicesContract extends FilterableService<MediaServicesContract> {
	/**
	* The set of operations to support. Will uncomment as they get added
	*
	* CreateAssetResult createAsset(String name) throws ServiceException;
	* 
	* CreateAccessPolicyResult createAccessPolicy(String name, 
	*         int durationInMinutes,
	*         AccessPolicyPermissions permissions)
	*         throws ServiceException;
	*
	* CreateLocatorResult createLocator(AssetId asset,
	*                                   AccessPolicyId accessPolicy,
	*                                   DateTime startTime,
	*                                   LocatorType type)
	*                                   throws ServiceException;
	*
	* Add overload that defaults locatorType to SAS, and defaults startTime to now - 5 minutes.
	*
	* We need to upload blobs from here - do we go through blobservice, or do we just do it
	* directly? I'm leaning towards direct - blob container is encoded in locator.
	*
	*/
}
