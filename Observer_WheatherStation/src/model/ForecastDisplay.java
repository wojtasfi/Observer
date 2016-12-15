package model;

import java.util.*;

public class ForecastDisplay implements Observer, DisplayItem {
	private float currentPressure = 29.92f;
	private float lastPressure;
	private WeatherData weatherData;
	private String text;

	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
		lastPressure = currentPressure;
		currentPressure = pressure;

		display();
	}

	public void display() {
		String fore = "<html>Forecast: <br>";
		String fore2 = "";
		if (currentPressure > lastPressure) {
			fore2 = "Improving weather on the way!";
		} else if (currentPressure == lastPressure) {
			fore2 = "More of the same";
		} else if (currentPressure < lastPressure) {
			fore2 = "Watch out for cooler, rainy weather</html>";
		}

		text = fore + fore2;
	}
	
	public String getText() {
		return text;
	}
}
