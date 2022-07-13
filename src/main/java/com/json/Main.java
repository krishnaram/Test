package com.company;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static Random random = new Random(7856);

    public static void main(String[] args) {
        int items =10_00_00_000;
        try{
            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("rrng.json")));
            bf.append("{\n\"attributes\": [");
            generate(bf,items);
            String data = "{\n" +
                          "\t\t\"linkId\": \"16397055559729227\",\n" +
                          "\t\t\"length\": \"14692\",\n" +
                          "\t\t\"trafficLights\": \"0\",\n" +
                          "\t\t\"stressLevel\": \"100\"\n" +
                          "\t\t}\n]\n" +
                          "}\n" ;
            bf.write(data);
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private  static void generate(BufferedWriter bf, int numItems) throws IOException{
        int millionCounter =0;
        for (int i = 1; i <numItems ; i++){
            Long linkId = random.nextLong();
            int averageSpeed = random.nextInt() % 150;
            int length = random.nextInt() % 150;
            int trafficLights = random.nextInt() % 10;
            int stressLevel = random.nextInt() % 100 + 1;
            String data = "\t{\n" +
                          "\t\t\"linkId\": \"" + Math.abs(linkId) + "\",\n" +
                          "\t\t\"length\": \"" + Math.abs(length )+ "\",\n" +
                          " \t\t\"averageSpeed\":\"" + Math.abs(averageSpeed) + "\",\n" +
                          " \t\t\"trafficLights\":\"" + Math.abs(trafficLights )+ "\",\n" +
                          " \t\t\"stressLevel\": \"" + Math.abs(stressLevel) + "\"\n\t},\n";
            bf.append(data);
            if(i%10_00_000 == 0) System.out.println("written "+ ++millionCounter + "items.");
        }
    }
}
