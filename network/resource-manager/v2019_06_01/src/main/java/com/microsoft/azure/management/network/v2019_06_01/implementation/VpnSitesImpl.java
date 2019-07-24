/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * def
 */

package com.microsoft.azure.management.network.v2019_06_01.implementation;

import com.microsoft.azure.arm.resources.collection.implementation.GroupableResourcesCoreImpl;
import com.microsoft.azure.management.network.v2019_06_01.VpnSites;
import com.microsoft.azure.management.network.v2019_06_01.VpnSite;
import rx.Observable;
import rx.Completable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import com.microsoft.azure.arm.resources.ResourceUtilsCore;
import com.microsoft.azure.arm.utils.RXMapper;
import rx.functions.Func1;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.Page;

class VpnSitesImpl extends GroupableResourcesCoreImpl<VpnSite, VpnSiteImpl, VpnSiteInner, VpnSitesInner, NetworkManager>  implements VpnSites {
    protected VpnSitesImpl(NetworkManager manager) {
        super(manager.inner().vpnSites(), manager);
    }

    @Override
    protected Observable<VpnSiteInner> getInnerAsync(String resourceGroupName, String name) {
        VpnSitesInner client = this.inner();
        return client.getByResourceGroupAsync(resourceGroupName, name);
    }

    @Override
    protected Completable deleteInnerAsync(String resourceGroupName, String name) {
        VpnSitesInner client = this.inner();
        return client.deleteAsync(resourceGroupName, name).toCompletable();
    }

    @Override
    public Observable<String> deleteByIdsAsync(Collection<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Observable.empty();
        }
        Collection<Observable<String>> observables = new ArrayList<>();
        for (String id : ids) {
            final String resourceGroupName = ResourceUtilsCore.groupFromResourceId(id);
            final String name = ResourceUtilsCore.nameFromResourceId(id);
            Observable<String> o = RXMapper.map(this.inner().deleteAsync(resourceGroupName, name), id);
            observables.add(o);
        }
        return Observable.mergeDelayError(observables);
    }

    @Override
    public Observable<String> deleteByIdsAsync(String...ids) {
        return this.deleteByIdsAsync(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public void deleteByIds(Collection<String> ids) {
        if (ids != null && !ids.isEmpty()) {
            this.deleteByIdsAsync(ids).toBlocking().last();
        }
    }

    @Override
    public void deleteByIds(String...ids) {
        this.deleteByIds(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public PagedList<VpnSite> listByResourceGroup(String resourceGroupName) {
        VpnSitesInner client = this.inner();
        return this.wrapList(client.listByResourceGroup(resourceGroupName));
    }

    @Override
    public Observable<VpnSite> listByResourceGroupAsync(String resourceGroupName) {
        VpnSitesInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName)
        .flatMapIterable(new Func1<Page<VpnSiteInner>, Iterable<VpnSiteInner>>() {
            @Override
            public Iterable<VpnSiteInner> call(Page<VpnSiteInner> page) {
                return page.items();
            }
        })
        .map(new Func1<VpnSiteInner, VpnSite>() {
            @Override
            public VpnSite call(VpnSiteInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public PagedList<VpnSite> list() {
        VpnSitesInner client = this.inner();
        return this.wrapList(client.list());
    }

    @Override
    public Observable<VpnSite> listAsync() {
        VpnSitesInner client = this.inner();
        return client.listAsync()
        .flatMapIterable(new Func1<Page<VpnSiteInner>, Iterable<VpnSiteInner>>() {
            @Override
            public Iterable<VpnSiteInner> call(Page<VpnSiteInner> page) {
                return page.items();
            }
        })
        .map(new Func1<VpnSiteInner, VpnSite>() {
            @Override
            public VpnSite call(VpnSiteInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public VpnSiteImpl define(String name) {
        return wrapModel(name);
    }

    @Override
    protected VpnSiteImpl wrapModel(VpnSiteInner inner) {
        return  new VpnSiteImpl(inner.name(), inner, manager());
    }

    @Override
    protected VpnSiteImpl wrapModel(String name) {
        return new VpnSiteImpl(name, new VpnSiteInner(), this.manager());
    }

}
