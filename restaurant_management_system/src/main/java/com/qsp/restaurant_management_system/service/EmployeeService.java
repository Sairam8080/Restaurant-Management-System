package com.qsp.restaurant_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.Employeedao;
import com.qsp.restaurant_management_system.dto.Employee;
import com.qsp.restaurant_management_system.exception.EmployeeNotFound;
import com.qsp.restaurant_management_system.exception.OwnerIdNotFound;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@Service
public class EmployeeService {

	@Autowired
	Employeedao employeedao;
	@Autowired
    ResponseStructure<Employee> responseStructure;
	@Autowired
	ResponseStructure1<Employee> responseStructure1;
	
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		 responseStructure.setStatusCode(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Sucessfully inserted Employee into DB");
	    	responseStructure.setData(employeedao.saveEmployee(employee));
	    	return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Employee>> fecthByEmployeeID (int employeeId) {
		         Employee employee    = employeedao.fecthByEmployeeID(employeeId);
		         if(employee!=null) {
		  responseStructure.setStatusCode(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Sucessfully Fetched Employee From DB");
	    	responseStructure.setData( employeedao.fecthByEmployeeID(employeeId));
	    	return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.FOUND);
		         } else {
		 			throw new EmployeeNotFound();
		 		}
	}
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee newemployee ,int oldemployeeId) {
		  Employee employee    = employeedao.fecthByEmployeeID(oldemployeeId);
	         if(employee!=null) {
		 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Updated Employee From DB");
	    	responseStructure.setData( employeedao.updateEmployee(newemployee, oldemployeeId));
	    	return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
	         } else {
		 			throw new EmployeeNotFound();
		 		}
	}
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int employeeid) {
		  Employee employee    = employeedao.fecthByEmployeeID(employeeid);
	         if(employee!=null) {
		 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Deleted Employee From DB");
	    	responseStructure.setData(employeedao.deleteEmployee(employeeid));
	    	return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
	         } else {
		 			throw new EmployeeNotFound();
		 		}
	}
	public ResponseEntity<ResponseStructure1<Employee>> fetchallEmployee(){
		 responseStructure1.setStatusCode(HttpStatus.FOUND.value());
	    	responseStructure1.setMessage("Sucessfully Fetched all Employees From DB");
	    	responseStructure1.setData( employeedao.fetchallEmployee());
	    	return new ResponseEntity<ResponseStructure1<Employee>>(responseStructure1,HttpStatus.FOUND);
	}
}
