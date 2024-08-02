package com.qsp.restaurant_management_system.exception;

public class BranchNotFound  extends RuntimeException{
	private String message ="BRANCH ID NOT FOUND IN DB";
	public String getMessage() {
		return message;
	}
}
