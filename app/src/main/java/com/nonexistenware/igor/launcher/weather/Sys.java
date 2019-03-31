package com.nonexistenware.igor.launcher.weather;

public class Sys {
    private int type;
    private int id;
    private String country;
    private double sunset;
    private double sunrise;

    public Sys(int type, int id, String country, double sunset, double sunrise) {
        this.type = type;
        this.id = id;
        this.country = country;
        this.sunset = sunset;
        this.sunrise = sunrise;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSunset() {
        return sunset;
    }

    public void setSunset(double sunset) {
        this.sunset = sunset;
    }

    public double getSunrise() {
        return sunrise;
    }

    public void setSunrise(double sunrise) {
        this.sunrise = sunrise;
    }
}
