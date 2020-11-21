package com.mirjalolcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mirjalolcode.hibernate.demo.entity.Instructor;
import com.mirjalolcode.hibernate.demo.entity.InstructorDetail;
import com.mirjalolcode.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create a session
		Session session=factory.getCurrentSession();
		
		try {
			// create the objects
			System.out.println("Creating the objects...");
			
			Instructor theInstructor=new Instructor("Mirjalol", "Rakhmonov", "mirjalolrakhmonov@yahoo.com");
			InstructorDetail tempInstructorDetail=new InstructorDetail("https://www.youtube.com","How not to code");
			
			// associate the objects
			theInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			 
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
