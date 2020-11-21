package com.mirjalolcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mirjalolcode.hibernate.demo.entity.Instructor;
import com.mirjalolcode.hibernate.demo.entity.InstructorDetail;
import com.mirjalolcode.hibernate.demo.entity.Student;

public class DeleteDemo {

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
			// start transaction
			session.beginTransaction();
			
			// get instructor by primary key / id
			int theId=2;
			Instructor tempInstructor=session.get(Instructor.class, theId);
			
			System.out.println("Found Instructor: "+tempInstructor);
			// delete the instructors
			if(tempInstructor!=null) {
				System.out.println("Deleting: "+tempInstructor);
				
				session.delete(tempInstructor);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
