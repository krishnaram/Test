package com.techgig;

import java.util.Scanner;

/**
 6 9 3
 3
 4
 5
 1 2 7
 1 6 6
 2 3 1
 2 6 5
 3 4 1
 3 5 3
 4 5 1
 4 6 4
 5 6 10

 output - 6
 */

/**
 3 3 1
 3
 1 2 1
 1 3 3
 2 3 2

 output -4
 */


public class SamsungPrimAlgoCustom {

    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputArray = input.split(" ");
        int n = 0;
        int m = 0;
        int k = 0;

        n = Integer.parseInt(inputArray[0]);
        m = Integer.parseInt(inputArray[1]);
        k = Integer.parseInt(inputArray[2]);
        int[][] edges = new int[n][n];


        int[] effctedCity = new int[n];

        for(int i=0;i<k;i++){
            effctedCity[sc.nextInt()-1] = 1;
        }
        sc.nextLine();
        for(int i=0;i<m;i++) {
            input = sc.nextLine();
            inputArray = input.split(" ");
            edges[Integer.parseInt(inputArray[0]) - 1][Integer.parseInt(inputArray[1]) - 1] = Integer.parseInt(inputArray[2]);
            edges[Integer.parseInt(inputArray[1]) - 1][Integer.parseInt(inputArray[0]) - 1] = Integer.parseInt(inputArray[2]);
        }
        int minimumLen = Integer.MAX_VALUE;
        int len = 0;
        int[] effctedCityVisit = new int[k];
        int[] visited = new int[n];

        for(int i=0;i<n;i++){
            len = navigate(i,edges,visited, effctedCity, 0, k);
            minimumLen = len<minimumLen?len:minimumLen;
        }
        System.out.println(minimumLen);
    }

   public static int   navigate(int current, int[][] edges,int[] visited, int[] effected,int len,int effectedCount){
        if(effectedCount ==0){
            return len;
        }
        int[] newVisited = visited.clone();
        int tempLen;
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<edges.length;i++){
            newVisited = visited.clone();
            if(edges[current][i]!=0 && i!= current ){
                newVisited[i] = 1;
                if(effected[i]==1){
                    effectedCount --;
                }
                tempLen = navigate(i,edges,newVisited,effected,len + edges[current][i],effectedCount);
                if(minLen>tempLen){
                    minLen = tempLen;
                }
            }
        }
    return minLen;
    }

    void isVistedAllEffected(boolean[] effectedVisited, int[] effected){

    }
}
