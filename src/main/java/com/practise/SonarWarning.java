package com.practise;

public class SonarWarning {
    public static void main(String[] args) {
        int a[] = null;

        // Create an array b[] of same size as a[]
        int b[] = new int[a.length];

        // Copy elements of a[] to b[]
        System.arraycopy(a, 0, b, 0, 3);


    }
}
