package com.mirjalolcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mirjalolcode.hibernate.demo.entity.Course;
import com.mirjalolcode.hibernate.demo.entity.Instructor;
import com.mirjalolcode.hibernate.demo.entity.InstructorDetail;
import com.mirjalolcode.hibernate.demo.entity.Review;
import com.mirjalolcode.hibernate.demo.entity.Student;

public class AddCoursesForUserDemo {

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
			
			// get the user from Database
			int studentId=2;
			Student tempStudent=session.get(Student.class, studentId);
			System.out.println("\nLoaded student: "+tempStudent);
			System.out.println("Courses: "+tempStudent.getCourses());
			
			// create more courses
			Course tempCourse=new Course("Rubik's Cube - How to Speed Cube");
			Course temCourse2=new Course("Ultimate Git Course - How make professional profile");
			
			// add student to courses
			tempCourse.addStudent(tempStudent);
			temCourse2.addStudent(tempStudent);
			
			// save the courses
			System.out.println("\nSaving the courses ...");
			session.save(tempCourse);
			session.save(temCourse2);
			
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
