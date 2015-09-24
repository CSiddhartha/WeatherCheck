package data;

import java.util.List;

/**
 * Created by Siddhartha on 9/23/2015.
 */
public class WeatherForcast  {

    /**
     * Local forecast date, formatted as 'yyyy-MM-dd'. e.g.:- 2008-05-31
     */
    private String date;

    /**
     * Maximum temperature of the day in degree Celsius
     */
    private int tempMaxC;

    /**
     * Maximum temperature of the day in degree Fahrenheit
     */
    private int tempMaxF;

    /**
     * Minimum temperature of the day in degree Celsius
     */
    private int tempMinC;

    /**
     * Minimum temperature of the day in degree Fahrenheit
     */
    private int tempMinF;

    /**
     * Weather icon url
     */
    private List<BasicValueResponse> weatherIconUrl;

    /**
     * Weather description text
     */
    private List<BasicValueResponse> weatherDesc;

    /**
     * Precipitation amount in millimetre
     */
    private double precipMm;

    public double getPrecipMm() {
        return precipMm;
    }

    public void setPrecipMm(double precipMm) {
        this.precipMm = precipMm;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTempMaxC() {
        return tempMaxC;
    }

    public void setTempMaxC(int tempMaxC) {
        this.tempMaxC = tempMaxC;
    }

    public int getTempMaxF() {
        return tempMaxF;
    }

    public void setTempMaxF(int tempMaxF) {
        this.tempMaxF = tempMaxF;
    }

    public int getTempMinC() {
        return tempMinC;
    }

    public void setTempMinC(int tempMinC) {
        this.tempMinC = tempMinC;
    }

    public int getTempMinF() {
        return tempMinF;
    }

    public void setTempMinF(int tempMinF) {
        this.tempMinF = tempMinF;
    }

    public List<BasicValueResponse> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(List<BasicValueResponse> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public List<BasicValueResponse> getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(List<BasicValueResponse> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }



}
