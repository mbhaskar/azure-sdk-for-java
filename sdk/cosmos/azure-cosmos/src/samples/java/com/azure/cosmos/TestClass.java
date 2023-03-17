package com.azure.cosmos;

import com.azure.cosmos.models.CosmosEndToEndOperationLatencyPolicyConfig;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosItemResponse;
import com.azure.cosmos.models.PartitionKey;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestClass {

    private static final String PROD_END_POINT = "https://hamallap-dev-test.documents.azure.com:443/";
    public static final String PROD_KEY = "Hj16nd2oOxpWbz9WxNzYfmc6Vdij46ooMUOJMYEf4S4AFgeOPjX5jK1SSgNKR8tG9DFhmMC5KYIWQWCJla5shw==";

    private final static String EMULATOR_KEY = "C2y6yDjf5/R+ob0N8A7Cgv30VRDJIWEHLM" +
        "+4QDU5DE2nQ9nDuVTqobD4b8mGGyPMbIZnqyMsEcaGQy67XIw/Jw==";
    private final static String EMULATOR_HOST = "https://127.0.0.1:8081";

    //    private static final String END_POINT = EMULATOR_HOST;
    //    public static final String KEY = EMULATOR_KEY;

    private static final String END_POINT = PROD_END_POINT;
    public static final String KEY = PROD_KEY;

    public static final String DATABASE = "mydb";
    public static final String CONTAINER = "mycontainer";

    CosmosAsyncClient cosmosAsyncClient;

    CosmosAsyncDatabase database;
    CosmosAsyncContainer container;

    public static void main(String[] args) {

        TestClass c = new TestClass();
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
        injectFaults();
        List<Mono<CosmosItemResponse<Person>>> responseList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            responseList.add(readItem());
        }

        Flux.mergeSequential(responseList).blockLast();
    }

    private void injectFaults() {
//        FaultInjectionCondition
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
        for (int i = 0; i < n; i++) {
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
