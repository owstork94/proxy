package hello.proxy.trace.logtrace;

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
            JSONObject jObject = new JSONObject(jsonString);

            for (String key : jObject.keySet()){
                Object value = jObject.get(key);
//                System.out.println("key : "+key);
//                System.out.println("value : "+value);

                if (value instanceof String){
                    System.out.println(key + ": " + (String) value);
                }else if (value instanceof Integer){
                    System.out.println(key + ": " + (Integer) value);
                } else if (value instanceof Boolean) {
                    System.out.println(key + ": " + (Boolean) value);
                } else if (value instanceof JSONObject){
                    System.out.println(key + " :"+ value);
                }
//                else if (value instanceof JSONArray){
//                    System.out.println("value : "+value);
            }


//            String title = jObject.getString("title");
//            String url = jObject.getString("url");
//            Boolean draft = jObject.getBoolean("draft");
//            int star = jObject.getInt("star");
//

//            System.out.println("title1: " + title);
//            System.out.println("url1: " + url);
//            System.out.println("draft1: " + draft);
//            System.out.println("star1: " + star);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
