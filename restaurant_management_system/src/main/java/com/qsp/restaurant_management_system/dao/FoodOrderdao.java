package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.dto.Payment;
import com.qsp.restaurant_management_system.repo.FoodOrderRepo;

@Repository
public class FoodOrderdao {
    @Autowired
	FoodOrderRepo foodOrderRepo;
    @Autowired
    PaymentDao paymentDao;
    
    public FoodOrder savefoodOrder(FoodOrder foodOrder) {
    	return foodOrderRepo.save(foodOrder);
    }
    public FoodOrder fetchbiFoodOrderId(int foodOrderId) {
    	 
    	Optional<FoodOrder>foodorder= foodOrderRepo.findById(foodOrderId);
    	if(foodorder.isPresent()) {
    		return foodorder.get();
    	}
    	return null;
    }
    public FoodOrder updateFoodOrder(FoodOrder newfoodOrder,int foodorderid) {
    	     newfoodOrder.setFoodOrderId(foodorderid);
    	return foodOrderRepo.save(newfoodOrder);
    }
    public FoodOrder deleteFoodOrder(int foodorderId) {
    	FoodOrder foodOrder = foodOrderRepo.findById(foodorderId).get();
    	    foodOrderRepo.delete(foodOrder);
    	    return foodOrder;
    }
    public List<FoodOrder> fetchAllFoodOrders (){
    	return foodOrderRepo.findAll();
    }
    public FoodOrder AddingExistingPaymentToExsistingFoodOrder(int foodorderId,int paymentid) {
    	         FoodOrder foodOrder= fetchbiFoodOrderId(foodorderId);
    	                     Payment payment= paymentDao.fetchbyId(paymentid);
    	                     foodOrder.setPayment(payment);
    	              return savefoodOrder(foodOrder);
    }
    public FoodOrder AddnewPaymentToExstingFoodOrder(int foodOrderId,Payment payment ) {
    	    FoodOrder foodOrder= fetchbiFoodOrderId(foodOrderId);
    	       foodOrder.setPayment(payment);
    	       return savefoodOrder(foodOrder);
    }
    
    
}
