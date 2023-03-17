package com.azure.cosmos.implementation.directconnectivity.thompsonsampling;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.commons.math3.distribution.GammaDistribution;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ThomsonSampling {

    public static final float EXPLORE_PROBABILITY = 0.1f;
    private static final int DEFAULT_WINDOW_SIZE = 10;
    private final Random random = new Random();
    private JsonNode jsonNode;
    private final Map<Integer, String> regionNameMap = new HashMap<>();
    private final ObjectMapper mapper = new ObjectMapper();

    private final List<Result> results;

    List<Double> alpha;
    List<Double> beta;
    int numberOfArms;
    ArrayList<Double> theta;
    List<Deque<Double>> rewards;

    private int windowSize = DEFAULT_WINDOW_SIZE;

    public ThomsonSampling(int numRegions, int windowSize) {
        alpha = new ArrayList<Double>(Collections.nCopies(numRegions, 1.0));
        alpha.set(0, 0.5);
        beta = new ArrayList<Double>(Collections.nCopies(numRegions, 1.0));
        beta.set(0, 0.5);
        results = new ArrayList<>();
        numberOfArms = numRegions;
        theta = new ArrayList<Double>(Collections.nCopies(numberOfArms, 1.0));
        theta.set(0, 0.5);
        // Initialize the sliding window of rewards for each arm
        rewards = new ArrayList<>(numberOfArms);
        for (int i = 0; i < numberOfArms; i++) {
            rewards.add(new ArrayDeque<>());
        }
        this.windowSize = windowSize;
    }

    public static void main(String[] args) {
        ThomsonSampling ts = new ThomsonSampling(3, 10);
        ts.testThomsonSampling();
    }

    private void testThomsonSampling() {
        loadInputJson("latencies.json");
        regionNameMap.put(0, "local");
        regionNameMap.put(1, "r1");
        regionNameMap.put(2, "r2");

        thompsonSamplingSlidingWindow(1000, 10);

    }

    private void loadInputJson(String filename) {
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)) {
            jsonNode = mapper.readValue(in, JsonNode.class);
            String jsonString = mapper.writeValueAsString(jsonNode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void thompsonSamplingSlidingWindow(int horizon, int windowSize) {
//        ArrayList<Integer> selections;
//        ArrayList<Double> rewardsReceived = new ArrayList<>();
        int arm = 0;

        for (int i = 0; i < horizon; i++) {
            // Sample whether to explore or exploit
            double r = random.nextDouble();


//            if (mustExplore) {
//                arm = explore();
//            } else {
            // Sample the parameters of the Gamma distribution for each arm from the posterior distribution

            // Select the arm with the lowest expected latency

            if (shouldExplore() >= 0) {
                explore();
            }
            arm = getArm();
//            }
//            selections = new ArrayList<>(Collections.nCopies(numberOfArms, 0));
//            selections.set(arm, 1);
//            // save selection at each step in a list for diagnostics if needed?

            double reward = getRewards(i, arm);
            updateReward(arm, reward);
//            System.out.println("arm selected:  = " + arm + " with reward: " + reward);
            results.add(new Result(arm, reward, i));

        }

        writeToFile(results);
    }

    public int getArm() {
        for (int j = 0; j < numberOfArms; j++) {
            theta.set(j, new GammaDistribution(alpha.get(j), 1 / beta.get(j)).sample());
        }
        int selection = this.theta.indexOf(Collections.min(this.theta));
        System.out.println("selection = " + selection);
        System.out.println("theta = " + theta);
        return selection; // TODO: This only picks up the first min index .Needs to be fixed as this needs to be biased towards local
    }

    public void updateReward(int arm, double latencyInMs) {
        rewards.get(arm).add(latencyInMs);
        //Update the posterior distribution for the parameters of the Gamma distribution for the selected arm
        if (rewards.get(arm).size() > windowSize) {
            double oldReward = rewards.get(arm).pop();
            alpha.set(arm, (alpha.get(arm) - oldReward));
            beta.set(arm, (beta.get(arm) - 1));
        }
        alpha.set(arm, (alpha.get(arm) + latencyInMs));
        beta.set(arm, (beta.get(arm) + 1));
    }

    private double getRewards(int timeStep, int actionIndex) {
        return jsonNode.get(timeStep).get(regionNameMap.get(actionIndex)).asDouble();
    }

    public int explore() {
        // Should return the next arm to explore. For now this is random with max weight on local
        double r = random.nextDouble();
        if (r < 0.8) return 0;
        else if (r < 0.9) return 1;
        else return 2;
    }

    private void writeToFile(List<Result> resultList) {
        System.out.println("Saving results to: results.json");
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(new File("result.json"), resultList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int shouldExplore() {
        // TODO: Improve the randomization and make it more generic
        double r = random.nextDouble();
        int val;
        if (r < 0.4) val = 0;
        else if (r < 0.8) val = 1;
        else val = 2;

        // 40% of the times with uniform dist of random.nextDouble()
        if(r > 0.6){
            return val;
        }
        else {
            // donot explore
            return -1;
        }
    }
}
