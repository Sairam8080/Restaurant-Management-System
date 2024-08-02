
package com.qsp.restaurant_management_system.exception;

public class AddressNotFound extends RuntimeException {
	private String message ="ADDRESS ID NOT FOUND IN DB";
	public String getMessage() {
		return message;
	}
}
