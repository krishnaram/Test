package com.techgig.codegladiators;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LalaLand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] firstLine = sc.nextLine().trim().split(" ");
        int numberOfNode = Integer.parseInt(firstLine[0]);
        int numberOfRoute = Integer.parseInt(firstLine[1]);
        int[][] routeNodeCost = new int[numberOfNode][numberOfNode];
        String[] input;
        for(int i=0;i<numberOfRoute;i++){
            input = sc.nextLine().trim().split(" ");
            routeNodeCost[Integer.parseInt(input[0])-1][Integer.parseInt(input[1])-1] = Integer.parseInt(input[2]);
            routeNodeCost[Integer.parseInt(input[1])-1][Integer.parseInt(input[0])-1] = Integer.parseInt(input[2]);
        }

        int[] routedNodes = new int[numberOfNode];
        System.out.println(routeNodeCost[0][1]);
        int destinationNode = numberOfNode-1;
        int currentNode = 0;
        while(currentNode == destinationNode){
        }
    }
}
