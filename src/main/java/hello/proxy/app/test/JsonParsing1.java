package hello.proxy.app.test;//package hello.proxy.trace.logtrace;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.*;
//
//public class JsonParsing1 {
//
//    public static void jsonParsing1() throws JSONException {
//        String jsonString = "{\"title\": \"how to get stroage size\","
//                + "\"url\": \"https://codechacha.com/ko/get-free-and-total-size-of-volumes-in-android/\","
//                + "\"draft\": false,"
//                + "\"star\": 10"
//                + "}";
//
//        String filePath = "D/jsonfile.txt";
//
//        try (BufferedReader jsonFileReader = new BufferedReader(new FileReader(filePath)) {
//            StringBuilder jsonStringBuilder = new StringBuilder();
//            String line;
//            while ((line = jsonFileReader.readLine()) != null) {
//                jsonStringBuilder.append(line);
//        }
//
//            // StringBuilder에 저장된 문자열을 String으로 변환합니다.
//            String jsonString = jsonStringBuilder.toString();
//
//            // String을 JSONObject로 변환합니다.
//            JSONObject jObject = new JSONObject(jsonString);
//
//            // JSONObject에서 필요한 데이터를 추출합니다.
//            String title = jObject.getString("title");
//            String url = jObject.getString("url");
//            Boolean draft = jObject.getBoolean("draft");
//            int star = jObject.getInt("star");
//
//            // 추출된 데이터를 출력합니다.
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("title1: " + title);
//        System.out.println("url1: " + url);
//        System.out.println("draft1: " + draft);
//        System.out.println("star1: " + star);
//    }
//}
//
