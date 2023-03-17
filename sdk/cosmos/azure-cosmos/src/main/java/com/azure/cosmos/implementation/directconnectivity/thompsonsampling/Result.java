package com.azure.cosmos.implementation.directconnectivity.thompsonsampling;

public class Result {
    int armId;
    double reward;
    int timeId;
    public Result(){

    }
    public Result(int armId, double reward, int timeId) {
        this.armId = armId;
        this.reward = reward;
        this.timeId = timeId;
    }

    public int getArmId() {
        return armId;
    }

    public void setArmId(int armId) {
        this.armId = armId;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }
}
