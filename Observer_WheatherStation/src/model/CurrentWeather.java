package model;


public class CurrentWeather implements Observer, DisplayItem{
	private float temperature;
	private float humidity;
	private float preassure;
	private String text;
	private Subject weatherData;
	
	
	public CurrentWeather(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
		
		
	}
	
	@Override
	public void display() {
		
		text = "<html>Current Weather: <br>Temperature: " + temperature + ".<br>Humidity: " + humidity + ".<br>Preassure: " + preassure +"</html>";
	}
	@Override
	public void update(float temperature, float humidity, float preassure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.preassure = preassure;
		display();
		
	}

	public String getText() {
		return text;
	}
	
	

}
