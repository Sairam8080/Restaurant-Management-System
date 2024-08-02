package com.qsp.restaurant_management_system.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodOrderId;
	private String foodOrderType;
	private int foodOrderQuanttity;
	private double foodOrderGST;
	private double foodOrderprice;
	@OneToOne(cascade = CascadeType.ALL)
	Payment payment;
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public int getFoodOrderId() {
		return foodOrderId;
	}
	public void setFoodOrderId(int foodOrderId) {
		this.foodOrderId = foodOrderId;
	}
	public String getFoodOrderType() {
		return foodOrderType;
	}
	public void setFoodOrderType(String foodOrderType) {
		this.foodOrderType = foodOrderType;
	}
	public int getFoodOrderQuanttity() {
		return foodOrderQuanttity;
	}
	public void setFoodOrderQuanttity(int foodOrderQuanttity) {
		this.foodOrderQuanttity = foodOrderQuanttity;
	}
	public double getFoodOrderGST() {
		return foodOrderGST;
	}
	public void setFoodOrderGST(double foodOrderGST) {
		this.foodOrderGST = foodOrderGST;
	}
	public double getFoodOrderprice() {
		return foodOrderprice;
	}
	public void setFoodOrderprice(double foodOrderprice) {
		this.foodOrderprice = foodOrderprice;
	}
   

}
