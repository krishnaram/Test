package com.json;

public class BinaryConversion {
    // Function to extract k bits from p position
    // and returns the extracted value as integer
    static int bitExtracted(long linkId, int k, int p)
    {
        return (int) ((linkId >> 17) & 0xFFFFFFFFL);
    }

    // Driver code
    public static void main (String[] args) {
        long number = 16397055559729227l;
        int k = 32, p = 17;
        System.out.println("The extracted number is "+
                bitExtracted(number, k, p));
        System.out.println("The extracted number is "+
                bitExtracted(number, k, p));
    }
}