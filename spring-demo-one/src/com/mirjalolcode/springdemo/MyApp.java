package com.mirjalolcode.springdemo;

public class MyApp {

	public static void main(String[] args) {
		// create the object
		Coach theCoach=new BaseballCoach();

		// use the object
		System.out.println(theCoach.getDailyWorkout());
	}
}
