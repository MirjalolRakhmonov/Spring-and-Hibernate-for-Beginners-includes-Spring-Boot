package com.mirjalolcode.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mirjalolcode.hibernate.demo.entity.Employee;

public class QueryEmployeeDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<Employee> thEmployees=session.createQuery("from Employee").getResultList();
			
			displayEmployees(thEmployees);
			
			thEmployees=session.createQuery("from Employee e where e.lastName='Hunter'").getResultList();
			displayEmployees(thEmployees);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayEmployees(List<Employee> thEmployees) {
		for(Employee tempEmployee : thEmployees) {
			System.out.println(tempEmployee);
		}
	}

}
