// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs;

import com.azure.core.util.logging.ClientLogger;
import com.azure.messaging.eventhubs.implementation.IntegrationTestBase;
import com.azure.messaging.eventhubs.models.BatchOptions;
import com.azure.messaging.eventhubs.models.SendOptions;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class EventHubProducerAsyncClientIntegrationTest extends IntegrationTestBase {
    private static final String PARTITION_ID = "1";

    private EventHubProducerAsyncClient producer;

    public EventHubProducerAsyncClientIntegrationTest() {
        super(new ClientLogger(EventHubProducerAsyncClientIntegrationTest.class));
    }

    @Rule
    public TestName testName = new TestName();

    @Override
    protected String getTestName() {
        return testName.getMethodName();
    }

    @Override
    protected void beforeTest() {
        producer = new EventHubClientBuilder()
            .connectionString(getConnectionString())
            .retry(RETRY_OPTIONS)
            .scheduler(Schedulers.parallel())
            .buildAsyncProducer();
    }

    @Override
    protected void afterTest() {
        dispose(producer);
    }

    /**
     * Verifies that we can create and send a message to an Event Hub partition.
     */
    @Test
    public void sendMessageToPartition() {
        // Arrange
        final SendOptions sendOptions = new SendOptions().setPartitionId(PARTITION_ID);
        final List<EventData> events = Arrays.asList(
            new EventData("Event 1".getBytes(UTF_8)),
            new EventData("Event 2".getBytes(UTF_8)),
            new EventData("Event 3".getBytes(UTF_8)));

        // Act & Assert
        StepVerifier.create(producer.send(events, sendOptions))
            .verifyComplete();
    }

    /**
     * Verifies that we can create an {@link EventHubProducerAsyncClient} that does not care about partitions and lets
     * the service distribute the events.
     */
    @Test
    public void sendMessage() {
        // Arrange
        final List<EventData> events = Arrays.asList(
            new EventData("Event 1".getBytes(UTF_8)),
            new EventData("Event 2".getBytes(UTF_8)),
            new EventData("Event 3".getBytes(UTF_8)));

        // Act & Assert
        StepVerifier.create(producer.send(events))
            .verifyComplete();
    }

    /**
     * Verifies we can create an {@link EventDataBatch} and send it using our EventHubProducer.
     */
    @Test
    public void sendBatch() {
        // Arrange
        final List<EventData> events = Arrays.asList(
            new EventData("Event 1".getBytes(UTF_8)),
            new EventData("Event 2".getBytes(UTF_8)),
            new EventData("Event 3".getBytes(UTF_8)));

        final Mono<EventDataBatch> createBatch = producer.createBatch().map(batch -> {
            events.forEach(event -> {
                Assert.assertTrue(batch.tryAdd(event));
            });

            return batch;
        });

        // Act & Assert
        StepVerifier.create(createBatch.flatMap(batch -> producer.send(batch)))
            .verifyComplete();
    }

    /**
     * Verifies we can create an {@link EventDataBatch} with a partition key and send it using our EventHubProducer.
     */
    @Test
    public void sendBatchWithPartitionKey() {
        // Arrange
        final List<EventData> events = Arrays.asList(
            new EventData("Event 1".getBytes(UTF_8)),
            new EventData("Event 2".getBytes(UTF_8)),
            new EventData("Event 3".getBytes(UTF_8)));

        final BatchOptions options = new BatchOptions().setPartitionKey("my-partition-key");
        final Mono<EventDataBatch> createBatch = producer.createBatch(options)
            .map(batch -> {
                Assert.assertEquals(options.getPartitionKey(), batch.getPartitionKey());

                events.forEach(event -> {
                    Assert.assertTrue(batch.tryAdd(event));
                });

                return batch;
            });

        // Act & Assert
        StepVerifier.create(createBatch.flatMap(batch -> producer.send(batch)))
            .verifyComplete();
    }

    /**
     * Verify that we can send to multiple partitions, round-robin, and with a partition key, using the same producer.
     */
    @Test
    public void sendEventsWithKeyAndPartition() {
        // Arrange
        final List<EventData> events = Arrays.asList(
            new EventData("Event 1".getBytes(UTF_8)),
            new EventData("Event 2".getBytes(UTF_8)),
            new EventData("Event 3".getBytes(UTF_8)));

        // Act
        final Mono<Void> onComplete = Mono.when(producer.send(events),
            producer.send(Flux.just(events.get(0))),
            producer.send(Flux.fromIterable(events), new SendOptions().setPartitionId("1")),
            producer.send(Flux.fromIterable(events), new SendOptions().setPartitionId("0")),
            producer.send(Flux.fromIterable(events), new SendOptions().setPartitionKey("sandwiches")));

        // Assert
        StepVerifier.create(onComplete)
            .verifyComplete();
    }
}
