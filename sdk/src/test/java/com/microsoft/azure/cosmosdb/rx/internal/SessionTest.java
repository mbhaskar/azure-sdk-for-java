/*
 * The MIT License (MIT)
 * Copyright (c) 2018 Microsoft Corporation
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.microsoft.azure.cosmosdb.rx.internal;

import com.microsoft.azure.cosmosdb.Database;
import com.microsoft.azure.cosmosdb.Document;
import com.microsoft.azure.cosmosdb.DocumentCollection;
import com.microsoft.azure.cosmosdb.internal.HttpConstants;
import com.microsoft.azure.cosmosdb.rx.AsyncDocumentClient;
import com.microsoft.azure.cosmosdb.rx.TestSuiteBase;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpMethod;
import io.reactivex.netty.protocol.http.client.HttpClientRequest;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.net.ssl.SSLException;

import static org.assertj.core.api.Assertions.assertThat;

public class SessionTest extends TestSuiteBase {
    protected static final int TIMEOUT = 20000;

    private Database createdDatabase;
    private DocumentCollection createdCollection;

    private SpyClientUnderTestFactory.ClientUnderTest client;

    private String getCollectionLink() {
        return createdCollection.getSelfLink();
    }

    @Factory(dataProvider = "clientBuilders")
    public SessionTest(AsyncDocumentClient.Builder clientBuilder) {
        this.clientBuilder = clientBuilder;
        this.subscriberValidationTimeout = TIMEOUT;
    }

    @BeforeClass(groups = { "simple" }, timeOut = SETUP_TIMEOUT)
    public void beforeClass() {
        createdDatabase = SHARED_DATABASE;
        createdCollection = SHARED_SINGLE_PARTITION_COLLECTION_WITHOUT_PARTITION_KEY;
        client = SpyClientUnderTestFactory.createClientUnderTest(clientBuilder);
    }

    @AfterClass(groups = { "simple" }, timeOut = SHUTDOWN_TIMEOUT, alwaysRun = true)
    public void afterClass() {
        safeClose(client);
    }

    @BeforeMethod(groups = { "simple" }, timeOut = SETUP_TIMEOUT)
    public void beforeTest(Method method) {
        super.beforeMethod(method);
        client.clearCapturedRequests();
    }

    @Test(groups = { "simple" }, timeOut = TIMEOUT)
    public void sessionConsistency_ReadYourWrites() {
        client.readCollection(getCollectionLink(), null).toBlocking().single();
        client.createDocument(getCollectionLink(), new Document(), null, false).toBlocking().single();

        client.clearCapturedRequests();

        for (int i = 0; i < 10; i++) {

            Document documentCreated = client.createDocument(getCollectionLink(), new Document(), null, false)
                    .toBlocking().single().getResource();

            assertThat(getSessionTokensInRequests()).hasSize(3 * i + 1);
            assertThat(getSessionTokensInRequests().get(3 * i + 0)).isNotEmpty();

            client.readDocument(documentCreated.getSelfLink(), null).toBlocking().single();

            assertThat(getSessionTokensInRequests()).hasSize(3 * i + 2);
            assertThat(getSessionTokensInRequests().get(3 * i + 1)).isNotEmpty();

            client.readDocument(documentCreated.getSelfLink(), null).toBlocking().single();

            assertThat(getSessionTokensInRequests()).hasSize(3 * i + 3);
            assertThat(getSessionTokensInRequests().get(3 * i + 2)).isNotEmpty();
        }
    }

    private List<String> getSessionTokensInRequests() {
        return client.getCapturedRequests().stream()
                .map(r -> r.getHeaders().get(HttpConstants.HttpHeaders.SESSION_TOKEN))
                .collect(Collectors.toList());
    }

    @Test(groups = { "simple" }, timeOut = TIMEOUT)
    public void sessionTokenInDocumentRead() {
        Document document = new Document();
        document.setId(UUID.randomUUID().toString());
        document.set("pk", "pk");
        document = client.createDocument(getCollectionLink(), document, null, false).toBlocking().single()
                .getResource();

        final String documentLink = document.getSelfLink();
        client.readDocument(documentLink, null).toBlocking().single()
                .getResource();

        List<HttpClientRequest<ByteBuf>> documentReadHttpRequests = client.getCapturedRequests().stream()
                .filter(r -> r.getMethod() == HttpMethod.GET)
                .filter(r -> r.getUri().contains(StringUtils.removeEnd(documentLink,"/")))
                .collect(Collectors.toList());

        assertThat(documentReadHttpRequests).hasSize(1);
        assertThat(documentReadHttpRequests.get(0).getHeaders().get(HttpConstants.HttpHeaders.SESSION_TOKEN)).isNotEmpty();
    }

    @Test(groups = { "simple" }, timeOut = TIMEOUT)
    public void sessionTokenRemovedForMasterResource() {
        client.readCollection(getCollectionLink(), null).toBlocking().single();

        List<HttpClientRequest<ByteBuf>> collectionReadHttpRequests = client.getCapturedRequests().stream()
                .filter(r -> r.getMethod() == HttpMethod.GET)
                .filter(r -> r.getUri().contains(StringUtils.removeEnd(getCollectionLink(),"/")))
                .collect(Collectors.toList());

        assertThat(collectionReadHttpRequests).hasSize(1);
        assertThat(collectionReadHttpRequests.get(0).getHeaders().get(HttpConstants.HttpHeaders.SESSION_TOKEN)).isNull();
    }
}