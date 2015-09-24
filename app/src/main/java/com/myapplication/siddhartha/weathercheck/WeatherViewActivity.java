package com.myapplication.siddhartha.weathercheck;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

import data.CurrentConditions;
import data.NewCurrentConditions;
import data.WeatherResponseData;
import service.WetherServiceCallback;
import service.WorldWeatherService;

public class WeatherViewActivity extends AppCompatActivity implements WetherServiceCallback {

    ProgressBar pb;
    String query;
    private ImageView weatherIconImageView;
    private TextView currentweatherTextView;
    private TextView descriptionTextView;
    private TextView prespicationTextView;
    private NewCurrentConditions currentWeather;
    private boolean inCecilius = false;

    private WorldWeatherService service ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            Bundle extra = getIntent().getExtras();
            if (extra == null) {
                query = "";
            }
            else {
                query = extra.getString("Query");
            }
        setContentView(R.layout.activity_weather);
        pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setVisibility(View.VISIBLE);
        weatherIconImageView = (ImageView) findViewById(R.id.imageView);
        currentweatherTextView = (TextView) findViewById(R.id.currentTemp);
        descriptionTextView = (TextView) findViewById(R.id.discriptionTextView);
        prespicationTextView = (TextView) findViewById(R.id.prespicationTextView3);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        service = new WorldWeatherService(query,this);
        service.getWeather();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

          if (item.getItemId() == R.id.celicus) {
              inCecilius =true;
              updateCurrentEmperature();

            }
           else if(item.getItemId() == R.id.faran){
              inCecilius =false;
              updateCurrentEmperature();
            }
            else if(item.getItemId() == android.R.id.home){
              this.finish();
              return true;

          }
        return true;
    }



    @Override
    public void serviceSuccess(WeatherResponseData weather) {
        pb.setVisibility(View.INVISIBLE);
        currentWeather = weather.getCurrentCondition();
        updateCurrentEmperature();
        descriptionTextView.setText(currentWeather.getWeatherDesc());
        prespicationTextView.setText(currentWeather.getPrecipMm() + "mm");
        addIcon();

    }

    private void addIcon() {
        if(currentWeather.getIcon() != null){
            ImageView image = (ImageView) this.findViewById(R.id.imageView);
            image.setImageBitmap(currentWeather.getIcon());
        }
        else
        {
            WeatherIconView container = new WeatherIconView();
            container.currentConditions = currentWeather;
            ImageLoader loader = new ImageLoader();
            loader.execute(container);
        }
    }

    private void updateCurrentEmperature() {

        if(inCecilius == true)
            currentweatherTextView.setText(currentWeather.getTempC()+"°C");
        else
            currentweatherTextView.setText(currentWeather.getTempF()+"°F");
    }

    @Override
    public void serviceFailure(Exception exception) {
        pb.setVisibility(View.INVISIBLE);

    }

    class WeatherIconView {
        public NewCurrentConditions currentConditions;
        public View view;
        public Bitmap bitmap;
    }

    /**
     * To have better performance using AsyncTask to load Images
     */


    private class ImageLoader extends AsyncTask<WeatherIconView, Void, WeatherIconView> {

        @Override
        protected WeatherIconView doInBackground(WeatherIconView... params) {

            WeatherIconView container = params[0];
            NewCurrentConditions currentConditions = container.currentConditions;

            try {
                String imageUrl = currentConditions.getWeatherIconUrl();
                InputStream in = (InputStream) new URL(imageUrl).getContent();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                currentConditions.setIcon(bitmap);
                in.close();
                container.bitmap = bitmap;
                return container;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        @Override
        protected void onPostExecute(WeatherIconView result) {
            if(result != null) {
                ImageView image = (ImageView)findViewById(R.id.imageView);
                image.setImageBitmap(result.bitmap);
                result.currentConditions.setIcon(result.bitmap);
            }
        }

    }
}
