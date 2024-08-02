package com.qsp.restaurant_management_system.exception;

public class MenuNotFound extends RuntimeException{
	private String message ="MANAGER ID NOT FOUND IN DB";
	public String getMessage() {
		return message;
	}
}
