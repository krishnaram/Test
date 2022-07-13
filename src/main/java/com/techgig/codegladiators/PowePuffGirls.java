package com.techgig.codegladiators;

import java.util.Scanner;

/*
4
2 5 6 3
20 40 90 50

4
2 5 6 0
20 40 90 50

4
2 5 6 3
20 40 90 0


4
2 5 6 3
20 40 90 2

 */
public class PowePuffGirls {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int totalIngerdicents = Integer.parseInt(sc.nextLine().trim());
        String[] ingrediantsNeeded = sc.nextLine().split(" ");
        String[] ingrediantsProvided = sc.nextLine().split(" ");

        Long minPowerGirl = Long.MAX_VALUE;
        Long eachMinValue = 0l;

        for(int i=0;i<ingrediantsNeeded.length;i++){
            eachMinValue = Long.parseLong(ingrediantsProvided[i])/Long.parseLong(ingrediantsNeeded[i]);
            if(eachMinValue<minPowerGirl){
                minPowerGirl = eachMinValue;
            }
        }
        if(minPowerGirl<Long.MAX_VALUE){
            System.out.println(minPowerGirl);
        }
        else{
            System.out.println(0);
        }

    }
}
