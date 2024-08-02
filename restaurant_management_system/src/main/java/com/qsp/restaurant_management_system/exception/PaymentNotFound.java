package com.qsp.restaurant_management_system.exception;

public class PaymentNotFound extends RuntimeException{
	private String message ="PAYMENT ID NOT FOUND IN DB";
	public String getMessage() {
		return message;
	}
}
