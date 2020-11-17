package com.mirjalolcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mirjalolcode.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory=new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				// create a session
				Session session=factory.getCurrentSession();
				
				try {
					// use the session object to save Java object
					
					// create 3 students object
					System.out.println("Creating 3 students object...");
					Student tempStudent1=new Student("Ilyos", "Rojiboyev", "ilyos@yahoo.com");
					Student tempStudent2=new Student("Aziz", "Alijonov", "aziz@yahoo.com");
					Student tempStudent3=new Student("John", "Doe", "john@yahoo.com");
					
					// start a transaction
					session.beginTransaction();
					 
					// save the student object
					System.out.println("Saving the Student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
	}

}
