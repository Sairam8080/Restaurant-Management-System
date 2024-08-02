package com.qsp.restaurant_management_system.exception;

public class ManagerNotFound extends RuntimeException{
	private String message ="MANAGER ID NOT FOUND IN DB";
	public String getMessage() {
		return message;
	}
}
