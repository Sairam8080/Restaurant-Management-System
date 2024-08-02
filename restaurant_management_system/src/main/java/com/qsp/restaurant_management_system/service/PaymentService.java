package com.qsp.restaurant_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.PaymentDao;
import com.qsp.restaurant_management_system.dto.Payment;
import com.qsp.restaurant_management_system.exception.OwnerIdNotFound;
import com.qsp.restaurant_management_system.exception.PaymentNotFound;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@Service
public class PaymentService {
	
	@Autowired
	PaymentDao paymentDao;
	@Autowired
    ResponseStructure<Payment> responseStructure;
	@Autowired
	ResponseStructure1< Payment> responseStructure1;
	
	 public ResponseEntity<ResponseStructure<Payment>> savePayment(Payment payment){
		 responseStructure.setStatusCode(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Sucessfully inserted Payment into DB");
	    	responseStructure.setData(paymentDao.savePayment(payment)	);
	    	return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.CREATED);
	    }
	    public ResponseEntity<ResponseStructure<Payment>> fetchbyId(int paymentId) {
	    	      Payment payment =paymentDao.fetchbyId(paymentId);
	    	      if(payment!=null) {
	   	 responseStructure.setStatusCode(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Sucessfully Updated Payment into DB");
	    	responseStructure.setData(paymentDao.fetchbyId(paymentId));
	    	return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.FOUND);
	    	      } else {
						throw new PaymentNotFound();
					}
	    }
	    public ResponseEntity<ResponseStructure<Payment>> updatePayment(Payment newpayment,int OldpaymentId) {
	    	   Payment payment =paymentDao.fetchbyId(OldpaymentId);
	    	      if(payment!=null) {
	    	responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Updated Payment From DB");
	    	responseStructure.setData( paymentDao.updatePayment(newpayment, OldpaymentId));
	    	return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.OK);
	    	      } else {
						throw new PaymentNotFound();
					}
	    }
	    public ResponseEntity<ResponseStructure<Payment>> deletePayment(int paymentId) {
	    	 Payment payment =paymentDao.fetchbyId(paymentId);
   	      if(payment!=null) {
	    	 responseStructure.setStatusCode(HttpStatus.OK.value());
		    	responseStructure.setMessage("Sucessfully Payment Menu From DB");
		    	responseStructure.setData(paymentDao.deletePayment(paymentId));
		    	return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.OK);
   	   } else {
			throw new PaymentNotFound();
		}
	    	
	    }
	    public ResponseEntity<ResponseStructure1<Payment>> fetchAllPayments(){
	    	 responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		    	responseStructure1.setMessage("Sucessfully Fetched all Paymentes From DB");
		    	responseStructure1.setData(paymentDao.fetchAllPayments());
		    	return new ResponseEntity<ResponseStructure1<Payment>>(responseStructure1,HttpStatus.FOUND);
	    }

}
