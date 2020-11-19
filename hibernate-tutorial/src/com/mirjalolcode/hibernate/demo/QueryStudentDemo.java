package com.mirjalolcode.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mirjalolcode.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session=factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents=session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query students: last name='Rakhmonov'
			theStudents=session.createQuery("from Student s where s.lastName='Hunter'").getResultList();
			displayStudents(theStudents);
			
			// display the students
			System.out.println("\n\nStudents have last name of Hunter");
			displayStudents(theStudents);
			
			theStudents=session.createQuery("from Student s where s.lastName='Hunter' OR s.firstName='Ilyos'").getResultList();
			System.out.println("\n\nStudents have last name of Hunter OR firstName Ilyos");
			displayStudents(theStudents);
			
			// query students where email LIKE '%yahoo.com'
			theStudents=session.createQuery("from Student where email LIKE '%yahoo.com'").getResultList();
			System.out.println("\n\nStudents whose email ends with yahoo.com");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student temStudent: theStudents) {
			System.out.println(temStudent);
		}
	}

}
