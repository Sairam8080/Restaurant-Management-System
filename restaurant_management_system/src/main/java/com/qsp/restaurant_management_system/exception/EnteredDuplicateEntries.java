package com.qsp.restaurant_management_system.exception;

public class EnteredDuplicateEntries extends RuntimeException {
   private String message ="ALREADY ID'S LINKED ";

public String getMessage() {
	return message;
}
   

}
