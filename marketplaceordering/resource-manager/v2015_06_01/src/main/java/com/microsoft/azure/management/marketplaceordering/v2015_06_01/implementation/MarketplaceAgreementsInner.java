/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.marketplaceordering.v2015_06_01.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.management.marketplaceordering.v2015_06_01.ErrorResponseException;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in MarketplaceAgreements.
 */
public class MarketplaceAgreementsInner {
    /** The Retrofit service to perform REST calls. */
    private MarketplaceAgreementsService service;
    /** The service client containing this operation class. */
    private MarketplaceOrderingAgreementsImpl client;

    /**
     * Initializes an instance of MarketplaceAgreementsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public MarketplaceAgreementsInner(Retrofit retrofit, MarketplaceOrderingAgreementsImpl client) {
        this.service = retrofit.create(MarketplaceAgreementsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for MarketplaceAgreements to be
     * used by Retrofit to perform actually REST calls.
     */
    interface MarketplaceAgreementsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.marketplaceordering.v2015_06_01.MarketplaceAgreements get" })
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.MarketplaceOrdering/offerTypes/{offerType}/publishers/{publisherId}/offers/{offerId}/plans/{planId}/agreements/current")
        Observable<Response<ResponseBody>> get(@Path("subscriptionId") String subscriptionId, @Path("offerType") String offerType, @Path("publisherId") String publisherId, @Path("offerId") String offerId, @Path("planId") String planId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.marketplaceordering.v2015_06_01.MarketplaceAgreements create" })
        @PUT("subscriptions/{subscriptionId}/providers/Microsoft.MarketplaceOrdering/offerTypes/{offerType}/publishers/{publisherId}/offers/{offerId}/plans/{planId}/agreements/current")
        Observable<Response<ResponseBody>> create(@Path("offerType") String offerType, @Path("subscriptionId") String subscriptionId, @Path("publisherId") String publisherId, @Path("offerId") String offerId, @Path("planId") String planId, @Query("api-version") String apiVersion, @Body AgreementTermsInner parameters, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.marketplaceordering.v2015_06_01.MarketplaceAgreements sign" })
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.MarketplaceOrdering/agreements/{publisherId}/offers/{offerId}/plans/{planId}/sign")
        Observable<Response<ResponseBody>> sign(@Path("subscriptionId") String subscriptionId, @Path("publisherId") String publisherId, @Path("offerId") String offerId, @Path("planId") String planId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.marketplaceordering.v2015_06_01.MarketplaceAgreements cancel" })
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.MarketplaceOrdering/agreements/{publisherId}/offers/{offerId}/plans/{planId}/cancel")
        Observable<Response<ResponseBody>> cancel(@Path("subscriptionId") String subscriptionId, @Path("publisherId") String publisherId, @Path("offerId") String offerId, @Path("planId") String planId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.marketplaceordering.v2015_06_01.MarketplaceAgreements getAgreement" })
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.MarketplaceOrdering/agreements/{publisherId}/offers/{offerId}/plans/{planId}")
        Observable<Response<ResponseBody>> getAgreement(@Path("subscriptionId") String subscriptionId, @Path("publisherId") String publisherId, @Path("offerId") String offerId, @Path("planId") String planId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.marketplaceordering.v2015_06_01.MarketplaceAgreements list" })
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.MarketplaceOrdering/agreements")
        Observable<Response<ResponseBody>> list(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Get marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the AgreementTermsInner object if successful.
     */
    public AgreementTermsInner get(String publisherId, String offerId, String planId) {
        return getWithServiceResponseAsync(publisherId, offerId, planId).toBlocking().single().body();
    }

    /**
     * Get marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<AgreementTermsInner> getAsync(String publisherId, String offerId, String planId, final ServiceCallback<AgreementTermsInner> serviceCallback) {
        return ServiceFuture.fromResponse(getWithServiceResponseAsync(publisherId, offerId, planId), serviceCallback);
    }

    /**
     * Get marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AgreementTermsInner object
     */
    public Observable<AgreementTermsInner> getAsync(String publisherId, String offerId, String planId) {
        return getWithServiceResponseAsync(publisherId, offerId, planId).map(new Func1<ServiceResponse<AgreementTermsInner>, AgreementTermsInner>() {
            @Override
            public AgreementTermsInner call(ServiceResponse<AgreementTermsInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Get marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AgreementTermsInner object
     */
    public Observable<ServiceResponse<AgreementTermsInner>> getWithServiceResponseAsync(String publisherId, String offerId, String planId) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (publisherId == null) {
            throw new IllegalArgumentException("Parameter publisherId is required and cannot be null.");
        }
        if (offerId == null) {
            throw new IllegalArgumentException("Parameter offerId is required and cannot be null.");
        }
        if (planId == null) {
            throw new IllegalArgumentException("Parameter planId is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        final String offerType = "virtualmachine";
        return service.get(this.client.subscriptionId(), offerType, publisherId, offerId, planId, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<AgreementTermsInner>>>() {
                @Override
                public Observable<ServiceResponse<AgreementTermsInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<AgreementTermsInner> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<AgreementTermsInner> getDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<AgreementTermsInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<AgreementTermsInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Save marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @param parameters Parameters supplied to the Create Marketplace Terms operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the AgreementTermsInner object if successful.
     */
    public AgreementTermsInner create(String publisherId, String offerId, String planId, AgreementTermsInner parameters) {
        return createWithServiceResponseAsync(publisherId, offerId, planId, parameters).toBlocking().single().body();
    }

    /**
     * Save marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @param parameters Parameters supplied to the Create Marketplace Terms operation.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<AgreementTermsInner> createAsync(String publisherId, String offerId, String planId, AgreementTermsInner parameters, final ServiceCallback<AgreementTermsInner> serviceCallback) {
        return ServiceFuture.fromResponse(createWithServiceResponseAsync(publisherId, offerId, planId, parameters), serviceCallback);
    }

    /**
     * Save marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @param parameters Parameters supplied to the Create Marketplace Terms operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AgreementTermsInner object
     */
    public Observable<AgreementTermsInner> createAsync(String publisherId, String offerId, String planId, AgreementTermsInner parameters) {
        return createWithServiceResponseAsync(publisherId, offerId, planId, parameters).map(new Func1<ServiceResponse<AgreementTermsInner>, AgreementTermsInner>() {
            @Override
            public AgreementTermsInner call(ServiceResponse<AgreementTermsInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Save marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @param parameters Parameters supplied to the Create Marketplace Terms operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AgreementTermsInner object
     */
    public Observable<ServiceResponse<AgreementTermsInner>> createWithServiceResponseAsync(String publisherId, String offerId, String planId, AgreementTermsInner parameters) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (publisherId == null) {
            throw new IllegalArgumentException("Parameter publisherId is required and cannot be null.");
        }
        if (offerId == null) {
            throw new IllegalArgumentException("Parameter offerId is required and cannot be null.");
        }
        if (planId == null) {
            throw new IllegalArgumentException("Parameter planId is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        if (parameters == null) {
            throw new IllegalArgumentException("Parameter parameters is required and cannot be null.");
        }
        Validator.validate(parameters);
        final String offerType = "virtualmachine";
        return service.create(offerType, this.client.subscriptionId(), publisherId, offerId, planId, this.client.apiVersion(), parameters, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<AgreementTermsInner>>>() {
                @Override
                public Observable<ServiceResponse<AgreementTermsInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<AgreementTermsInner> clientResponse = createDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<AgreementTermsInner> createDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<AgreementTermsInner, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<AgreementTermsInner>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * Sign marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the AgreementTermsInner object if successful.
     */
    public AgreementTermsInner sign(String publisherId, String offerId, String planId) {
        return signWithServiceResponseAsync(publisherId, offerId, planId).toBlocking().single().body();
    }

    /**
     * Sign marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<AgreementTermsInner> signAsync(String publisherId, String offerId, String planId, final ServiceCallback<AgreementTermsInner> serviceCallback) {
        return ServiceFuture.fromResponse(signWithServiceResponseAsync(publisherId, offerId, planId), serviceCallback);
    }

    /**
     * Sign marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AgreementTermsInner object
     */
    public Observable<AgreementTermsInner> signAsync(String publisherId, String offerId, String planId) {
        return signWithServiceResponseAsync(publisherId, offerId, planId).map(new Func1<ServiceResponse<AgreementTermsInner>, AgreementTermsInner>() {
            @Override
            public AgreementTermsInner call(ServiceResponse<AgreementTermsInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Sign marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AgreementTermsInner object
     */
    public Observable<ServiceResponse<AgreementTermsInner>> signWithServiceResponseAsync(String publisherId, String offerId, String planId) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (publisherId == null) {
            throw new IllegalArgumentException("Parameter publisherId is required and cannot be null.");
        }
        if (offerId == null) {
            throw new IllegalArgumentException("Parameter offerId is required and cannot be null.");
        }
        if (planId == null) {
            throw new IllegalArgumentException("Parameter planId is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.sign(this.client.subscriptionId(), publisherId, offerId, planId, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<AgreementTermsInner>>>() {
                @Override
                public Observable<ServiceResponse<AgreementTermsInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<AgreementTermsInner> clientResponse = signDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<AgreementTermsInner> signDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<AgreementTermsInner, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<AgreementTermsInner>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * Cancel marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the AgreementTermsInner object if successful.
     */
    public AgreementTermsInner cancel(String publisherId, String offerId, String planId) {
        return cancelWithServiceResponseAsync(publisherId, offerId, planId).toBlocking().single().body();
    }

    /**
     * Cancel marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<AgreementTermsInner> cancelAsync(String publisherId, String offerId, String planId, final ServiceCallback<AgreementTermsInner> serviceCallback) {
        return ServiceFuture.fromResponse(cancelWithServiceResponseAsync(publisherId, offerId, planId), serviceCallback);
    }

    /**
     * Cancel marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AgreementTermsInner object
     */
    public Observable<AgreementTermsInner> cancelAsync(String publisherId, String offerId, String planId) {
        return cancelWithServiceResponseAsync(publisherId, offerId, planId).map(new Func1<ServiceResponse<AgreementTermsInner>, AgreementTermsInner>() {
            @Override
            public AgreementTermsInner call(ServiceResponse<AgreementTermsInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Cancel marketplace terms.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AgreementTermsInner object
     */
    public Observable<ServiceResponse<AgreementTermsInner>> cancelWithServiceResponseAsync(String publisherId, String offerId, String planId) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (publisherId == null) {
            throw new IllegalArgumentException("Parameter publisherId is required and cannot be null.");
        }
        if (offerId == null) {
            throw new IllegalArgumentException("Parameter offerId is required and cannot be null.");
        }
        if (planId == null) {
            throw new IllegalArgumentException("Parameter planId is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.cancel(this.client.subscriptionId(), publisherId, offerId, planId, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<AgreementTermsInner>>>() {
                @Override
                public Observable<ServiceResponse<AgreementTermsInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<AgreementTermsInner> clientResponse = cancelDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<AgreementTermsInner> cancelDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<AgreementTermsInner, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<AgreementTermsInner>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * Get marketplace agreement.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the AgreementTermsInner object if successful.
     */
    public AgreementTermsInner getAgreement(String publisherId, String offerId, String planId) {
        return getAgreementWithServiceResponseAsync(publisherId, offerId, planId).toBlocking().single().body();
    }

    /**
     * Get marketplace agreement.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<AgreementTermsInner> getAgreementAsync(String publisherId, String offerId, String planId, final ServiceCallback<AgreementTermsInner> serviceCallback) {
        return ServiceFuture.fromResponse(getAgreementWithServiceResponseAsync(publisherId, offerId, planId), serviceCallback);
    }

    /**
     * Get marketplace agreement.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AgreementTermsInner object
     */
    public Observable<AgreementTermsInner> getAgreementAsync(String publisherId, String offerId, String planId) {
        return getAgreementWithServiceResponseAsync(publisherId, offerId, planId).map(new Func1<ServiceResponse<AgreementTermsInner>, AgreementTermsInner>() {
            @Override
            public AgreementTermsInner call(ServiceResponse<AgreementTermsInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Get marketplace agreement.
     *
     * @param publisherId Publisher identifier string of image being deployed.
     * @param offerId Offer identifier string of image being deployed.
     * @param planId Plan identifier string of image being deployed.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AgreementTermsInner object
     */
    public Observable<ServiceResponse<AgreementTermsInner>> getAgreementWithServiceResponseAsync(String publisherId, String offerId, String planId) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (publisherId == null) {
            throw new IllegalArgumentException("Parameter publisherId is required and cannot be null.");
        }
        if (offerId == null) {
            throw new IllegalArgumentException("Parameter offerId is required and cannot be null.");
        }
        if (planId == null) {
            throw new IllegalArgumentException("Parameter planId is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.getAgreement(this.client.subscriptionId(), publisherId, offerId, planId, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<AgreementTermsInner>>>() {
                @Override
                public Observable<ServiceResponse<AgreementTermsInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<AgreementTermsInner> clientResponse = getAgreementDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<AgreementTermsInner> getAgreementDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<AgreementTermsInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<AgreementTermsInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * List marketplace agreements in the subscription.
     *
     * @return the PagedList<AgreementTermsInner> object if successful.
     */
    public PagedList<AgreementTermsInner> list() {
        PageImpl<AgreementTermsInner> page = new PageImpl<>();
        page.setItems(listWithServiceResponseAsync().toBlocking().single().body());
        page.setNextPageLink(null);
        return new PagedList<AgreementTermsInner>(page) {
            @Override
            public Page<AgreementTermsInner> nextPage(String nextPageLink) {
                return null;
            }
        };
    }

    /**
     * List marketplace agreements in the subscription.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<AgreementTermsInner>> listAsync(final ServiceCallback<List<AgreementTermsInner>> serviceCallback) {
        return ServiceFuture.fromResponse(listWithServiceResponseAsync(), serviceCallback);
    }

    /**
     * List marketplace agreements in the subscription.
     *
     * @return the observable to the List&lt;AgreementTermsInner&gt; object
     */
    public Observable<Page<AgreementTermsInner>> listAsync() {
        return listWithServiceResponseAsync().map(new Func1<ServiceResponse<List<AgreementTermsInner>>, Page<AgreementTermsInner>>() {
            @Override
            public Page<AgreementTermsInner> call(ServiceResponse<List<AgreementTermsInner>> response) {
                PageImpl<AgreementTermsInner> page = new PageImpl<>();
                page.setItems(response.body());
                return page;
            }
        });
    }

    /**
     * List marketplace agreements in the subscription.
     *
     * @return the observable to the List&lt;AgreementTermsInner&gt; object
     */
    public Observable<ServiceResponse<List<AgreementTermsInner>>> listWithServiceResponseAsync() {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<List<AgreementTermsInner>>>>() {
                @Override
                public Observable<ServiceResponse<List<AgreementTermsInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<AgreementTermsInner>> result = listDelegate(response);
                        List<AgreementTermsInner> items = null;
                        if (result.body() != null) {
                            items = result.body().items();
                        }
                        ServiceResponse<List<AgreementTermsInner>> clientResponse = new ServiceResponse<List<AgreementTermsInner>>(items, result.response());
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<AgreementTermsInner>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<AgreementTermsInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<AgreementTermsInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
