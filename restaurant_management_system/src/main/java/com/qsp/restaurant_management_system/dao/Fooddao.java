package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.repo.Foodrepo;

@Repository
public class Fooddao {
    @Autowired
	Foodrepo foodrepo;
    @Autowired
    FoodOrderdao foodOrderdao;
    
    public Food saveFood(Food food) {
    	return foodrepo.save(food);
    }
    public Food  fetchByFoodId(int foodId) {
    	
    Optional<Food> food=foodrepo.findById(foodId);
    if(food.isPresent()) {
    	return food.get();
    }
    return null;
    }
    public Food updateFood(Food newfood, int oldfoodId) {
    	      newfood.setFoodId(oldfoodId);
    	return foodrepo.save(newfood);
    }
    public Food deleteFood(int foodId) {
    	Food food= foodrepo.findById(foodId).get();
    	foodrepo.delete(food);
    	return food;
    }
    public List<Food> fetchAllFood(){
    	return foodrepo.findAll();
    }
    public Food AddExistingFodOrderToFood(int foodorderID,int foodid) {
    	       Food food=fetchByFoodId(foodid);
    	         FoodOrder foodOrder = foodOrderdao.fetchbiFoodOrderId(foodorderID);
    	         List<FoodOrder>list = food.getFoodOrders();
    	         list.add(foodOrder);
    	         food.setFoodOrders(list);
    	         return saveFood(food);
    }
    public Food AddNewFoodOrderToExsistingFood(int foodid,FoodOrder newfoodOrder) {
    	  Food food=fetchByFoodId(foodid);
	         FoodOrder foodOrder = foodOrderdao.savefoodOrder(newfoodOrder);
	         List<FoodOrder>list = food.getFoodOrders();
	         list.add(foodOrder);
	         food.setFoodOrders(list);
	         return saveFood(food);
    }
}
