package com.example.sunshine_recycview_app.models;

import java.io.Serializable;

public class sunshine implements Serializable {
     private String day, weather,hightT , lowT ;
     private int img;

    public sunshine(String day, String weather, String hightT, String lowT, int img) {
        this.day = day;
        this.weather = weather;
        this.hightT = hightT;
        this.lowT = lowT;
        this.img = img;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getHightT() {
        return hightT;
    }

    public void setHightT(String hightT) {
        this.hightT = hightT;
    }

    public String getLowT() {
        return lowT;
    }

    public void setLowT(String lowT) {
        this.lowT = lowT;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
