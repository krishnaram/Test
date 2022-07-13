package com.practise;

import java.util.TreeMap;

public class TreeMapFirstEntry {

    public static void main(String[] args){

        TreeMap<Double, Long> angleMap = new TreeMap<>();
        angleMap.put(45d, 51l);
        angleMap.put(41d, 52l);
        angleMap.put(40d, 53l);
        angleMap.put(39d, 54l);
        angleMap.put(35d, 55l);
        angleMap.put(32d, 56l);

        if(angleMap.firstEntry().getKey().intValue() < 40){
            long outgoingLinkId = angleMap.firstEntry().getValue().longValue();
            System.out.println(outgoingLinkId);
        }

    }

}
