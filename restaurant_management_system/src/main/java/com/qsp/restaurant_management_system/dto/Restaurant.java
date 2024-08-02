package com.qsp.restaurant_management_system.dto;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantId;
	private String restaurantName;
	private String restaurantMail;
	private long restaurantPhone;
	private String restaurantGST;
	@OneToMany( cascade = CascadeType.ALL)
	List<Branch>branchs;
	
	public List<Branch> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantMail() {
		return restaurantMail;
	}
	public void setRestaurantMail(String restaurantMail) {
		this.restaurantMail = restaurantMail;
	}
	public long getRestaurantPhone() {
		return restaurantPhone;
	}
	public void setRestaurantPhone(long restaurantPhone) {
		this.restaurantPhone = restaurantPhone;
	}
	public String getRestaurantGST() {
		return restaurantGST;
	}
	public void setRestaurantGST(String restaurantGST) {
		this.restaurantGST = restaurantGST;
	}
	
	
}
