package service;

import android.os.AsyncTask;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Parser.NewWeatherParser;
import data.CurrentConditions;
import Parser.WeatherParser;
import data.WeatherResponseData;

/**
 * Created by Siddhartha on 9/22/2015.
 * This will have a Async task to get the json
 */
public class WorldWeatherService {

    private static String BASE_URL ="http://api.worldweatheronline.com/free/v2/weather.ashx?q=";
    private static String BASE_URL_FIX= "&format=json&num_of_days=5&date=today&key=";
    private static String KEY= "4164042ddb97040dda681048fab59";
    private String Query;
    private Exception exception;

    private WetherServiceCallback callBack;


    public WorldWeatherService(String query,WetherServiceCallback callback){
        this.callBack = callback;
        Query = query;

    }
    public String getQuery() {
        return Query;
    }
    public void getWeather(){

        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {
                String response = RestfullCall();
                return response;
            }

            @Override
            protected void onPostExecute(String result) {
                if (result == null ) {
                    callBack.serviceFailure(new Exception("No result found"));
                    return;
                }
                else {
                    try {
                        WeatherResponseData w = NewWeatherParser.parseJSONResponse(result);
                        if(w != null){
                            callBack.serviceSuccess(w);
                            return;
                        }
                        else
                            callBack.serviceFailure(new Exception("Error finding the location"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.execute(Query);
    }

    private String RestfullCall() {

        HttpURLConnection connection =null;
        InputStream inputStream = null;
        URL url = null;
        try {
            url = new URL(""+BASE_URL+Query+BASE_URL_FIX+KEY);
            connection = (HttpURLConnection)(url.openConnection());

            StringBuffer buffer = new StringBuffer();
            inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                buffer.append(line+"\r\n");
            }

            return buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            if(inputStream !=null){
                try {
                    inputStream.close();
                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

        }
    }


}
