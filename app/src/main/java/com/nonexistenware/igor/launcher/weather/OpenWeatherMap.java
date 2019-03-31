package com.nonexistenware.igor.launcher.weather;

import java.util.List;

public class OpenWeatherMap {
    private Coord coord;
    private List<Main> weather;
    private Main main;
    private String base;
    private int dt;
    private Sys sys;
    private int id;
    private String name;
    private int cod;
    private double temp;

    public OpenWeatherMap() {
    }

    public OpenWeatherMap(Coord coord, List<Main> weather, Main main, String base, int dt, Sys sys, int id, String name, int cod, double temp) {
        this.coord = coord;
        this.weather = weather;
        this.main = main;
        this.base = base;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
        this.temp = temp;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Main> getWeather() {
        return weather;
    }

    public void setWeather(List<Main> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}

