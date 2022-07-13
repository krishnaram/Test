package com.company;

/*
@author amitjaiswal
*/
public class RoadNetJson{
    private long linkId;
    private double length;
    private double averageSpeed;
    private int trafficLights;
    private double stressLevel;

    public long getLinkId(){
        return linkId;
    }

    public void setLinkId(long linkId){
        this.linkId = linkId;
    }

    public double getLength(){
        return length;
    }

    public void setLength(double length){
        this.length = length;
    }

    public double getAverageSpeed(){
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed){
        this.averageSpeed = averageSpeed;
    }

    public int getTrafficLights(){
        return trafficLights;
    }

    public void setTrafficLights(int trafficLights){
        this.trafficLights = trafficLights;
    }

    public double getStressLevel(){
        return stressLevel;
    }

    public void setStressLevel(double stressLevel){
        this.stressLevel = stressLevel;
    }
}
