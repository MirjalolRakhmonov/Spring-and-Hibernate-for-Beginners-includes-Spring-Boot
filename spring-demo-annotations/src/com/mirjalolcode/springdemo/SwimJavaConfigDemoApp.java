package com.mirjalolcode.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
         AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportConfig.class);
		  
		SwimCoach theCoach =context.getBean("swimCoach", SwimCoach.class);
		  
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("email: "+theCoach.getEmail());
		System.out.println("team: "+theCoach.getTeam());
		
		context.close();
	}

}
