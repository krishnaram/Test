package com.basic;

public class TileId {
    /**
     * Returns the minimum packed tile id for the given level.
     *
     * @param levelNum level number
     * @return minimum tile id
     */
    public static long getPackedTileIdMin(int levelNum)
    {
        return getPackedTileId(0, levelNum);
    }

    /**
     * Returns the maximum packed tile id for the given level.
     *
     * @param levelNum level number
     * @return maximum tile id
     */
    public static long getPackedTileIdMax(int levelNum)
    {
        int count = (1 << (2 * levelNum + 1)) - 1;
        return getPackedTileId(count, levelNum);
    }

    public static long convertToJava(long linkId){
        return ( linkId >> 1);
    }

    public static long getNDSLink(long tileNumber,int sequence){
        return (long)3<<49 | (long) tileNumber << 17 |(long) sequence<< 1;
    }

    /**
     * Converts this TileId to a packed tile id.
     *
     * @param tileNum  tile number
     * @param levelNum level number
     * @return packed value
     */
    public static long getPackedTileId(long tileNum, int levelNum)
    {
        long result = 1L << (16 + levelNum); // 2 ^ (16 + levelNum)
        result += tileNum;
        return result;
    }

    public static void main(String[] args){
       // System.out.println("Min tile id:"+getPackedTileIdMin(13));
       // System.out.println("Max tile id:"+getPackedTileIdMax(13));
        System.out.println("Link id:"+convertToJava(73089931805140l));

        //this.sequenceNumber = (int) (packedId & 0xFFFFL);         // read first 2 bytes
        //        this.tileNumber = (int) ((packedId >> 16) & 0xFFFFFFFFL); // skip 2 bytes and read next 4 bytes
        //        this.updateRegionId = getUpdateRegionId(packedId);
        System.out.println("Link id:"+getNDSLink(557631926,234));
        long tileId = getPackedTileId(557631926,13);
        long longLinkId = toPackedId(234,tileId,5341);
        System.out.println("Link id:"+longLinkId);
        System.out.println("Actual Link id:"+73089931805140l);
    }

    public static long toPackedId(int sequenceNumber,long tileNumber,int updateRegionId)
    {
        return sequenceNumber | ((long) tileNumber << 16) ;
    }


}
