package com.qsp.restaurant_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
   @Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menuid;
	private String menucategory;
	private String menuofitems;
	   @OneToMany(cascade = CascadeType.ALL)
	private List<Food> food;
	
	public List<Food> getFood() {
		return food;
	}
	public void setFood(List<Food> food) {
		this.food = food;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getMenucategory() {
		return menucategory;
	}
	public void setMenucategory(String menucategory) {
		this.menucategory = menucategory;
	}
	public String getMenuofitems() {
		return menuofitems;
	}
	public void setMenuofitems(String menuofitems) {
		this.menuofitems = menuofitems;
	}
	
	
	
}
