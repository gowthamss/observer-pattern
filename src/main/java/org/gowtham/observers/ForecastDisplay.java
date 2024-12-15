package org.gowtham.observers;

import org.gowtham.WeatherData;
import org.gowtham.interfaces.*;

public class ForecastDisplay implements Observer, DisplayElement
{
    private float currentPressure = 29.92f;
    private float lastPressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData wd)
    {
        this.weatherData = wd;
        weatherData.registerObserver(this);
    }

    @Override public void update()
    {
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();

        display();
    }

    @Override public void display()
    {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same.");
        } else {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}
