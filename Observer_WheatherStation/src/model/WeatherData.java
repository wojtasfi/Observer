package model;
import java.util.ArrayList;

public class WeatherData implements Subject {

	private float temperature;
	private float humidity;
	private float preassure;

	private ArrayList<Observer> observers;
	

	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void deleteObserver(Observer o) {
		observers.remove(observers.indexOf(o));

	}

	@Override
	public void notifyObservers() {

		for (Observer observer : observers) {
			observer.update(temperature, humidity, preassure);
		}

	}

	public void changeOfData() {
		notifyObservers();
	}

	public void setData(float temperature, float humidity, float preassure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.preassure = preassure;

	}

	public float getTemperature() {
		// TODO Auto-generated method stub
		return temperature;
	}
	
	

}
