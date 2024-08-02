package com.qsp.restaurant_management_system.util;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class ResponseStructure1 <T> {
	private int statusCode;
	private String message;
	private List<T> data;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	
}
