package com.qsp.restaurant_management_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qsp.restaurant_management_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionController {
	@Autowired
	ResponseStructure responseStructure;
	
     @ExceptionHandler(OwnerIdNotFound.class)
	 public ResponseEntity<ResponseStructure<String>> ownerIdNOtFound(OwnerIdNotFound ownerIdNotFound) {
   	  responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	    	responseStructure.setMessage("ID NOT FOUND PLEASE ENTER VALID ID");
	    	responseStructure.setData(ownerIdNotFound.getMessage());
	    	return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
   	
   }
     @ExceptionHandler(AddressNotFound.class)
     public ResponseEntity<ResponseStructure<String>> addressNOtFound(AddressNotFound addressNotFound) {
      	  responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
   	    	responseStructure.setMessage("ID NOT FOUND PLEASE ENTER VALID ID");
   	    	responseStructure.setData(addressNotFound.getMessage());
   	    	return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
      	
      }
     @ExceptionHandler(BranchNotFound.class)
     public ResponseEntity<ResponseStructure<String>> branchNOtFound(BranchNotFound branchNotFound) {
     	  responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
  	    	responseStructure.setMessage("ID NOT FOUND PLEASE ENTER VALID ID");
  	    	responseStructure.setData(branchNotFound.getMessage());
  	    	return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
     	
     }
     @ExceptionHandler(CustomerNotFound.class)
     public ResponseEntity<ResponseStructure<String>> customerNOtFound(CustomerNotFound customerNotFound) {
    	  responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
 	    	responseStructure.setMessage("ID NOT FOUND PLEASE ENTER VALID ID");
 	    	responseStructure.setData(customerNotFound.getMessage());
 	    	return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
           }
     @ExceptionHandler(EmployeeNotFound.class)
     public ResponseEntity<ResponseStructure<String>> employeeNOtFound(EmployeeNotFound employeeNotFound) {
   	  responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	    	responseStructure.setMessage("ID NOT FOUND PLEASE ENTER VALID ID");
	    	responseStructure.setData(employeeNotFound.getMessage());
	    	return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
          }
     @ExceptionHandler(FoodNotFound.class)
     public ResponseEntity<ResponseStructure<String>> foodNOtFound(FoodNotFound foodNotFound) {
      	  responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
   	    	responseStructure.setMessage("ID NOT FOUND PLEASE ENTER VALID ID");
   	    	responseStructure.setData(foodNotFound.getMessage());
   	    	return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
             }
     @ExceptionHandler(FoodOrderNotFound.class)
     public ResponseEntity<ResponseStructure<String>> foorOrderNOtFound(FoodOrderNotFound foodOrderNotFound) {
      	  responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
   	    	responseStructure.setMessage("ID NOT FOUND PLEASE ENTER VALID ID");
   	    	responseStructure.setData(foodOrderNotFound.getMessage());
   	    	return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
             }
     @ExceptionHandler(ManagerNotFound.class)
     public ResponseEntity<ResponseStructure<String>> employeeNOtFound(ManagerNotFound managerNotFound) {
      	  responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
   	    	responseStructure.setMessage("ID NOT FOUND PLEASE ENTER VALID ID");
   	    	responseStructure.setData(managerNotFound.getMessage());
   	    	return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
             }
     @ExceptionHandler(MenuNotFound.class)
     public ResponseEntity<ResponseStructure<String>> employeeNOtFound(MenuNotFound menuNotFound) {
      	  responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
   	    	responseStructure.setMessage("ID NOT FOUND PLEASE ENTER VALID ID");
   	    	responseStructure.setData(menuNotFound.getMessage());
   	    	return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
             }
     @ExceptionHandler(PaymentNotFound.class)
     public ResponseEntity<ResponseStructure<String>> employeeNOtFound(PaymentNotFound paymentNotFound) {
      	  responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
   	    	responseStructure.setMessage("ID NOT FOUND PLEASE ENTER VALID ID");
   	    	responseStructure.setData(paymentNotFound.getMessage());
   	    	return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
             }
     @ExceptionHandler(RestaurantNotFound.class)
     public ResponseEntity<ResponseStructure<String>> employeeNOtFound(RestaurantNotFound restaurantNotFound) {
      	  responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
   	    	responseStructure.setMessage("ID NOT FOUND PLEASE ENTER VALID ID");
   	    	responseStructure.setData(restaurantNotFound.getMessage());
   	    	return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
             }
     
     @ExceptionHandler(EnteredDuplicateEntries.class) 
   
     public ResponseEntity<ResponseStructure<String>> enteredDuplicateEntries(EnteredDuplicateEntries enteredDuplicateEntries) {
      	  responseStructure.setStatusCode(HttpStatus.CONFLICT.value());
   	    	responseStructure.setMessage("Duplicate entry found");
   	    	responseStructure.setData(enteredDuplicateEntries.getMessage());
   	    	return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.CONFLICT);
             }
     

}