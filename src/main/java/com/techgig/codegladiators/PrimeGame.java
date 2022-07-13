package com.techgig.codegladiators;

import java.util.Scanner;

/*
5
5 5
2 7
8 10
10 20
4 5

 */
public class PrimeGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine().trim());
        int[][] rangeNumber = new int[tc][2];
        String[] rangeInput;

        int higestPrime;
        int lowestPrime;

        for(int i=0;i<tc;i++){
            rangeInput = sc.nextLine().trim().split(" ");
            rangeNumber[i][0] =Integer.parseInt(rangeInput[0]);
            rangeNumber[i][1] =Integer.parseInt(rangeInput[1]);
        }

        int start;
        boolean isPrimeFound;
        for(int[] range: rangeNumber){
            isPrimeFound = false;
            higestPrime = range[0];
            lowestPrime = range[1];
            start = range[0];
            if(range[0] ==2){
                lowestPrime = range[0];
            }
            if(range[0]%2 ==0){
                start = range[0]+1;

            }
            for(int i=start ;i<=range[1];i=i+2){
                if(i%2 ==0){
                    continue;
                }
                else{
                    if(isPrime(i)){

                        if(i>=higestPrime){
                            higestPrime = i;
                        }
                        if(i<=lowestPrime){
                            lowestPrime = i;
                        }
                        isPrimeFound = true;
                    }
                }
            }
            if(isPrimeFound){
                System.out.println(higestPrime-lowestPrime);
            }
            else{
                System.out.println(-1);
            }
        }

    }

    public static boolean isPrime(int number){
        boolean isPrime = true;
        for (int j = 3; j * j <= number; j=j+2) {
            if (number % j == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
