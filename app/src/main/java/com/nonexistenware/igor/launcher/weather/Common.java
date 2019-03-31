package com.nonexistenware.igor.launcher.weather;

public class Common {
    public static String API_KEY = "c0c343f995092108a3e62828cb1105fe";
    public static String API_LINK = "https://api.openweathermap.org/data/2.5/weather";

    public static String apiRequest(String lat, String lng) {
        StringBuffer sb = new StringBuffer(API_LINK);
        sb.append(String.format("?lat=%s&lon=%s&APPID=%s&units=metric", lat, lng, API_KEY));
        return sb.toString();
    }
}
