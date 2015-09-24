package Parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import data.CurrentConditions;
import data.NewCurrentConditions;
import data.WeatherResponseData;

/**
 * Created by Siddhartha on 9/23/2015.
 */
public class NewWeatherParser {

    public static WeatherResponseData parseJSONResponse(String data) throws JSONException {

        WeatherResponseData weatherResponseData = new WeatherResponseData();
        NewCurrentConditions currentConditions = new NewCurrentConditions();

        JSONObject jsonMsinObject = new JSONObject(data);
        JSONObject dataObject = jsonMsinObject.getJSONObject("data");
        JSONArray currentArray = dataObject.getJSONArray("current_condition");
        JSONObject currentObject = currentArray.getJSONObject(0);
        currentConditions.setTempF(currentObject.optInt("temp_F", -99));
        currentConditions.setTempC(currentObject.optInt("temp_C", -99));
        JSONArray jArr = currentObject.getJSONArray("weatherDesc");
        JSONObject JSONWeatherDesc = jArr.getJSONObject(0);
        currentConditions.setWeatherDesc(JSONWeatherDesc.optString("value", "N/A"));
        JSONArray jArrIcon = currentObject.getJSONArray("weatherIconUrl");
        JSONObject JSONIcon = jArrIcon.getJSONObject(0);
        currentConditions.setWeatherIconUrl(JSONIcon.optString("value", "N/A"));
        currentConditions.setPrecipMm(currentObject.optInt("precipMM", -99));
        weatherResponseData.setCurrentCondition(currentConditions);
        return weatherResponseData;
    }

    private static String getString(String tagName, JSONObject jObj)
            throws JSONException {
        return jObj.getString(tagName);
    }
}
