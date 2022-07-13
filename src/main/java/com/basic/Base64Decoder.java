package com.basic;

import java.io.*;
import java.util.Base64;
import java.util.zip.GZIPInputStream;


public class Base64Decoder {

    public  static void main(String[] s) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("encodedBase64Cn.txt"));

        String encodedString = reader.readLine();

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);


        System.out.println(decodedString);

       // GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(decodedString.getBytes()));

        BufferedWriter writer = new BufferedWriter(new FileWriter("decodedFileCN.gzip"));
        writer.write(decodedString);

        reader.close();
        writer.close();
    }
}
