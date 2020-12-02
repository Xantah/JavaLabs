package src.by.gsu.pms;

import java.io.*;

public class WeatherData {
    private String cityName;
    private String cityId;
    private String iconId;
    private String currentWeather;
    private String briefDescription;
    private String fullDescription;
    private String currentDegree;
    private String pressure;
    private String humidity;
    private String minTempToday;
    private String maxTempToday;
    private String windSpeed;
    private String windDeg;
    private String clouds;

    public WeatherData(String cityName, String cityId, String iconId,
                String currentWeather, String briefDescription,
                String fullDescription, String currentDegree,
                       String pressure, String humidity, String minTempToday,
                       String maxTempToday, String windSpeed, String windDeg,
                       String clouds) {
        this.cityName = cityName;
        this.cityId = cityId;
        this.iconId = iconId;
        this.currentWeather = currentWeather;
        this.briefDescription = briefDescription;
        this.fullDescription = fullDescription;
        this.currentDegree = currentDegree;
        this.pressure = pressure;
        this.humidity = humidity;
        this.minTempToday = minTempToday;
        this.maxTempToday = maxTempToday;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
        this.clouds = clouds;
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(String currentWeather) {
        this.currentWeather = currentWeather;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getCurrentDegree() {
        return currentDegree;
    }

    public void setCurrentDegree(String currentDegree) {
        this.currentDegree = currentDegree;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getMinTempToday() {
        return minTempToday;
    }

    public void setMinTempToday(String minTempToday) {
        this.minTempToday = minTempToday;
    }

    public String getMaxTempToday() {
        return maxTempToday;
    }

    public void setMaxTempToday(String maxTempToday) {
        this.maxTempToday = maxTempToday;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(String windDeg) {
        this.windDeg = windDeg;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    @Override
    public String toString(){
        return "---\nНазвание города: " + cityName + "\nКод: " + cityId + "\nИзображение: " + iconId + "\nКраткое описание: " +
                briefDescription + "\nРасширенное описание: " + fullDescription + "\nТекущая температура: " + currentDegree +
                "\nДавление: " + pressure + "\nВлажность: " + humidity + "\nМинимальная температура: " + minTempToday +
                "\nМаксимальная температура: " + maxTempToday + "\nСкорость ветра: " + windSpeed + "\nНаправление ветра" +
                windDeg + "\nОблачность: " + clouds;
    }

  }
