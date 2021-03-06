package com.mirjalolcode.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.mirjalolcode.aopdemo.dao.AccountDAO;
import spring.mirjalolcode.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO=context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO=
				context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account myAccount=new Account();
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();
		
		theMembershipDAO.addSomeMember();
		theMembershipDAO.codingTime();
				
		// close the context
		context.close();
	}

}










