package com.techgig.codegladiators;

import java.util.Scanner;

public class WorldArmyAlienArmy {
    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
        String[] startTime = sc.nextLine().trim().split(" ");
        String[] travelTime = sc.nextLine().trim().split(" ");
        String[] reachTime = new String[startTime.length];

        int hhStart;
        int mmStart;

        int hhTravel;
        int mmTravel;

        int hhReach;
        int mmReach;

        for(int i=0;i<startTime.length;i=i+2){
            hhStart = Integer.parseInt(startTime[i]);
            mmStart = Integer.parseInt(startTime[i+1]);
            System.exit(0);
            hhTravel = Integer.parseInt(travelTime[i]);
            mmTravel = Integer.parseInt(travelTime[i+1]);

            mmReach = mmStart+mmTravel;
            hhReach = hhStart+hhTravel;
            if(mmReach>=60){
                hhReach++;
                mmReach =mmReach-60;
            }
            if(hhReach>=24){
                hhReach = hhReach-24;
            }
            reachTime[i] = hhReach+"";
            reachTime[i+1] = mmReach+"";
        }

        for(int i=0;i<reachTime.length;i++){
            System.out.print(reachTime[i]+" ");
        }
    }
}
