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
import com.microsoft.azure.management.network.v2019_06_01.BastionHosts;
import com.microsoft.azure.management.network.v2019_06_01.BastionHost;
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

class BastionHostsImpl extends GroupableResourcesCoreImpl<BastionHost, BastionHostImpl, BastionHostInner, BastionHostsInner, NetworkManager>  implements BastionHosts {
    protected BastionHostsImpl(NetworkManager manager) {
        super(manager.inner().bastionHosts(), manager);
    }

    @Override
    protected Observable<BastionHostInner> getInnerAsync(String resourceGroupName, String name) {
        BastionHostsInner client = this.inner();
        return client.getByResourceGroupAsync(resourceGroupName, name);
    }

    @Override
    protected Completable deleteInnerAsync(String resourceGroupName, String name) {
        BastionHostsInner client = this.inner();
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
    public PagedList<BastionHost> listByResourceGroup(String resourceGroupName) {
        BastionHostsInner client = this.inner();
        return this.wrapList(client.listByResourceGroup(resourceGroupName));
    }

    @Override
    public Observable<BastionHost> listByResourceGroupAsync(String resourceGroupName) {
        BastionHostsInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName)
        .flatMapIterable(new Func1<Page<BastionHostInner>, Iterable<BastionHostInner>>() {
            @Override
            public Iterable<BastionHostInner> call(Page<BastionHostInner> page) {
                return page.items();
            }
        })
        .map(new Func1<BastionHostInner, BastionHost>() {
            @Override
            public BastionHost call(BastionHostInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public PagedList<BastionHost> list() {
        BastionHostsInner client = this.inner();
        return this.wrapList(client.list());
    }

    @Override
    public Observable<BastionHost> listAsync() {
        BastionHostsInner client = this.inner();
        return client.listAsync()
        .flatMapIterable(new Func1<Page<BastionHostInner>, Iterable<BastionHostInner>>() {
            @Override
            public Iterable<BastionHostInner> call(Page<BastionHostInner> page) {
                return page.items();
            }
        })
        .map(new Func1<BastionHostInner, BastionHost>() {
            @Override
            public BastionHost call(BastionHostInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public BastionHostImpl define(String name) {
        return wrapModel(name);
    }

    @Override
    protected BastionHostImpl wrapModel(BastionHostInner inner) {
        return  new BastionHostImpl(inner.name(), inner, manager());
    }

    @Override
    protected BastionHostImpl wrapModel(String name) {
        return new BastionHostImpl(name, new BastionHostInner(), this.manager());
    }

}
