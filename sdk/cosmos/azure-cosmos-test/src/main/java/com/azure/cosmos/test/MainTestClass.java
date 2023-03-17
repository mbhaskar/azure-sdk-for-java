package com.azure.cosmos.test;

import com.azure.cosmos.*;
import com.azure.cosmos.models.CosmosEndToEndOperationLatencyPolicyConfig;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosItemResponse;
import com.azure.cosmos.models.PartitionKey;
import com.azure.cosmos.test.faultinjection.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTestClass {

    private static final String PROD_END_POINT = "";
    public static final String PROD_KEY = "";

    private final static String EMULATOR_KEY = "";
    private final static String EMULATOR_HOST = "";

    //    private static final String END_POINT = EMULATOR_HOST;
    //    public static final String KEY = EMULATOR_KEY;

    private static final String END_POINT = PROD_END_POINT;
    public static final String KEY = PROD_KEY;

    public static final String DATABASE = "mydb";
    public static final String CONTAINER = "mycontainer";
    private static final int REPEAT_COUNT = 30;

    CosmosAsyncClient cosmosAsyncClient;

    CosmosAsyncDatabase database;
    CosmosAsyncContainer container;

    public static void main(String[] args) {
        MainTestClass c = new MainTestClass();
        c.createCosmosAsyncClient();
        c.start();
    }

    public void start(){
//        cosmosAsyncClient.createDatabaseIfNotExists(DATABASE)
//            .flatMap(cosmosDatabaseResponse -> {
//                return cosmosAsyncClient.getDatabase(cosmosDatabaseResponse.getProperties().getId())
//                    .createContainerIfNotExists(CONTAINER, "/id");
//            }).block();
//
//       createItems(5);
        this.container = cosmosAsyncClient.getDatabase(DATABASE)
            .getContainer(CONTAINER);
        injectFaults();
        List<Mono<CosmosItemResponse<Person>>> responseList = new ArrayList<>();
        for (int i = 0; i < REPEAT_COUNT; i++){
//            responseList.add(readItem());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            readItem().block();
        }

//        Flux.mergeSequential(responseList).blockLast();
    }

    private void injectFaults() {
        FaultInjectionRule serverLatencyRule = new FaultInjectionRuleBuilder("region-latency-rule")
            .condition(
                new FaultInjectionConditionBuilder()
                    .operationType(FaultInjectionOperationType.READ_ITEM)
                    .region("Canada Central")
                    .build()
            )
            .result(FaultInjectionResultBuilders
                .getResultBuilder(FaultInjectionServerErrorType.RESPONSE_DELAY)
                .delay(Duration.ofSeconds(2))
//                .times(20)
                .build()
            )
            .duration(Duration.ofSeconds(15))
            .startDelay(Duration.ofSeconds(8))
            .build();

        FaultInjectionRule westCentralLatency = new FaultInjectionRuleBuilder("west-central-latency")
            .condition(new FaultInjectionConditionBuilder()
                .operationType(FaultInjectionOperationType.READ_ITEM)
                .region("West Central US")
                .build()
            ).result(FaultInjectionResultBuilders
                    .getResultBuilder(FaultInjectionServerErrorType.RESPONSE_DELAY)
                    .delay(Duration.ofSeconds(2))
                    .build()
            )
            .startDelay(Duration.ofSeconds(22))
            .duration(Duration.ofMinutes(2))
            .build();

        CosmosFaultInjectionHelper.configureFaultInjectionRules(container, List.of(serverLatencyRule, westCentralLatency)).block();
    }

    private Mono<CosmosItemResponse<Person>> readItem() {
        CosmosItemRequestOptions requestOptions = new CosmosItemRequestOptions();
        requestOptions.setEnableEndToEndOperationLatencyPolicy(true);
        requestOptions.setConsistencyLevel(ConsistencyLevel.EVENTUAL);
        Mono<CosmosItemResponse<Person>> personCosmosItemResponse = cosmosAsyncClient.getDatabase(DATABASE)
            .getContainer(CONTAINER)
            .readItem("id" + 1, new PartitionKey("id" + 1), requestOptions, Person.class);
        return personCosmosItemResponse;
//        assert personCosmosItemResponse != null;
//        System.out.print("Read Person with id = " + personCosmosItemResponse.getItem().id + "\n");
    }

    private void createItems(int n) {
        for (int i = 0; i < REPEAT_COUNT; i++) {
            try {
                cosmosAsyncClient.getDatabase(DATABASE)
                    .getContainer(CONTAINER).createItem(new Person("id" + i, "name_" + i)).block();
            }catch (Exception ex){
                System.out.println("ex " + ex.getMessage());
            }
        }
        System.out.println("Items created " + n);
    }

    public void createCosmosAsyncClient() {

        CosmosEndToEndOperationLatencyPolicyConfig endToEndOperationLatencyPolicyConfig =
            new CosmosEndToEndOperationLatencyPolicyConfigBuilder()
                .endToEndOperationTimeout(Duration.ofSeconds(1))
                .enableSpeculativeProcessing(true)
                .build();

        // BEGIN: readme-sample-createCosmosAsyncClient
        cosmosAsyncClient = new CosmosClientBuilder()
            .preferredRegions(List.of("Canada Central", "West Central US"))
            .endpoint(END_POINT)
            .key(KEY)
            .endToEndOperationLatencyPolicyConfig(endToEndOperationLatencyPolicyConfig)
            .buildAsyncClient();
        // END: readme-sample-createCosmosAsyncClient
    }

    public static class Person{
        String id;
        String name;

        public Person() {
        }

        public Person(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
