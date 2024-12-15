package org.gowtham.observers;

import org.gowtham.WeatherData;
import org.gowtham.interfaces.*;

public class StatisticsDisplay implements Observer, DisplayElement
{
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData wd)
    {
        this.weatherData = wd;
        this.weatherData.registerObserver(this);
    }

    @Override public void update()
    {
        float temp = weatherData.getTemperature();
        this.tempSum += temp;
        numReadings++;

        if (temp > maxTemp) {
            maxTemp = temp;
        }

        if (temp < minTemp) {
            minTemp = temp;
        }

        display();
    }

    @Override public void display()
    {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
            + "/" + maxTemp + "/" + minTemp);
    }
}
