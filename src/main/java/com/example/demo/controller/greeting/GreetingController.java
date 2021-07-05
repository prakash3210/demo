package com.example.demo.controller.greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domainobjects.Greeting;
import com.example.demo.domainobjects.OpenWeatherMap;
import com.example.demo.service.IWeather;

@RestController
public class GreetingController {

	@Autowired
	private IWeather weatherService;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	

	@GetMapping("/greeting/get")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping("/greeting/post")
	public Greeting postgreeting(@RequestParam(value = "firstname", defaultValue = "World") String firstname,
			@RequestParam(value = "lastname", defaultValue = "Universe") String lastname) {
		return new Greeting(counter.incrementAndGet(), String.format(template, firstname + " " + lastname));
	}
	
	@GetMapping("/weather")
	public OpenWeatherMap getCurrentWeather(@RequestParam(value = "city", defaultValue = "Marietta,GA,USA") String city) {
		System.out.println("*** In Weather *** " + city);
		OpenWeatherMap response = weatherService.getWeather(city);
		return response;
	}

}