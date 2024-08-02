package com.qsp.restaurant_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeId;
	private String employeeName;
	private double employeeSalaryl;
	private String employeeRole;
	private long employeePhone;
	private int employeeYOE;
	
	
	public int getEmployeId() {
		return employeId;
	}
	public void setEmployeId(int employeId) {
		this.employeId = employeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getEmployeeSalaryl() {
		return employeeSalaryl;
	}
	public void setEmployeeSalaryl(double employeeSalaryl) {
		this.employeeSalaryl = employeeSalaryl;
	}
	public String getEmployeeRole() {
		return employeeRole;
	}
	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}
	public long getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(long employeePhone) {
		this.employeePhone = employeePhone;
	}
	public int getEmployeeYOE() {
		return employeeYOE;
	}
	public void setEmployeeYOE(int employeeYOE) {
		this.employeeYOE = employeeYOE;
	}
	
	
}
