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

import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.service.CustomerSrevice;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@RestController
public class CustomerController {
     @Autowired
	CustomerSrevice customerSrevice;
     @PostMapping("/saveCustomer")
     public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
    	 return customerSrevice.saveCustomer(customer);
     }
     @GetMapping("/fetchbyCustomerId")
     public ResponseEntity<ResponseStructure<Customer>> fetchbyCustomerId(@RequestParam int customerid) {
    	 return customerSrevice.fetchbyCustomerId(customerid);
     }
     @PutMapping("/updateCustomer")
     public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer newcustomer,@RequestParam int oldCustomerId) {
    	 return customerSrevice.updateCustomer(newcustomer, oldCustomerId);
     }
     @DeleteMapping("/deleteCustomer")
     public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@RequestParam int deleteId) {
    	 return customerSrevice.deleteCustomer(deleteId);
     }
     @GetMapping("/fetchallCustomers")
     public ResponseEntity<ResponseStructure1<Customer>> fetchallCustomers (){
    	 return customerSrevice.fetchallCustomers();
     }
     @PutMapping("/AddExistingFoodOrderToExistingCustomer")
     public ResponseEntity<ResponseStructure<Customer>> AddExistingFoodOrderToExistingCustomer(@RequestParam int foodorderid, @RequestParam int customerid) {
     	return customerSrevice.AddExistingFoodOrderToExistingCustomer(foodorderid, customerid);
     	
     }@PutMapping("/AddNewFooodOrderToExistingCustomer")
     public ResponseEntity<ResponseStructure<Customer>> AddNewFooodOrderToExistingCustomer(@RequestParam int customerid,@RequestBody FoodOrder newfoodOrder) {
     	return customerSrevice.AddNewFooodOrderToExistingCustomer(customerid, newfoodOrder);
     }
}
