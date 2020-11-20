package com.mirjalolcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mirjalolcode.hibernate.demo.entity.Employee;

public class PrimaryKey {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		// create a session
		Session session=factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			
			// create 3 employees object
			System.out.println("Creating 3 employees object...");
			Employee tempEmployee=new Employee("Ilyos", "Rojiboyev", "Uzbekistan Railways");
			Employee tempEmployee2=new Employee("Aziz", "Alijonov", "KapitalBank");
			Employee tempEmployee3=new Employee("John", "Doe", "Bloomberg");
			
			// start a transaction
			session.beginTransaction();
			 
			// save the employee object
			System.out.println("Saving the Employee...");
			session.save(tempEmployee);
			session.save(tempEmployee2);
			session.save(tempEmployee3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
