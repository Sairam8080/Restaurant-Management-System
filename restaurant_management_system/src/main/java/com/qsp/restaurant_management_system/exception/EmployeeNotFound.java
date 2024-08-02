package com.qsp.restaurant_management_system.exception;

public class EmployeeNotFound extends RuntimeException{
	private String message ="EMPLOYEE ID NOT FOUND IN DB";
	public String getMessage() {
		return message;
	}
}
