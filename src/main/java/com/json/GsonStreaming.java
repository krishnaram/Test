package com.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;

public class GsonStreaming {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        GsonStreaming gsonStreaming = new GsonStreaming();
        String jsonFilePath = "/media/sf_PI/PI3_2021/Stress_API/rrn.json/rrn.json";
        gsonStreaming.parse(jsonFilePath);
        System.out.println("Total Time Taken : "+(System.currentTimeMillis() - start)/1000 + " secs");
    }
    public void parse(String jsonFilePath){
        //create JsonReader object and pass it the json file,json source or json text.
        try(JsonReader jsonReader = new JsonReader(
                new InputStreamReader(
                        new FileInputStream(jsonFilePath), StandardCharsets.UTF_8))) {
            Gson gson = new GsonBuilder().create();
            jsonReader.beginObject();
            String name = jsonReader.nextName();
            jsonReader.beginArray();
            int numberOfRecords = 0;
            Runtime runtime = Runtime.getRuntime();

            NumberFormat format = NumberFormat.getInstance();

            StringBuilder sb = new StringBuilder();
            long maxMemory = runtime.maxMemory();
            long allocatedMemory = runtime.totalMemory();
            long freeMemory = runtime.freeMemory();

            sb.append("free memory: " + format.format(freeMemory / 1024) + "<br/>");
            sb.append("allocated memory: " + format.format(allocatedMemory / 1024) + "<br/>");
            sb.append("max memory: " + format.format(maxMemory / 1024) + "<br/>");
            sb.append("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + "<br/>");
            System.out.println(sb.toString());
            while (jsonReader.hasNext()){ //next json array element
                JsonToken token = jsonReader.peek();
                if (token.equals(JsonToken.BEGIN_OBJECT)){
                    jsonReader.hasNext();
                    jsonReader.nextName();
                    jsonReader.nextString();
                    numberOfRecords++;
                }
               // Link link = gson.fromJson(jsonReader, Link.class);
                //do something real
//                System.out.println(document);
            }
            jsonReader.endArray();
            System.out.println("Total Records Found : "+numberOfRecords);
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
