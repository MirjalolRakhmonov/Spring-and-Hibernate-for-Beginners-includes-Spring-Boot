package com.mirjalolcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mirjalolcode.hibernate.demo.entity.Course;
import com.mirjalolcode.hibernate.demo.entity.Instructor;
import com.mirjalolcode.hibernate.demo.entity.InstructorDetail;
import com.mirjalolcode.hibernate.demo.entity.Student;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create a session
		Session session=factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// option Hibernate query with HQL
			Query<Instructor>query=
					session.createQuery("select i from Instructor i "
							+"JOIN FETCH i.courses "
							+"WHERE i.id=:theInstructorId",Instructor.class);
			
			// get the instructor from database
			int theId=1;
			
			// set parameter
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			Instructor tempInstructor=query.getSingleResult();
			
			System.out.println("Instructor: "+tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			// since courses are lazy loaded ... this should fail
			
			// get course for the instructor
			System.out.println("Courses: "+tempInstructor.getCourses());
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
