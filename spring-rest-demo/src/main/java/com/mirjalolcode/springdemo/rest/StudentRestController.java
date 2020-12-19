package com.mirjalolcode.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirjalolcode.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	
	// define @PostConstruct to load the student data... only once!
	@PostConstruct
	public void loadData() {
        
		theStudents=new ArrayList<>();
		
		theStudents.add(new Student("John", "Smith"));
		theStudents.add(new Student("Mirjalol", "Rakhmonov"));
		theStudents.add(new Student("Mario", "Rossi"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		
		return theStudents;
	}
}
