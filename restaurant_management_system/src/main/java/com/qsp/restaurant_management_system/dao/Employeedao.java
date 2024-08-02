package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Employee;
import com.qsp.restaurant_management_system.repo.EmployeeRepo;

@Repository
public class Employeedao {
	@Autowired
	EmployeeRepo employeeRepo;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	public Employee fecthByEmployeeID (int employeeId) {
		Optional<Employee> employee= employeeRepo.findById(employeeId);
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}
	public Employee updateEmployee(Employee newemployee ,int oldemployeeId) {
		newemployee.setEmployeId(oldemployeeId);
		return employeeRepo.save(newemployee);
	}
	public Employee deleteEmployee(int employeeid) {
		Employee Employee = employeeRepo.findById(employeeid).get();
		employeeRepo.delete(Employee);
		return Employee;
	}
	public List<Employee> fetchallEmployee(){
		return employeeRepo.findAll();
	}

}
