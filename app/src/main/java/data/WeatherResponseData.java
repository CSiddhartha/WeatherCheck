package data;

import java.util.List;

/**
 * Created by Siddhartha on 9/23/2015.
 */
public class WeatherResponseData {


    /**
     * * Contains the current weather condition forecast related information.
     */
    private NewCurrentConditions currentCondition;
    /**
     * Contains the weather forecast related information
     */

    private List<WeatherResponseData> weatherList;

    public List<WeatherResponseData> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<WeatherResponseData> weatherList) {
        this.weatherList = weatherList;
    }
    public NewCurrentConditions getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(NewCurrentConditions currentConditionList) {
        this.currentCondition = currentConditionList;
    }



}
