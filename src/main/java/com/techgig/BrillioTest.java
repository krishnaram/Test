package com.techgig;

import java.util.Scanner;

public class BrillioTest {

    public static  void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String[] proxyStr = sc.nextLine().split(" ");
        int pos;
        int[] actualArray  = new int[n];
        for(int i=0;i<n;i++){
            pos = Integer.parseInt(proxyStr[i]);
            actualArray[pos-1] = pos;
        }
        StringBuffer printString = new StringBuffer();
        for(int i=0;i<n;i++){
            if(actualArray[i] ==0){
                printString.append(i+1+" ");
            }
        }
        printString.deleteCharAt(printString.length()-1);
        System.out.println(printString);
    }
}
