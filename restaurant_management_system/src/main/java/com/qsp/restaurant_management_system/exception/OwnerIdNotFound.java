package com.qsp.restaurant_management_system.exception;

public class OwnerIdNotFound  extends RuntimeException{
    
	private String message ="OWNER ID NOT FOUND IN DB";
	public String getMessage() {
		return message;
	}
	
}
