package com.mirjalolcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mirjalolcode.hibernate.demo.entity.Employee;

public class UpdateEmployeeDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			int employeeId=2;
			System.out.println("Saved employee. Generated id: "+employeeId);
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting employee with id: "+employeeId);
			Employee myEmployee=session.get(Employee.class, employeeId);
			
			System.out.println("Updating Employee...");
			myEmployee.setFirstName("Asilbek");
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
