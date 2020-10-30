package com.mirjalolcode.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// create the object
		//Coach theCoach=new TrackCoach();

		// use the object
		//System.out.println(theCoach.getDailyWorkout());
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext
				("applicationContext.xml");
		System.out.println("config loaded");
		//BaseballCoach theCoach=(BaseballCoach)context.getBean("myCoach");
		//theCoach.getDailyWorkout();
		Coach theCoach=context.getBean("myCoach", Coach.class);
		theCoach.getDailyWorkout();
	}
}
