package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Controller;

public class WeatherPanel extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel current;
	private JLabel stat;
	private JLabel forecast;
	private JButton change;
	private Controller controller;
	
	public WeatherPanel(){
		
		controller = new Controller();
		current = new JLabel("Current");
		stat = new JLabel("Stats");
		forecast = new JLabel("Forecast");
		change = new JButton("Refresh");
		
		
		
		change.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.notifyObservers();
				current.setText(controller.getCurrentText());
				stat.setText(controller.getStatText());
				forecast.setText(controller.getForecastText());
			}
			
		});
		
		setLayout(new BorderLayout());
		
		add(current, BorderLayout.SOUTH);
		add(stat,BorderLayout.CENTER);
		add(forecast, BorderLayout.NORTH);
		add(change, BorderLayout.EAST);
		
		
		
		setSize(new Dimension(400,400));
		setResizable(false);
		setVisible(true);
	}

}
