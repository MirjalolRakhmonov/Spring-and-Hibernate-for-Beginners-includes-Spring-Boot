package com.mirjalolcode.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
         AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportConfig.class);
		  
		Coach theCoach =context.getBean("swimCoach", Coach.class);
		  
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		context.close();
	}

}
