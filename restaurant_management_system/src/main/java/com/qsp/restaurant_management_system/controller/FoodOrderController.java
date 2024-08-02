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

import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.dto.Payment;
import com.qsp.restaurant_management_system.service.FoodOrderService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@RestController
public class FoodOrderController {
     @Autowired
	FoodOrderService foodOrderService;
     @PostMapping("/saveFoodOrder")
     public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
 		return foodOrderService.saveFoodOrder(foodOrder);
 	}
     @GetMapping("/fetchbiFoodOrderId")
 	public ResponseEntity<ResponseStructure<FoodOrder>> fetchbiFoodOrderId(@RequestParam int foodOrderId) {
 		return foodOrderService.fetchbiFoodOrderId(foodOrderId);
 	}
     @PutMapping("/updateFoodOrder")
     public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder( @RequestBody FoodOrder newfoodOrder,@RequestParam int foodorderid) {
     	return foodOrderService.updateFoodOrder(newfoodOrder, foodorderid);
     }
     @DeleteMapping("/deleteFoodOrder")
     public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@RequestParam int foodorderId) {
     	return foodOrderService.deleteFoodOrder(foodorderId);
     }
     @GetMapping("/fetchAllFoodOrders")
     public ResponseEntity<ResponseStructure1<FoodOrder>> fetchAllFoodOrders (){
     	return foodOrderService.fetchAllFoodOrders();
     }
     
     @PutMapping("/AddingExistingPaymentToExsistingFoodOrder")
     public ResponseEntity<ResponseStructure<FoodOrder>> AddingExistingPaymentToExsistingFoodOrder(@RequestParam int foodorderId,@RequestParam int paymentid) {
    	 return foodOrderService.AddingExistingPaymentToExsistingFoodOrder(foodorderId, paymentid);
     }
     @PutMapping("/AddnewPaymentToExstingFoodOrder")
     public ResponseEntity<ResponseStructure<FoodOrder>> AddnewPaymentToExstingFoodOrder(@RequestParam int foodOrderId,@RequestBody Payment payment ) {
    	 return foodOrderService.AddnewPaymentToExstingFoodOrder(foodOrderId, payment);
     }
     
}