package com.techgig.codegladiators;

import java.util.Scanner;


/*
2
6 1

5
3 7 9 11 13
 */
public class CricketBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfPacks = Integer.parseInt(sc.nextLine().trim());

        int[] numberOfBalls = new int[numberOfPacks];
        String[] inputNumberOfBalls = sc.nextLine().trim().split(" ");
        for(int i=0;i<numberOfPacks;i++){
            numberOfBalls[i] = Integer.parseInt(inputNumberOfBalls[i]);
        }

        int totalSteps = 0;

        for(int i=0;i<numberOfPacks;i++){
            totalSteps++;
            if(numberOfBalls[i]%2 ==0){
                totalSteps = totalSteps + (numberOfBalls[i]/2);
                totalSteps = totalSteps+numberOfBalls[i];
            }
            else{
                if(numberOfBalls[i]-1 >=1 && numberOfBalls[i]-1%2 ==0){
                    totalSteps = totalSteps + (numberOfBalls[i]-1/2);
                    totalSteps = totalSteps+numberOfBalls[i];
                }
            }
        }

        System.out.println(totalSteps);
    }
}
