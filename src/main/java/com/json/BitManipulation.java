package com.json;

public class BitManipulation {
    //NUmber 16
    //1000
    //NUmber 33
    //10001
    public static void main(String[] args) {
        int zero = 0;
        int one =1;
        int sixTeen = 16;

        int thirtyThree = (sixTeen<<1) | one;
        int thirtyTwo = (sixTeen<<1) | zero;


        System.out.println("Thirty three is: "+thirtyThree);
        System.out.println("Thirty two is: "+thirtyTwo);

        long  linkId = 151434663842676737l;

        long directionBit =  (linkId>>64) & one;

        System.out.println("directionBit is: "+directionBit);

        long directionLessLinkId =  (linkId>>1);

        System.out.println("directionLess linkid is: "+directionLessLinkId);

        int urId =410;
        int urIndex = 113;

        long luxemborgLinkId = 63684827002568710l;
        //1110 001 |0 0100 0001 0000 0011 0100 0011 0001 001 |0 0000 0000 0000 011 |0
        //           |0100 0001 0000 0011 0100 0011 0001 0010 0000 0000 0000 0110
        //110011010 |0 0100 0001 0000 0011 0100 0011 0001 001 |0 0000 0000 0000 011 |0 - Need to come to this result
        //230880963168698374 - TI link id with direction bit ending
        //115440481584349187 - This is TI link ID for this

        int tile = (int) ((luxemborgLinkId >> 17) & 0xFFFFFFFFL);
        int urIndexBit = (int) ((luxemborgLinkId >> 49) );

        System.out.println("tile number: "+tile);

        System.out.println("urIndexBit number:"+urIndexBit);
        long urIdToLast16 = ((long) urId << 49);
        System.out.println("Promoted to 49 bit position: "+urIdToLast16);

        long onlyTileLinkDir = (((0xFFFFFFFFFFFFL+1) | 0xFFFFFFFFFFFFL)) & luxemborgLinkId;
        System.out.println("only tile link and direction: "+onlyTileLinkDir );
        System.out.println("Urid with last 16 bits"+urIdToLast16);
        long tiLinkId = (urIdToLast16 | onlyTileLinkDir);
        System.out.println("To ti link id:"+ tiLinkId);

        System.out.println(0xFFFFFFFFFFFFL);


    }
}
