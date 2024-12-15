package org.gowtham;

import org.gowtham.observers.*;

public class Main
{
    public static void main(String[] args)
    {
        WeatherData weatherData = new WeatherData();

        /*
            Initializing with weatherData object to register.
         */
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        /*
            This setting of measurements is actually comes from the Weather Station API
         */
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}