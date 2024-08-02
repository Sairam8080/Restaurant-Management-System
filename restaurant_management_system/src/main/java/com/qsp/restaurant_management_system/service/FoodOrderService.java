package com.qsp.restaurant_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.FoodOrderdao;
import com.qsp.restaurant_management_system.dao.PaymentDao;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.dto.Payment;
import com.qsp.restaurant_management_system.exception.EnteredDuplicateEntries;
import com.qsp.restaurant_management_system.exception.FoodOrderNotFound;
import com.qsp.restaurant_management_system.exception.OwnerIdNotFound;
import com.qsp.restaurant_management_system.repo.FoodOrderRepo;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderdao foodOrderdao;
	@Autowired
	PaymentDao paymentDao;
	@Autowired
	FoodOrderRepo foodOrderRepo;
	@Autowired
    ResponseStructure<FoodOrder> responseStructure;
	@Autowired
	ResponseStructure1<FoodOrder> responseStructure1;
	
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		           
		 responseStructure.setStatusCode(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Sucessfully inserted FoodOrder into DB");
	    	responseStructure.setData(foodOrderdao.savefoodOrder(foodOrder));
	    	return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<FoodOrder>> fetchbiFoodOrderId(int foodOrderId) {
		 FoodOrder foodOrder=foodOrderdao.fetchbiFoodOrderId(foodOrderId);
		 if(foodOrder!=null) {
		  responseStructure.setStatusCode(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Sucessfully Fetched FoodOrder From DB");
	    	responseStructure.setData(foodOrderdao.fetchbiFoodOrderId(foodOrderId));
	    	return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.FOUND);
		 } else {
				throw new FoodOrderNotFound();
			}
	    	
	}
    public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder newfoodOrder,int foodorderid) {
    	 FoodOrder foodOrder=foodOrderdao.fetchbiFoodOrderId(foodorderid);
		 if(foodOrder!=null) {
    	responseStructure.setStatusCode(HttpStatus.OK.value());
    	responseStructure.setMessage("Sucessfully Updated FoodOrder From DB");
    	responseStructure.setData( foodOrderdao.updateFoodOrder(newfoodOrder, foodorderid));
    	return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		 } else {
				throw new FoodOrderNotFound();
			}
    }
    public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int foodorderId) {
    	 FoodOrder foodOrder=foodOrderdao.fetchbiFoodOrderId(foodorderId);
		 if(foodOrder!=null) {
    	 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Deleted FoodOrder From DB");
	    	responseStructure.setData(foodOrderdao.deleteFoodOrder(foodorderId));
	    	return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		 } else {
				throw new FoodOrderNotFound();
			}
	    	
    }
    public ResponseEntity<ResponseStructure1<FoodOrder>> fetchAllFoodOrders (){
    	 responseStructure1.setStatusCode(HttpStatus.FOUND.value());
	    	responseStructure1.setMessage("Sucessfully Fetched all FoodOrder From DB");
	    	responseStructure1.setData(foodOrderdao.fetchAllFoodOrders());
	    	return new ResponseEntity<ResponseStructure1<FoodOrder>>(responseStructure1,HttpStatus.FOUND);
    }
    public ResponseEntity<ResponseStructure<FoodOrder>> AddingExistingPaymentToExsistingFoodOrder(int foodorderId,int paymentid) {
    	 FoodOrder foodOrder=foodOrderdao.fetchbiFoodOrderId(foodorderId);
    	  Payment payment  = paymentDao.fetchbyId(paymentid);
    	  Payment payment2=foodOrder.getPayment();
    	  if(payment2.getPaymentid()==paymentid) {
		    	throw new EnteredDuplicateEntries();
    	  }
		 if(foodOrder!=null && payment!=null) {	
    	 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Added Existing payment to Exiting FoodOrder From DB");
	    	responseStructure.setData(foodOrderdao.AddingExistingPaymentToExsistingFoodOrder(foodorderId, paymentid));
	    	return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
			 }
		  else {
				throw new FoodOrderNotFound();
			}
    }
    public ResponseEntity<ResponseStructure<FoodOrder>> AddnewPaymentToExstingFoodOrder(int foodOrderId,Payment payment ) {
    	 FoodOrder foodOrder=foodOrderdao.fetchbiFoodOrderId(foodOrderId);
		 if(foodOrder!=null) {
    	 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully  Added new payment to Exiting FoodOrder From DB");
	    	responseStructure.setData(foodOrderdao.AddnewPaymentToExstingFoodOrder(foodOrderId, payment));
	    	return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		 } else {
				throw new FoodOrderNotFound();
			}
    }
}
