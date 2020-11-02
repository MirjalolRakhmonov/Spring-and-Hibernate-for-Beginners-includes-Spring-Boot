package com.mirjalolcode.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeBeanScopeDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve the bean from spring container
		Coach theCoach=context.getBean("myBoxingCoach", Coach.class);
		Coach alphaCoach=context.getBean("myBoxingCoach", Coach.class);
		
		boolean result=(theCoach==alphaCoach);
		
		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMemory location for theCoach: " + theCoach);
		System.out.println("\nMemory location for alphaCoach: " + alphaCoach);
		
		context.close();
	}

}
