package com.qsp.restaurant_management_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.restaurant_management_system.dto.Employee;
import com.qsp.restaurant_management_system.service.EmployeeService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("saveEmployee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	@GetMapping("/fecthByEmployeeID")
	public ResponseEntity<ResponseStructure<Employee>> fecthByEmployeeID (@RequestParam int employeeId) {
		return employeeService.fecthByEmployeeID(employeeId);
	}
	@PutMapping("/updateEmployee")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee newemployee ,@RequestParam int oldemployeeId) {
		return employeeService.updateEmployee(newemployee, oldemployeeId);
	}
	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@RequestParam int employeeid) {
		return employeeService.deleteEmployee(employeeid);
	}
	@GetMapping("/fetchallEmployee")
	public ResponseEntity<ResponseStructure1<Employee>> fetchallEmployee(){
		return employeeService.fetchallEmployee();
	}
}
