package model;

import java.util.*;

public class StatisticsDisplay implements Observer, DisplayItem {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;
	private WeatherData weatherData;
	private String text;

	public StatisticsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
		tempSum += temp;
		numReadings++;

		if (temp > maxTemp) {
			maxTemp = temp;
		}
 
		if (temp < minTemp) {
			minTemp = temp;
		}

		display();
	}

	public void display() {
		text = "<html>Statistics: <br>Avg/Max/Min temperature = <br>" + (tempSum / numReadings)
			+ "<br>" + maxTemp + "<br>" + minTemp + "</html>";
	}
	
	public String getText() {
		return text;
	}
}
