package students;

import java.util.Random;

public class Weather {

	public String[] weather = {"Sunny", "Rainy", "Cloudy", "Stormy"};
	
	String generateWeather() {
        Random rand = new Random();
        int index = rand.nextInt(weather.length);
        return weather[index];
    }


}