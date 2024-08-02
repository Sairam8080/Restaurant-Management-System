package com.qsp.restaurant_management_system.exception;

public class FoodNotFound extends RuntimeException{
	private String message ="FOOD ID NOT FOUND IN DB";
	public String getMessage() {
		return message;
	}
}
