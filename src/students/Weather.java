package students;

import java.util.Random;

public class Weather {

	public String[] weather = {"Sunny", "Rainy", "Cloudy", "Stormy"};
	
	String generateWeather() {
        Random rand = new Random();
        int index = rand.nextInt(weather.length);
        return weather[index];
    }
	
	void weather_conditions() {
		
		if (generateWeather() == "Sunny") {
			
			
			
		}
	}
	


public static void main(String[] args) {
	// TODO Auto-generated method stub

	Weather weather = new Weather();
	
	System.out.println(weather.generateWeather());
	
	
	

}

}