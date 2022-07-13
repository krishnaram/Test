package com.json;

public class Link {
    long linkId;
    int length;
    int averageSpeed;
    int trafficLights;
    int stressLevel;

    public Link(long linkId, int length, int averageSpeed, int trafficLights, int stressLevel) {
        this.linkId = linkId;
        this.length = length;
        this.averageSpeed = averageSpeed;
        this.trafficLights = trafficLights;
        this.stressLevel = stressLevel;
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkId=" + linkId +
                ", length=" + length +
                ", averageSpeed=" + averageSpeed +
                ", trafficLights=" + trafficLights +
                ", stressLevel=" + stressLevel +
                '}';
    }

    public long getLinkId() {
        return linkId;
    }

    public int getLength() {
        return length;
    }

    public int getAverageSpeed() {
        return averageSpeed;
    }

    public int getTrafficLights() {
        return trafficLights;
    }

    public int getStressLevel() {
        return stressLevel;
    }
}
