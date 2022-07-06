package com.myweather.myweather.controller;

import com.myweather.myweather.Constants;
import com.myweather.myweather.model.AirQuality;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ISO53
 */
@CrossOrigin
@RestController
@RequestMapping("/AirQuality")
public class AirQualityController {

    @RequestMapping("/current")
    public AirQuality current(@RequestParam(value = "location") String location) {

        float[] latAndLon = getLatAndLon(location);

        String content;
        try {
            URL obj = new URL("http://api.openweathermap.org/data/2.5/air_pollution?lat=" + latAndLon[0] + "&lon=" + latAndLon[1] + "&appid=" + Constants.APPID);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            content = response.toString();
        } catch (Exception e) {
            System.out.print("ERROR : " + e.getMessage());
            e.printStackTrace();
            return null;
        }

        JSONObject root = new JSONObject(content);

        JSONObject listObj = root.getJSONArray("list").getJSONObject(0);

        JSONObject main = listObj.getJSONObject("main");

        JSONObject components = listObj.getJSONObject("components");

        AirQuality airQuality = new AirQuality(
                main.getInt("aqi"), /* Air Quality */
                (float) components.getDouble("co"), /* CO */
                (float) components.getDouble("no"), /* NO */
                (float) components.getDouble("no2"), /* NO2 */
                (float) components.getDouble("o3"), /* O3 */
                (float) components.getDouble("so2"), /* SO2 */
                (float) components.getDouble("pm2_5"), /* PM2.5 */
                (float) components.getDouble("pm10"), /* PM10 */
                (float) components.getDouble("nh3") /* NH3 */
        );

        return airQuality;
    }

    @RequestMapping("/interval")
    public AirQuality[] interval(@RequestParam(value = "location") String location) {   // Five days with 1 hour interval air quality forecast

        float[] latAndLon = getLatAndLon(location);

        String content;
        try {
            URL obj = new URL("http://api.openweathermap.org/data/2.5/air_pollution/forecast?lat=" + latAndLon[0] + "&lon=" + latAndLon[1] + "&appid=" + Constants.APPID);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            content = response.toString();
        } catch (Exception e) {
            System.out.print("ERROR : " + e.getMessage());
            e.printStackTrace();
            return null;
        }

        JSONObject root = new JSONObject(content);

        JSONArray list = root.getJSONArray("list");

        AirQuality[] airQualityList = new AirQuality[list.length()];
        
        for (int i = 0; i < list.length(); i++) {
            
            JSONObject listObj = list.getJSONObject(i);
            
            JSONObject main = listObj.getJSONObject("main");

            JSONObject components = listObj.getJSONObject("components");

            AirQuality airQuality = new AirQuality(
                    main.getInt("aqi"), /* Air Quality */
                    (float) components.getDouble("co"), /* CO */
                    (float) components.getDouble("no"), /* NO */
                    (float) components.getDouble("no2"), /* NO2 */
                    (float) components.getDouble("o3"), /* O3 */
                    (float) components.getDouble("so2"), /* SO2 */
                    (float) components.getDouble("pm2_5"), /* PM2.5 */
                    (float) components.getDouble("pm10"), /* PM10 */
                    (float) components.getDouble("nh3") /* NH3 */
            );
            
            airQualityList[i] = airQuality;
        }

        return airQualityList;
    }

    public float[] getLatAndLon(String location) {
        String content;
        try {
            URL obj = new URL("http://api.openweathermap.org/geo/1.0/direct?q=" + location + "&limit=1&appid=" + Constants.APPID);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            content = response.toString();
        } catch (Exception e) {
            System.out.print("ERROR : " + e.getMessage());
            e.printStackTrace();
            return new float[]{-1, -1};
        }

        JSONArray rootArray = new JSONArray(content);
        JSONObject root = rootArray.getJSONObject(0);

        return new float[]{
            root.getInt("lat"),
            root.getInt("lon")
        };
    }
}
