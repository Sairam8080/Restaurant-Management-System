package com.qsp.restaurant_management_system.exception;

public class FoodOrderNotFound extends RuntimeException{
	private String message ="FOODORDER ID NOT FOUND IN DB";
	public String getMessage() {
		return message;
	}
}
