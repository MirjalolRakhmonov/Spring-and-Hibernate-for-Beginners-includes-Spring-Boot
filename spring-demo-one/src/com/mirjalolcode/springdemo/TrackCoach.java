package com.mirjalolcode.springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		return "Just do it : " + fortuneService.getFortune();
	}
	
	// add init method
	public void startUpStaff() {
		System.out.println("TrackCoach: inside method startUpStaff");
	}
	
	// add destroy method
	public void startUpBuilder() {
		System.out.println("TrackCoach: inside method startUpBuilder");
	}
}
