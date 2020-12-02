package src.by.gsu.pms;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

    private static HttpURLConnection connection;

    public static final String URL_SOURCE = "<paste_your_own>";

    // convert json into a map
    public static Map<String, Object> jsonToMap(String str){
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String,Object>>() {}.getType()
        );
        return map;
    }

    public static void main(String[] args) {

        try {
            BufferedReader reader;
            String line;
            StringBuffer responceContent = new StringBuffer();

            URL url = new URL(URL_SOURCE);
            connection = (HttpURLConnection) url.openConnection();

            // Request setup:
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); //ms
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            // System.out.println(status);

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine()) != null ) {
                    responceContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null ) {
                    responceContent.append(line);
                }
                reader.close();
            }

            //System.out.println(responceContent.toString());

            //Gson gson = new Gson();
            //Weather_v2 obj = gson.fromJson(responceContent.toString(), Weather_v2.class);
            //for (int i = 0; i < obj.weather.size(); i++) {
            //    System.out.println(obj.weather.get(i).description);
            //}

            Map<String, Object> respMap = jsonToMap(responceContent.toString());
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
            Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
            Map<String, Object> sysMap = jsonToMap(respMap.get("sys").toString());
            Map<String, Object> cloudsMap = jsonToMap(respMap.get("clouds").toString());

            // get weather as list
            List<Map<String, Object >> weather = (List<Map<String, Object>>) (respMap.get("weather"));

            // assume weather contents at list 1 argument
            Map<String, Object> weatherMap = weather.get(0);

            String cityName = respMap.get("name").toString();
            String cityId = sysMap.get("country").toString();
            String iconId = weatherMap.get("icon").toString();
            String briefDescription = weatherMap.get("main").toString();
            String fullDescription = weatherMap.get("description").toString();
            String currentDegree = mainMap.get("temp").toString();
            String pressure = mainMap.get("pressure").toString();
            String humidity = mainMap.get("humidity").toString();
            String minTempToday = mainMap.get("temp_min").toString();
            String maxTempToday = mainMap.get("temp_max").toString();
            String windSpeed = windMap.get("speed").toString();
            String windDeg = windMap.get("deg").toString();
            String clouds = cloudsMap.get("all").toString();


            // output:
            //System.out.println("Название города: " + respMap.get("name"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }


    }
}
