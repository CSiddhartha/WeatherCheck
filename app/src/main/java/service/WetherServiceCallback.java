package service;

import data.CurrentConditions;
import data.WeatherResponseData;

/**
 * Created by Siddhartha on 9/23/2015.
 */
public interface WetherServiceCallback {

    void serviceSuccess(WeatherResponseData weather);

    void serviceFailure(Exception exception);

}
