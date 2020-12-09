package com.mirjalolcode.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.mirjalolcode.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO=context.getBean("accountDAO", AccountDAO.class);
		
		// call the method to find the accounts
		List<Account>theAccounts=null;
		
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWare=false;
		    theAccounts=theAccountDAO.findAccounts(tripWare);
		}
		catch (Exception exc) {
			System.out.println("\n\nMain Program...caught exception: "+exc);
		}
		
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("----");
		
		System.out.println(theAccounts);
		System.out.println("\n");
		
		// close the context
		context.close();
	}
}










