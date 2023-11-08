package hello.proxy.trace.logtrace;



import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonReader02 {
    public static void main(String[] args) {
        // 파싱할 내용 문자열 화
        String filePath = "C:\\test01.txt";
//        Pattern pattern = Pattern.compile("\"(.*?)\"\\s*:\\s*\"(.*?)\"");
        Pattern pattern = Pattern.compile("\"(.*?)\"\\s*:\\s*(\".*?\"|\\d+)");


        try (BufferedReader jsonFileReader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonStringBuilder = new StringBuilder();
            String line;
            while ((line = jsonFileReader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }

            String jsonString = jsonStringBuilder.toString();
            System.out.println("jsonString : "+jsonString);
            // JOBJect 미사용 파싱
            regexJParsing(pattern, jsonString);

            // JSONObject로 활용 파싱
//            JSONObjParsing(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void JSONObjParsing(String jsonString) {
        JSONObject jObject = new JSONObject(jsonString);

        for (String key : jObject.keySet()){
            Object value = jObject.get(key);
        }
    }

    private static void regexJParsing(Pattern pattern, String jsonString) {
        Matcher matcher = pattern.matcher(jsonString);
        System.out.println("without JSONO");
        while (matcher.find()){
            String key = matcher.group(1);
            String value = matcher.group(2);
            System.out.println(key + ": " + value);
        }
    }
}
