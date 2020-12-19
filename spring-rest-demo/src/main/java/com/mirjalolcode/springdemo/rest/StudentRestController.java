package com.mirjalolcode.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// define endpoint for "/students/{studentId}" - return student at index	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		// just index into the list 
		
		// check the studentId against list size
		if (studentId>=theStudents.size() || studentId<0) {
			throw new StudentNotFoundExeption("Student Id not found - "+studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	// add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundExeption exc){
		
		// create a StudentErrorResponce
		StudentErrorResponse error=new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity	
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}
