package com.example.weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {
    private String mTemperature, mIcon, mCity, mWeatherType;
    private int mCondition;

    public static weatherData fromJson(JSONObject jsonObject) {
        try {
            weatherData weatherD = new weatherData();
            weatherD.mCity = jsonObject.getString("name");
            weatherD.mCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.mIcon = updateWeatherIcon(weatherD.mCondition);

            double tempResult = jsonObject.getJSONObject("main").getDouble("temp") - 273.15;
            int roundedValue = (int) Math.rint(tempResult);
            weatherD.mTemperature = Integer.toString(roundedValue);

            return weatherD;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String updateWeatherIcon(int condition) {
        // Implementation should return the appropriate icon string based on condition
        return "icon_placeholder"; // Placeholder
    }
}
