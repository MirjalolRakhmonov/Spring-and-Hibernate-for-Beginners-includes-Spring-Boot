package com.mirjalolcode.springdemo.rest;

public class StudentNotFoundExeption extends RuntimeException {

	public StudentNotFoundExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundExeption(String message) {
		super(message);
	}

	public StudentNotFoundExeption(Throwable cause) {
		super(cause);
	}

	
}
