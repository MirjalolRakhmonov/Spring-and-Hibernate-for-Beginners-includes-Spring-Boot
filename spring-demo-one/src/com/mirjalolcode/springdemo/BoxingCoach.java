package com.mirjalolcode.springdemo;

public class BoxingCoach implements Coach {
	private FortuneService fortuneService;
	
	

	public BoxingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Do push-ups 5 times a day";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
