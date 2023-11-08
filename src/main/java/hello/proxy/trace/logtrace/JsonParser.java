package hello.proxy.trace.logtrace;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonParser {
    public static void main(String[] args) {
        String filePath = "C:\\test02.txt";

        try (BufferedReader jsonFileReader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonStringBuilder = new StringBuilder();
            String line;
            while ((line = jsonFileReader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }
            String jsonString = jsonStringBuilder.toString();
            JSONObject jsonObject = new JSONObject(jsonString);
            // 초기 들여쓰기는 0으로 시작합니다.
            parseJson(jsonObject, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseJson(JSONObject jsonObject, int indent) {
        jsonObject.keySet().forEach(key -> {
            printIndent(indent);
            Object value = jsonObject.get(key);
            if (value instanceof JSONObject) {
                System.out.println("1"+key + ": ");
                parseJson((JSONObject) value, indent + 1);
            } else {
                System.out.println("2"+key + ": " + value);
            }
        });
    }

    private static void printIndent(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("    "); // 4개의 공백으로 들여쓰기
        }
    }
}