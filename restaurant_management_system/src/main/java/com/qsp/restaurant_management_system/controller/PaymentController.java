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

import com.qsp.restaurant_management_system.dto.Payment;
import com.qsp.restaurant_management_system.service.PaymentService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	@PostMapping("/savePayment")
	public ResponseEntity<ResponseStructure<Payment>> savePayment(@RequestBody Payment payment){
    	return paymentService.savePayment(payment)	;
    }
	@GetMapping("/fetchbyId")
    public ResponseEntity<ResponseStructure<Payment>> fetchbyId(@RequestParam int paymentId) {
    	return paymentService.fetchbyId(paymentId);
    }
	@PutMapping("/updatePayment")
    public ResponseEntity<ResponseStructure<Payment>> updatePayment(@RequestBody Payment newpayment,@RequestParam int OldpaymentId) {
    	return paymentService.updatePayment(newpayment, OldpaymentId);
    }
	@DeleteMapping("/deletePayment")
    public ResponseEntity<ResponseStructure<Payment>> deletePayment(@RequestParam int paymentId) {
     return paymentService.deletePayment(paymentId);
    }@GetMapping("/fetchAllPayments")
    public ResponseEntity<ResponseStructure1<Payment>> fetchAllPayments(){
    	return paymentService.fetchAllPayments();
    }
}
