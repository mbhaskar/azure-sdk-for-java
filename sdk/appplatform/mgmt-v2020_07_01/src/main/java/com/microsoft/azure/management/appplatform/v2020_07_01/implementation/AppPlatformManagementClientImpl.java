/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appplatform.v2020_07_01.implementation;

import com.microsoft.azure.AzureClient;
import com.microsoft.azure.AzureServiceClient;
import com.microsoft.azure.LongRunningFinalState;
import com.microsoft.azure.LongRunningOperationOptions;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import com.microsoft.rest.RestClient;

/**
 * Initializes a new instance of the AppPlatformManagementClientImpl class.
 */
public class AppPlatformManagementClientImpl extends AzureServiceClient {
    /** the {@link AzureClient} used for long running operations. */
    private AzureClient azureClient;

    /**
     * Gets the {@link AzureClient} used for long running operations.
     * @return the azure client;
     */
    public AzureClient getAzureClient() {
        return this.azureClient;
    }

    /** Client Api Version. */
    private String apiVersion;

    /**
     * Gets Client Api Version.
     *
     * @return the apiVersion value.
     */
    public String apiVersion() {
        return this.apiVersion;
    }

    /** Gets subscription ID which uniquely identify the Microsoft Azure subscription. The subscription ID forms part of the URI for every service call. */
    private String subscriptionId;

    /**
     * Gets Gets subscription ID which uniquely identify the Microsoft Azure subscription. The subscription ID forms part of the URI for every service call.
     *
     * @return the subscriptionId value.
     */
    public String subscriptionId() {
        return this.subscriptionId;
    }

    /**
     * Sets Gets subscription ID which uniquely identify the Microsoft Azure subscription. The subscription ID forms part of the URI for every service call.
     *
     * @param subscriptionId the subscriptionId value.
     * @return the service client itself
     */
    public AppPlatformManagementClientImpl withSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    /** The preferred language for the response. */
    private String acceptLanguage;

    /**
     * Gets The preferred language for the response.
     *
     * @return the acceptLanguage value.
     */
    public String acceptLanguage() {
        return this.acceptLanguage;
    }

    /**
     * Sets The preferred language for the response.
     *
     * @param acceptLanguage the acceptLanguage value.
     * @return the service client itself
     */
    public AppPlatformManagementClientImpl withAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
        return this;
    }

    /** The retry timeout in seconds for Long Running Operations. Default value is 30. */
    private int longRunningOperationRetryTimeout;

    /**
     * Gets The retry timeout in seconds for Long Running Operations. Default value is 30.
     *
     * @return the longRunningOperationRetryTimeout value.
     */
    public int longRunningOperationRetryTimeout() {
        return this.longRunningOperationRetryTimeout;
    }

    /**
     * Sets The retry timeout in seconds for Long Running Operations. Default value is 30.
     *
     * @param longRunningOperationRetryTimeout the longRunningOperationRetryTimeout value.
     * @return the service client itself
     */
    public AppPlatformManagementClientImpl withLongRunningOperationRetryTimeout(int longRunningOperationRetryTimeout) {
        this.longRunningOperationRetryTimeout = longRunningOperationRetryTimeout;
        return this;
    }

    /** Whether a unique x-ms-client-request-id should be generated. When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true. */
    private boolean generateClientRequestId;

    /**
     * Gets Whether a unique x-ms-client-request-id should be generated. When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true.
     *
     * @return the generateClientRequestId value.
     */
    public boolean generateClientRequestId() {
        return this.generateClientRequestId;
    }

    /**
     * Sets Whether a unique x-ms-client-request-id should be generated. When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true.
     *
     * @param generateClientRequestId the generateClientRequestId value.
     * @return the service client itself
     */
    public AppPlatformManagementClientImpl withGenerateClientRequestId(boolean generateClientRequestId) {
        this.generateClientRequestId = generateClientRequestId;
        return this;
    }

    /**
     * The ServicesInner object to access its operations.
     */
    private ServicesInner services;

    /**
     * Gets the ServicesInner object to access its operations.
     * @return the ServicesInner object.
     */
    public ServicesInner services() {
        return this.services;
    }

    /**
     * The ConfigServersInner object to access its operations.
     */
    private ConfigServersInner configServers;

    /**
     * Gets the ConfigServersInner object to access its operations.
     * @return the ConfigServersInner object.
     */
    public ConfigServersInner configServers() {
        return this.configServers;
    }

    /**
     * The MonitoringSettingsInner object to access its operations.
     */
    private MonitoringSettingsInner monitoringSettings;

    /**
     * Gets the MonitoringSettingsInner object to access its operations.
     * @return the MonitoringSettingsInner object.
     */
    public MonitoringSettingsInner monitoringSettings() {
        return this.monitoringSettings;
    }

    /**
     * The AppsInner object to access its operations.
     */
    private AppsInner apps;

    /**
     * Gets the AppsInner object to access its operations.
     * @return the AppsInner object.
     */
    public AppsInner apps() {
        return this.apps;
    }

    /**
     * The BindingsInner object to access its operations.
     */
    private BindingsInner bindings;

    /**
     * Gets the BindingsInner object to access its operations.
     * @return the BindingsInner object.
     */
    public BindingsInner bindings() {
        return this.bindings;
    }

    /**
     * The CertificatesInner object to access its operations.
     */
    private CertificatesInner certificates;

    /**
     * Gets the CertificatesInner object to access its operations.
     * @return the CertificatesInner object.
     */
    public CertificatesInner certificates() {
        return this.certificates;
    }

    /**
     * The CustomDomainsInner object to access its operations.
     */
    private CustomDomainsInner customDomains;

    /**
     * Gets the CustomDomainsInner object to access its operations.
     * @return the CustomDomainsInner object.
     */
    public CustomDomainsInner customDomains() {
        return this.customDomains;
    }

    /**
     * The DeploymentsInner object to access its operations.
     */
    private DeploymentsInner deployments;

    /**
     * Gets the DeploymentsInner object to access its operations.
     * @return the DeploymentsInner object.
     */
    public DeploymentsInner deployments() {
        return this.deployments;
    }

    /**
     * The OperationsInner object to access its operations.
     */
    private OperationsInner operations;

    /**
     * Gets the OperationsInner object to access its operations.
     * @return the OperationsInner object.
     */
    public OperationsInner operations() {
        return this.operations;
    }

    /**
     * The SkusInner object to access its operations.
     */
    private SkusInner skus;

    /**
     * Gets the SkusInner object to access its operations.
     * @return the SkusInner object.
     */
    public SkusInner skus() {
        return this.skus;
    }

    /**
     * Initializes an instance of AppPlatformManagementClient client.
     *
     * @param credentials the management credentials for Azure
     */
    public AppPlatformManagementClientImpl(ServiceClientCredentials credentials) {
        this("https://management.azure.com", credentials);
    }

    /**
     * Initializes an instance of AppPlatformManagementClient client.
     *
     * @param baseUrl the base URL of the host
     * @param credentials the management credentials for Azure
     */
    public AppPlatformManagementClientImpl(String baseUrl, ServiceClientCredentials credentials) {
        super(baseUrl, credentials);
        initialize();
    }

    /**
     * Initializes an instance of AppPlatformManagementClient client.
     *
     * @param restClient the REST client to connect to Azure.
     */
    public AppPlatformManagementClientImpl(RestClient restClient) {
        super(restClient);
        initialize();
    }

    protected void initialize() {
        this.apiVersion = "2020-07-01";
        this.acceptLanguage = "en-US";
        this.longRunningOperationRetryTimeout = 30;
        this.generateClientRequestId = true;
        this.services = new ServicesInner(restClient().retrofit(), this);
        this.configServers = new ConfigServersInner(restClient().retrofit(), this);
        this.monitoringSettings = new MonitoringSettingsInner(restClient().retrofit(), this);
        this.apps = new AppsInner(restClient().retrofit(), this);
        this.bindings = new BindingsInner(restClient().retrofit(), this);
        this.certificates = new CertificatesInner(restClient().retrofit(), this);
        this.customDomains = new CustomDomainsInner(restClient().retrofit(), this);
        this.deployments = new DeploymentsInner(restClient().retrofit(), this);
        this.operations = new OperationsInner(restClient().retrofit(), this);
        this.skus = new SkusInner(restClient().retrofit(), this);
        this.azureClient = new AzureClient(this);
    }

    /**
     * Gets the User-Agent header for the client.
     *
     * @return the user agent string.
     */
    @Override
    public String userAgent() {
        return String.format("%s (%s, %s, auto-generated)", super.userAgent(), "AppPlatformManagementClient", "2020-07-01");
    }
}