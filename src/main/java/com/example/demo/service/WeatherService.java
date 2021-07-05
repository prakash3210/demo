package com.example.demo.service;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domainobjects.OpenWeatherMap;

@Service
public class WeatherService implements IWeather{
	
	private static String WEATHER_URL = "";

	@Override
	public OpenWeatherMap getWeather(String city) {
		
		WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=022592b3adee8905633e8fb604e8f107";
		System.out.println("Hello Weather Service!!");
		System.out.println(WEATHER_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		OpenWeatherMap response = restTemplate.getForObject(WEATHER_URL,
				OpenWeatherMap.class);
		System.out.println(response.toString());
		
		return response;
	}

}
