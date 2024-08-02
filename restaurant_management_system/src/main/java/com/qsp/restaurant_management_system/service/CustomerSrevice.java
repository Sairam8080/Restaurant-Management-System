package com.qsp.restaurant_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.Customerdao;
import com.qsp.restaurant_management_system.dao.FoodOrderdao;
import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.exception.BranchNotFound;
import com.qsp.restaurant_management_system.exception.CustomerNotFound;
import com.qsp.restaurant_management_system.exception.EnteredDuplicateEntries;
import com.qsp.restaurant_management_system.exception.FoodOrderNotFound;
import com.qsp.restaurant_management_system.exception.OwnerIdNotFound;
import com.qsp.restaurant_management_system.repo.CustomerRepo;
import com.qsp.restaurant_management_system.repo.Foodrepo;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@Service
public class CustomerSrevice {
    @Autowired
	Customerdao customerdao;
    @Autowired
    FoodOrderdao foodOrderdao;
    @Autowired
     CustomerRepo customerRepo;
	@Autowired
    ResponseStructure<Customer> responseStructure;
	@Autowired
	ResponseStructure1<Customer> responseStructure1;
    
    public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
    	
    	  responseStructure.setStatusCode(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Sucessfully inserted Customer into DB");
	    	responseStructure.setData(customerdao.saveCustomer(customer));
	    	return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);

    }
    public ResponseEntity<ResponseStructure<Customer>> fetchbyCustomerId(int customerid) {
    	Customer  customer=customerdao.fetchbyCustomerId(customerid);
    	if(customer!=null) {
    	  responseStructure.setStatusCode(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Sucessfully Fetch Customer From DB");
	    	responseStructure.setData( customerdao.fetchbyCustomerId(customerid));
	    	return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
    	} else {
			throw new CustomerNotFound();
		}
	    	 }
    public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer newcustomer,int oldCustomerId) {
    	Customer  customer=customerdao.fetchbyCustomerId(oldCustomerId);
    	if(customer!=null) {
    	 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Updated Customer From DB");
	    	responseStructure.setData( customerdao.updateCustomer(newcustomer, oldCustomerId));
	    	return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
    	} else {
			throw new CustomerNotFound();
		}
    }
    public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int deleteId) {
    	Customer  customer=customerdao.fetchbyCustomerId(deleteId);
    	if(customer!=null) {
    	 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Deleted Customers From DB");
	    	responseStructure.setData( customerdao.deleteCustomer(deleteId));
	    	return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
    	} else {
			throw new CustomerNotFound();
		}
    }
    public ResponseEntity<ResponseStructure1<Customer>> fetchallCustomers (){
    	 responseStructure1.setStatusCode(HttpStatus.FOUND.value());
	    	responseStructure1.setMessage("Sucessfully Fetched all Customers From DB");
	    	responseStructure1.setData( customerdao.fetchallCustomers());
	    	return new ResponseEntity<ResponseStructure1<Customer>>(responseStructure1,HttpStatus.FOUND);
    }
    public ResponseEntity<ResponseStructure<Customer>> AddExistingFoodOrderToExistingCustomer(int foodorderid,int customerid) {
    	Customer  customer=customerdao.fetchbyCustomerId(customerid);
        FoodOrder foodOrder =foodOrderdao.fetchbiFoodOrderId(foodorderid);
    	if(customer!=null && foodOrder!=null) {
    		if( customerRepo.existsById(foodOrder.getFoodOrderId())) {
    			throw new EnteredDuplicateEntries();
    		}
    	 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Added Existing FoodOrder To Existing Customer From DB");
	    	responseStructure.setData( customerdao.AddExistingFoodOrderToExistingCustomer(foodorderid, customerid));
	    	return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
    	}else if(foodOrder==null) {
    		throw new FoodOrderNotFound();
		}
    	else {
			throw new CustomerNotFound();
		}
    }
    public ResponseEntity<ResponseStructure<Customer>> AddNewFooodOrderToExistingCustomer(int customerid,FoodOrder newfoodOrder) {
    	Customer  customer=customerdao.fetchbyCustomerId(customerid);
    	if(customer!=null) {
    	 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Added Existing FoodOrder To Existing Customer From DB");
	    	responseStructure.setData( customerdao.AddNewFooodOrderToExistingCustomer(customerid, newfoodOrder));
	    	return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
    	} else {
			throw new CustomerNotFound();
		}
    }
}
