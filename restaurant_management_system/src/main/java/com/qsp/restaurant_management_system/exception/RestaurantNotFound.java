package com.qsp.restaurant_management_system.exception;

public class RestaurantNotFound extends RuntimeException{
	private String message ="RESTAURANT ID NOT FOUND IN DB";
	public String getMessage() {
		return message;
	}
}
