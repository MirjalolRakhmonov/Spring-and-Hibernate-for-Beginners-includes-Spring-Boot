package com.mirjalolcode.springboot.demo.devtoolsdemo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// expose "/" that returns "Hello World!"
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is "+LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String doWorkout() {
		return "Run 5km in the morning";
	}
}
