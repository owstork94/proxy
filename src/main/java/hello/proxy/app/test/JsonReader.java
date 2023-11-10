package hello.proxy.app.test;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public static void main(String[] args) {
        String filePath = "C:\\test01.txt";

        try (BufferedReader jsonFileReader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonStringBuilder = new StringBuilder();
            String line;
            while ((line = jsonFileReader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }
            String jsonString = jsonStringBuilder.toString();

            // String을 JSONObject로 변환합니다.

            jsonParser(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void jsonParser(String jsonString) {
        JSONObject jObject = new JSONObject(jsonString);
        Object objkey = jObject.keySet();
//        Object objValue = jObject.get((String) objkey);
        System.out.println("objkey : "+objkey);
//        System.out.println("obValue : "+objValue);


        for (String key : jObject.keySet()){
            Object value = jObject.get(key);
            /*jsonParser(key);*/
            if (value instanceof String){
                System.out.println(key + "1: " + (String) value);
            }else if (value instanceof Integer){
                System.out.println(key + "2: " + (Integer) value);
            } else if (value instanceof Boolean) {
                System.out.println(key + "3: " + (Boolean) value);
            } else if (value instanceof JSONObject){
                System.out.println(key + "4:"+ value);
                if (value instanceof JSONArray){
                    System.out.println("Array*"+key + ": ");
                    JSONArray jArray = new JSONArray(value);
                    for (int i = 0; i< jArray.length(); i++){
                        jsonParser(jsonString);
                    }
                }
            } else if (value instanceof JSONArray) {
                System.out.println(key + ":");
                JSONArray jsonArray = new JSONArray(value);
                for (int i = 0; i < jsonArray.length(); i++ ){
                    jsonParser(jsonString);

                    }

                }

            }
        }
    }

