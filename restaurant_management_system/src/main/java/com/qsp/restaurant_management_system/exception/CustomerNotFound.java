package com.qsp.restaurant_management_system.exception;

public class CustomerNotFound extends RuntimeException {
	private String message ="CUSTOMER ID NOT FOUND IN DB";
	public String getMessage() {
		return message;
	}
}
