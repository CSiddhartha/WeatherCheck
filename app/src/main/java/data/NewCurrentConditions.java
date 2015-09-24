package data;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by Siddhartha on 9/23/2015.
 */
public class NewCurrentConditions {
    /**
     * Temperature in degree Celsius
     */
     private int tempC;

    public int getTempF() {
        return tempF;
    }

    public void setTempF(int tempF) {
        this.tempF = tempF;
    }

    /**
     * Temperature in degree Celsius
     */
    private int tempF;


    /**
     * Wind speed in miles per hour
     */
    private int windSpeedMiles;

    /**
     * Wind speed in kilometre per hour
     */
    private int windSpeedKmph;

    /**
     * Wind direction in degree
     */
    private int windDirDegree;

    /**
     * Wind direction in 16-point compass
     */
    private String windDir16Point;

    /**
     * Weather condition code
     */
    private int weatherCode;

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    /**
     * Weather Icon
     */
    private Bitmap icon;

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public String getWeatherIconUrl() {
        return weatherIconUrl;
    }

    /**
     * Weather description text
     */
    private String weatherDesc;

    public void setWeatherIconUrl(String weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    /**
     * Weather icon url
     */
    private String weatherIconUrl;

    /**
     * Precipitation in millimetre
     */
    private double precipMm;

    public double getPrecipMm() {
        return precipMm;
    }

    public void setPrecipMm(double precipMm) {
        this.precipMm = precipMm;
    }

    public int getTempC() {
        return tempC;
    }

    public void setTempC(int tempC) {
        this.tempC = tempC;
    }

    public int getWindSpeedMiles() {
        return windSpeedMiles;
    }

    public void setWindSpeedMiles(int windSpeedMiles) {
        this.windSpeedMiles = windSpeedMiles;
    }

    public int getWindSpeedKmph() {
        return windSpeedKmph;
    }

    public void setWindSpeedKmph(int windSpeedKmph) {
        this.windSpeedKmph = windSpeedKmph;
    }

    public int getWindDirDegree() {
        return windDirDegree;
    }

    public void setWindDirDegree(int windDirDegree) {
        this.windDirDegree = windDirDegree;
    }

    public String getWindDir16Point() {
        return windDir16Point;
    }

    public void setWindDir16Point(String windDir16Point) {
        this.windDir16Point = windDir16Point;
    }

    public int getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(int weatherCode) {
        this.weatherCode = weatherCode;
    }





}
