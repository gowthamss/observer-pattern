package org.gowtham.observers;

import org.gowtham.WeatherData;
import org.gowtham.interfaces.*;

public class CurrentConditionsDisplay implements Observer, DisplayElement
{
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData wd)
    {
        this.weatherData = wd;
        this.weatherData.registerObserver(this);
    }

    @Override public void update()
    {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }

    @Override public void display()
    {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
