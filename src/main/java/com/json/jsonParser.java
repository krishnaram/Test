package com.company;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
@author amitjaiswal
*/
public class jsonParser{

    static int counter = 0;
    static long lastTime = System.currentTimeMillis();

    public static void main(String[] args){
        try (BufferedReader br = new BufferedReader(new FileReader("rrng.json"))){
            JsonReader jsonReader = new JsonReader(br);
            handleJsonObject(jsonReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void handleJsonObject(JsonReader jsonReader){
        try{
            jsonReader.beginObject();
            while (jsonReader.hasNext()){
                JsonToken token = jsonReader.peek();
                if (token.equals(JsonToken.BEGIN_ARRAY)){
                    handleJsonArray(jsonReader);
                } else if (token.equals(JsonToken.BEGIN_OBJECT)){
                    handleJsonObject(jsonReader);
                } else{
                    String fieldname = jsonReader.nextName();
                    JsonToken nexttoken = jsonReader.peek();
                    if (nexttoken.equals(JsonToken.BEGIN_ARRAY)){
                        handleJsonArray(jsonReader);
                    }
                    String val = jsonReader.nextString();
                   // System.out.println(fieldname + ":" + val);
                    if ("stressLevel".equals(fieldname)){
                        counter++;
                        if (counter % 800_000 == 0){
                            System.out.println("processed " + counter + " in " + (System.currentTimeMillis() - lastTime) + "ms.");
                            lastTime = System.currentTimeMillis();
                        }
                    }
                }
            }
            jsonReader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleJsonArray(JsonReader reader) throws IOException{
        reader.beginArray();
        while (reader.hasNext()){
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.BEGIN_OBJECT)){
                handleJsonObject(reader);
            } else if (token.equals(JsonToken.BEGIN_ARRAY)){
                handleJsonArray(reader);
            }
        }
        reader.endArray();
    }

    private static int bitExtracted(int number, int k, int p)
    {
        return (((1 << k) - 1) & (number >> (p - 1)));
    }
}
