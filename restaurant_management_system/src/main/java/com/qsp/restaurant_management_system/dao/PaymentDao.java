package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Payment;
import com.qsp.restaurant_management_system.repo.PaymentRepo;

@Repository
public class PaymentDao {
     @Autowired
	PaymentRepo paymentRepo;
     
    public Payment savePayment(Payment payment){
    	return paymentRepo.save(payment);	
    }
    public Payment fetchbyId(int paymentId) {
    	Optional<Payment>payment= paymentRepo.findById(paymentId);
    	if(payment.isPresent()) {
    		payment.isPresent();
    	}return null;
    }
    public Payment updatePayment(Payment newpayment,int OldpaymentId) {
    	      newpayment.setPaymentid(OldpaymentId);
    	return paymentRepo.save(newpayment);
    }
    public Payment deletePayment(int paymentId) {
    	Payment payment= fetchbyId(paymentId); 
    	      paymentRepo.delete(payment);
    	      return payment;
    }
    public List<Payment> fetchAllPayments(){
    	return paymentRepo.findAll();
    }
}
