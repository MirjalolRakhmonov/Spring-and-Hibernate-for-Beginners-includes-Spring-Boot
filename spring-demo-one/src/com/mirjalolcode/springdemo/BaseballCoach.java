package com.mirjalolcode.springdemo;

public class BaseballCoach implements Coach {
	// define a private field for the dependency
	private FortuneService fortuneService;
	
	// define ctor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 mins on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}
}
