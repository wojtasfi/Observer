package controller;

import model.CurrentWeather;
import model.ForecastDisplay;
import model.StatisticsDisplay;
import model.WeatherData;

public class Controller {
	
	private  WeatherData weatherData;
	private CurrentWeather o; 
	private ForecastDisplay forecast;
	private StatisticsDisplay stats;
	
	public Controller(){
		weatherData  = new WeatherData();
		o = new CurrentWeather(weatherData);
		forecast = new ForecastDisplay(weatherData);
		stats = new StatisticsDisplay(weatherData);
	}
	

	public void notifyObservers() {
		
		float temp = (float) Math.random();
		float hum = (float) Math.random();
		float press = (float) Math.random();
		
		weatherData.setData(temp, hum, press);
		weatherData.changeOfData();
		
	}
	
	public String getCurrentText(){
		return o.getText();
	}
	
	public String getStatText(){
		return stats.getText();
	}
	
	public String getForecastText(){
		return forecast.getText();
	}
	

}
