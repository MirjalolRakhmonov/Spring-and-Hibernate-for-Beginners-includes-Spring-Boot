package com.mirjalolcode.springdemo;

import org.springframework.stereotype.Component;

@Component
public class WrestlingCoach implements Coach {
	private FortuneService fortuneService;
	

	public WrestlingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your double leg takedown.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
