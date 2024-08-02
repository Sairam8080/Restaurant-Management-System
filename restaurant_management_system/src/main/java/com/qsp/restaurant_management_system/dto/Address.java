package com.qsp.restaurant_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	private int addressplotNumber;
	private String addressLandMark;
	private String addressStreet;
	private String addressCity;
	private String addressLandState;
	private long addressPincode;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getAddressplotNumber() {
		return addressplotNumber;
	}
	public void setAddressplotNumber(int addressplotNumber) {
		this.addressplotNumber = addressplotNumber;
	}
	public String getAddressLandMark() {
		return addressLandMark;
	}
	public void setAddressLandMark(String addressLandMark) {
		this.addressLandMark = addressLandMark;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressLandState() {
		return addressLandState;
	}
	public void setAddressLandState(String addressLandState) {
		this.addressLandState = addressLandState;
	}
	public long getAddressPincode() {
		return addressPincode;
	}
	public void setAddressPincode(long addressPincode) {
		this.addressPincode = addressPincode;
	}
	
	
	
	
}

