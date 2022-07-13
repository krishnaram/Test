package com.practise;

import java.util.Scanner;

/*
4 4 4 4 4 4 4
4 3 3 3 3 3 4
4 3 2 2 2 3 4
4 3 2 1 2 3 4
4 3 2 2 2 3 4
4 3 3 3 3 3 4
4 4 4 4 4 4 4
 */
public class PatternArray {
    public  static  void main(String[] args){
        System.out.println("Enter a number for pattern:");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        int loopRow = (n-1) + n;
        int[][] patternArray = new int[loopRow][loopRow];
        boolean oneCaptured = false;
        for(int i=0;i<loopRow;i++){
            for(int j=0;j<loopRow;j++){
                if(i == 0 || i== loopRow-1 || j == loopRow-1 || j== 0 ){
                    patternArray[i][j] = n;
                    continue;
                }
                else if(patternArray[i][j-1] == (patternArray[i-1][j]+1)){
                    patternArray[i][j] = patternArray[i-1][j];
                    continue;
                }
                else if(patternArray[i-1][j+1] == (patternArray[i-1][j]+1)){
                    patternArray[i][j] = patternArray[i-1][j];
                    continue;
                }
                patternArray[i][j] = patternArray[i-1][j]-1;

            }
        }
        printArray(patternArray);

    }

    static void  printArray(int[][] patternArray){
        int loopRow = patternArray.length;
        for(int i=0;i<loopRow;i++){
            for(int j=0;j<loopRow;j++){
                System.out.print(patternArray[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
