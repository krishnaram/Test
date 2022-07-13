package com.techgig.codegladiators;

import java.util.Scanner;

public class ChantuBantuGifts {
    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine().trim());
        int numberOfGifts;
        int giftsAvailable;
        String[] priceOfGifts;
        int[] priceOfGiftsInt;
        int minMoneyRequired;
        int giftAmount  ;
        int giftAmountMax = Integer.MIN_VALUE;
        int giftPrice;
        for(int i=0;i<testCases;i++){
            giftAmount = 0 ;
            numberOfGifts = Integer.parseInt(sc.nextLine().trim());
            giftsAvailable = Integer.parseInt(sc.nextLine().trim());
            priceOfGifts = sc.nextLine().trim().split(" ");
            priceOfGiftsInt = new int[giftsAvailable];

            for(int j=0;j<giftsAvailable;j++)
                priceOfGiftsInt[j] = Integer.parseInt(priceOfGifts[j]);

            for (int j = 0; j < priceOfGiftsInt.length - 1; j++)
                for (int k = 0; k < priceOfGiftsInt.length - j - 1; k++)
                    if (priceOfGiftsInt[k] > priceOfGiftsInt[k + 1]) {
                        // swap arr[j+1] and arr[j]
                        int temp = priceOfGiftsInt[k];
                        priceOfGiftsInt[k] = priceOfGiftsInt[k + 1];
                        priceOfGiftsInt[k + 1] = temp;
                    }

            for(int j=0;j<numberOfGifts;j++){
                giftAmount += priceOfGiftsInt[j];
            }

            System.out.println(giftAmount);
        }

    }
}
