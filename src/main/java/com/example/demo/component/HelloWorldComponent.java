package com.example.demo.component;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldComponent {

	@PostConstruct
	public void sayHello() {
		
		System.out.println("*********** HELLO WORLD!! ****************");
		
	}
}
