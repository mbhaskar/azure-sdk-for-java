/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.subscription.v2020_09_01.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.management.subscription.v2020_09_01.ErrorResponseException;
import com.microsoft.azure.management.subscription.v2020_09_01.SubscriptionName;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in SubscriptionServices.
 */
public class SubscriptionServicesInner {
    /** The Retrofit service to perform REST calls. */
    private SubscriptionServicesService service;
    /** The service client containing this operation class. */
    private SubscriptionClientImpl client;

    /**
     * Initializes an instance of SubscriptionServicesInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public SubscriptionServicesInner(Retrofit retrofit, SubscriptionClientImpl client) {
        this.service = retrofit.create(SubscriptionServicesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for SubscriptionServices to be
     * used by Retrofit to perform actually REST calls.
     */
    interface SubscriptionServicesService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.subscription.v2020_09_01.SubscriptionServices cancel" })
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.Subscription/cancel")
        Observable<Response<ResponseBody>> cancel(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.subscription.v2020_09_01.SubscriptionServices rename" })
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.Subscription/rename")
        Observable<Response<ResponseBody>> rename(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body SubscriptionName body, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.subscription.v2020_09_01.SubscriptionServices enable" })
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.Subscription/enable")
        Observable<Response<ResponseBody>> enable(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * The operation to cancel a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the CanceledSubscriptionIdInner object if successful.
     */
    public CanceledSubscriptionIdInner cancel(String subscriptionId) {
        return cancelWithServiceResponseAsync(subscriptionId).toBlocking().single().body();
    }

    /**
     * The operation to cancel a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<CanceledSubscriptionIdInner> cancelAsync(String subscriptionId, final ServiceCallback<CanceledSubscriptionIdInner> serviceCallback) {
        return ServiceFuture.fromResponse(cancelWithServiceResponseAsync(subscriptionId), serviceCallback);
    }

    /**
     * The operation to cancel a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the CanceledSubscriptionIdInner object
     */
    public Observable<CanceledSubscriptionIdInner> cancelAsync(String subscriptionId) {
        return cancelWithServiceResponseAsync(subscriptionId).map(new Func1<ServiceResponse<CanceledSubscriptionIdInner>, CanceledSubscriptionIdInner>() {
            @Override
            public CanceledSubscriptionIdInner call(ServiceResponse<CanceledSubscriptionIdInner> response) {
                return response.body();
            }
        });
    }

    /**
     * The operation to cancel a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the CanceledSubscriptionIdInner object
     */
    public Observable<ServiceResponse<CanceledSubscriptionIdInner>> cancelWithServiceResponseAsync(String subscriptionId) {
        if (subscriptionId == null) {
            throw new IllegalArgumentException("Parameter subscriptionId is required and cannot be null.");
        }
        final String apiVersion = "2020-09-01";
        return service.cancel(subscriptionId, apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<CanceledSubscriptionIdInner>>>() {
                @Override
                public Observable<ServiceResponse<CanceledSubscriptionIdInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<CanceledSubscriptionIdInner> clientResponse = cancelDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<CanceledSubscriptionIdInner> cancelDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<CanceledSubscriptionIdInner, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<CanceledSubscriptionIdInner>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * The operation to rename a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the RenamedSubscriptionIdInner object if successful.
     */
    public RenamedSubscriptionIdInner rename(String subscriptionId) {
        return renameWithServiceResponseAsync(subscriptionId).toBlocking().single().body();
    }

    /**
     * The operation to rename a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<RenamedSubscriptionIdInner> renameAsync(String subscriptionId, final ServiceCallback<RenamedSubscriptionIdInner> serviceCallback) {
        return ServiceFuture.fromResponse(renameWithServiceResponseAsync(subscriptionId), serviceCallback);
    }

    /**
     * The operation to rename a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the RenamedSubscriptionIdInner object
     */
    public Observable<RenamedSubscriptionIdInner> renameAsync(String subscriptionId) {
        return renameWithServiceResponseAsync(subscriptionId).map(new Func1<ServiceResponse<RenamedSubscriptionIdInner>, RenamedSubscriptionIdInner>() {
            @Override
            public RenamedSubscriptionIdInner call(ServiceResponse<RenamedSubscriptionIdInner> response) {
                return response.body();
            }
        });
    }

    /**
     * The operation to rename a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the RenamedSubscriptionIdInner object
     */
    public Observable<ServiceResponse<RenamedSubscriptionIdInner>> renameWithServiceResponseAsync(String subscriptionId) {
        if (subscriptionId == null) {
            throw new IllegalArgumentException("Parameter subscriptionId is required and cannot be null.");
        }
        final String apiVersion = "2020-09-01";
        final String subscriptionName = null;
        SubscriptionName body = new SubscriptionName();
        body.withSubscriptionName(null);
        return service.rename(subscriptionId, apiVersion, this.client.acceptLanguage(), body, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<RenamedSubscriptionIdInner>>>() {
                @Override
                public Observable<ServiceResponse<RenamedSubscriptionIdInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<RenamedSubscriptionIdInner> clientResponse = renameDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * The operation to rename a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @param subscriptionName New subscription name
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the RenamedSubscriptionIdInner object if successful.
     */
    public RenamedSubscriptionIdInner rename(String subscriptionId, String subscriptionName) {
        return renameWithServiceResponseAsync(subscriptionId, subscriptionName).toBlocking().single().body();
    }

    /**
     * The operation to rename a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @param subscriptionName New subscription name
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<RenamedSubscriptionIdInner> renameAsync(String subscriptionId, String subscriptionName, final ServiceCallback<RenamedSubscriptionIdInner> serviceCallback) {
        return ServiceFuture.fromResponse(renameWithServiceResponseAsync(subscriptionId, subscriptionName), serviceCallback);
    }

    /**
     * The operation to rename a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @param subscriptionName New subscription name
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the RenamedSubscriptionIdInner object
     */
    public Observable<RenamedSubscriptionIdInner> renameAsync(String subscriptionId, String subscriptionName) {
        return renameWithServiceResponseAsync(subscriptionId, subscriptionName).map(new Func1<ServiceResponse<RenamedSubscriptionIdInner>, RenamedSubscriptionIdInner>() {
            @Override
            public RenamedSubscriptionIdInner call(ServiceResponse<RenamedSubscriptionIdInner> response) {
                return response.body();
            }
        });
    }

    /**
     * The operation to rename a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @param subscriptionName New subscription name
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the RenamedSubscriptionIdInner object
     */
    public Observable<ServiceResponse<RenamedSubscriptionIdInner>> renameWithServiceResponseAsync(String subscriptionId, String subscriptionName) {
        if (subscriptionId == null) {
            throw new IllegalArgumentException("Parameter subscriptionId is required and cannot be null.");
        }
        final String apiVersion = "2020-09-01";
        SubscriptionName body = new SubscriptionName();
        body.withSubscriptionName(subscriptionName);
        return service.rename(subscriptionId, apiVersion, this.client.acceptLanguage(), body, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<RenamedSubscriptionIdInner>>>() {
                @Override
                public Observable<ServiceResponse<RenamedSubscriptionIdInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<RenamedSubscriptionIdInner> clientResponse = renameDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<RenamedSubscriptionIdInner> renameDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<RenamedSubscriptionIdInner, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<RenamedSubscriptionIdInner>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * The operation to enable a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the EnabledSubscriptionIdInner object if successful.
     */
    public EnabledSubscriptionIdInner enable(String subscriptionId) {
        return enableWithServiceResponseAsync(subscriptionId).toBlocking().single().body();
    }

    /**
     * The operation to enable a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<EnabledSubscriptionIdInner> enableAsync(String subscriptionId, final ServiceCallback<EnabledSubscriptionIdInner> serviceCallback) {
        return ServiceFuture.fromResponse(enableWithServiceResponseAsync(subscriptionId), serviceCallback);
    }

    /**
     * The operation to enable a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the EnabledSubscriptionIdInner object
     */
    public Observable<EnabledSubscriptionIdInner> enableAsync(String subscriptionId) {
        return enableWithServiceResponseAsync(subscriptionId).map(new Func1<ServiceResponse<EnabledSubscriptionIdInner>, EnabledSubscriptionIdInner>() {
            @Override
            public EnabledSubscriptionIdInner call(ServiceResponse<EnabledSubscriptionIdInner> response) {
                return response.body();
            }
        });
    }

    /**
     * The operation to enable a subscription.
     *
     * @param subscriptionId Subscription Id.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the EnabledSubscriptionIdInner object
     */
    public Observable<ServiceResponse<EnabledSubscriptionIdInner>> enableWithServiceResponseAsync(String subscriptionId) {
        if (subscriptionId == null) {
            throw new IllegalArgumentException("Parameter subscriptionId is required and cannot be null.");
        }
        final String apiVersion = "2020-09-01";
        return service.enable(subscriptionId, apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<EnabledSubscriptionIdInner>>>() {
                @Override
                public Observable<ServiceResponse<EnabledSubscriptionIdInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<EnabledSubscriptionIdInner> clientResponse = enableDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<EnabledSubscriptionIdInner> enableDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<EnabledSubscriptionIdInner, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<EnabledSubscriptionIdInner>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

}