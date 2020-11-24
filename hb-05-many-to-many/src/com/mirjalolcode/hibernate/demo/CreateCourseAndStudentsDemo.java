package com.mirjalolcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mirjalolcode.hibernate.demo.entity.Course;
import com.mirjalolcode.hibernate.demo.entity.Instructor;
import com.mirjalolcode.hibernate.demo.entity.InstructorDetail;
import com.mirjalolcode.hibernate.demo.entity.Review;
import com.mirjalolcode.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session=factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse=new Course("Selenium Tesing");
			//Course tempCourse2=new Course("Unit Testing");
			
			// save the course
			System.out.println("\nSaving the course ...");
			session.save(tempCourse);
			System.out.println("Saved the course: "+tempCourse);
			
			// create the students
			Student temStudent=new Student("Mirjalol", "Rakhmonov", "mirjalolrakhmonov@yahoo.com");
			Student temStudent2=new Student("Alisher", "Sadiev", "sadiev@yahoo.com");
			
			// add students to the course
			tempCourse.addStudent(temStudent);
			tempCourse.addStudent(temStudent2);
			
			// save the students
			System.out.println("\nSaving students ...");
			session.save(temStudent);
			session.save(temStudent2);
			System.out.println("Saved students: "+tempCourse.getStudents());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
