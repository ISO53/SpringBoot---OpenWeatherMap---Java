package com.myweather.myweather.controller;

import com.myweather.myweather.Constants;
import com.myweather.myweather.model.Weather;
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
@RequestMapping("/Weather")
public class WeatherController {

    @RequestMapping("/current")
    public Weather current(@RequestParam(value = "location") String location) {

        String content;
        try {
            URL obj = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + Constants.APPID);
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

        JSONObject main = root.getJSONObject("main");

        JSONObject sys = root.getJSONObject("sys");

        JSONObject wind = root.getJSONObject("wind");

        JSONArray wea = root.getJSONArray("weather");
        JSONObject weas = wea.getJSONObject(0);

        return new Weather(
                weas.getString("description"),
                sys.getString("country"),
                root.getString("name"),
                main.getInt("temp"),
                main.getInt("temp_min"),
                main.getInt("temp_max"),
                main.getInt("humidity"),
                main.getInt("pressure"),
                wind.getInt("deg"),
                wind.getInt("speed")
        );
    }

    @RequestMapping("/interval")
    public Weather[] interval(@RequestParam(value = "location") String location) {  // Five days with 3 hours interval weather forecast

        float[] latAndLon = getLatAndLon(location);

        String content;
        try {
            URL obj = new URL("http://api.openweathermap.org/data/2.5/forecast?lat=" + latAndLon[0] + "&lon=" + latAndLon[1] + "&appid=" + Constants.APPID);
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

        Weather[] weatherList = new Weather[30];

        for (int i = 0; i < weatherList.length; i++) {
            
            JSONObject root = new JSONObject(content);
            
            JSONArray list = root.getJSONArray("list");
            
            JSONObject city = root.getJSONObject("city");
            
            JSONObject currentObj = list.getJSONObject(i);
            
            JSONObject main = currentObj.getJSONObject("main");
            
            JSONObject wind = currentObj.getJSONObject("wind");
            
            JSONObject weather = currentObj.getJSONArray("weather").getJSONObject(0);

            Weather tempWeat = new Weather(
                    weather.getString("description"),   /* Description */
                    city.getString("country"),          /* Country */
                    city.getString("name"),             /* City */
                    main.getInt("temp"),                /* Temperature */
                    main.getInt("temp_min"),            /* Min. Temperature */
                    main.getInt("temp_max"),            /* Max. Temperature */
                    main.getInt("humidity"),            /* Humidity */
                    main.getInt("pressure"),            /* Pressure */
                    wind.getInt("deg"),                 /* Wind Degree */
                    wind.getInt("speed")                /* Wind Speed */
            );
            
            weatherList[i] = tempWeat;
        }

        return weatherList;
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
