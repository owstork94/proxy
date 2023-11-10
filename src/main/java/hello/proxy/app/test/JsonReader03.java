package hello.proxy.app.test;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader03 {
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
            JSONObject jObject = new JSONObject(jsonString);
            jsonParser(jObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void jsonParser(JSONObject jObject) {

        for (String key : jObject.keySet()){
            Object value = jObject.get(key);
            /*jsonParser(key);*/
            if (value instanceof JSONObject){
                System.out.println("35"+key+": ");
                jsonParser((JSONObject) value);
            } else if (value instanceof JSONArray) {
                JSONArray jsonArray = new JSONArray(value);
                //array 파싱 ([])
                System.out.println("40"+key+": ");
                // json array 갯수만큼 jsonParser 호출 하되 대상이 JSONObject 일떄만
                    for (int i = 0; i < jsonArray.length(); i++ ){
                        Object item = jsonArray.get(i);
                        System.out.println("jsonArray contents : "+jsonArray.get(i));
                    }
                }else{
                System.out.println(key+": "+value);
                }

            }
//        else {
//                //일반적인 형태 파싱
//                System.out.println("일반적인 형태");
//                System.out.println(key+":"+value);
//            }

        }
    }


