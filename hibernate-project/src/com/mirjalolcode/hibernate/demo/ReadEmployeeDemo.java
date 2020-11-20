package com.mirjalolcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mirjalolcode.hibernate.demo.entity.Employee;

public class ReadEmployeeDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Employee object...");
			Employee tempEmployee=new Employee("Alex", "Hunter", "YouTuber");
			
			session.beginTransaction();
			
			System.out.println("Saving Employee...");
			System.out.println(tempEmployee);
			session.save(tempEmployee);
			
			session.getTransaction().commit();
			
			System.out.println("Saved employee. Generated id: "+tempEmployee.getId());
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting employee with id: "+tempEmployee.getId());
			Employee myEmployee=session.get(Employee.class, tempEmployee.getId());
			
			System.out.println("Get complete: "+myEmployee);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
