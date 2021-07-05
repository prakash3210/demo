package com.example.demo.service;

import com.example.demo.domainobjects.OpenWeatherMap;

public interface IWeather {
	
	public OpenWeatherMap getWeather(String city);

}
