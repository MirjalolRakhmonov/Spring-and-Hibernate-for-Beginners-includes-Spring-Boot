package com.mirjalolcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mirjalolcode.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Employee object...");
			Employee tempEmployee=new Employee("Mirjalol", "Rakhmonov", "F-Secure");
			
			session.beginTransaction();
			
			System.out.println("Saving Employee...");
			session.save(tempEmployee);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
