package com.qsp.restaurant_management_system.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.FoodOrderdao;
import com.qsp.restaurant_management_system.dao.Fooddao;
import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.exception.BranchNotFound;
import com.qsp.restaurant_management_system.exception.EnteredDuplicateEntries;
import com.qsp.restaurant_management_system.exception.FoodNotFound;
import com.qsp.restaurant_management_system.exception.FoodOrderNotFound;
import com.qsp.restaurant_management_system.repo.Foodrepo;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@Service
public class FoodService {
    @Autowired
	Fooddao fooddao;
    @Autowired
    FoodOrderdao foodOrderdao;
    @Autowired
    Foodrepo foodrepo;
	@Autowired
    ResponseStructure<Food> responseStructure;
	@Autowired
	ResponseStructure1<Food> responseStructure1;
    
    public ResponseEntity<ResponseStructure<Food>> saveFood(Food food) {
    	 responseStructure.setStatusCode(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Sucessfully inserted Food into DB");
	    	responseStructure.setData(fooddao.saveFood(food));
	    	return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.CREATED);
    }
    public ResponseEntity<ResponseStructure<Food>>  fetchByFoodId(int foodId) {
    	             Food food=fooddao.fetchByFoodId(foodId);
    	             if(food!=null) {
    	 responseStructure.setStatusCode(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Sucessfully Fetched Food From DB");
	    	responseStructure.setData(fooddao.fetchByFoodId(foodId));
	    	return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.FOUND);
    	             }else {
    	            	 throw new FoodNotFound();
    	             }
	    	
    }
    public ResponseEntity<ResponseStructure<Food>> updateFood(Food newfood, int oldfoodId) {
    	 Food food=fooddao.fetchByFoodId(oldfoodId);
         if(food!=null) {
    	responseStructure.setStatusCode(HttpStatus.OK.value());
    	responseStructure.setMessage("Sucessfully Updated Food From DB");
    	responseStructure.setData( fooddao.updateFood(newfood, oldfoodId));
    	return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.OK);
         }else {
        	 throw new FoodNotFound();
         }
    }
    public ResponseEntity<ResponseStructure<Food>> deleteFood(int foodId) {
    	  Food food=fooddao.fetchByFoodId(foodId);
          if(food!=null) {
    	 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Deleted Food From DB");
	    	responseStructure.setData(fooddao.deleteFood(foodId));
	    	return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.OK);
          }else {
         	 throw new FoodNotFound();
          }
    }
    public ResponseEntity<ResponseStructure1<Food>> fetchAllFood(){
    	 responseStructure1.setStatusCode(HttpStatus.FOUND.value());
	    	responseStructure1.setMessage("Sucessfully Fetched all Food From DB");
	    	responseStructure1.setData(fooddao.fetchAllFood());
	    	return new ResponseEntity<ResponseStructure1<Food>>(responseStructure1, HttpStatus.FOUND);
    }
    public ResponseEntity<ResponseStructure<Food>> AddExistingFodOrderToFood(int foodorderID,int foodid) {
    	Food food=fooddao.fetchByFoodId(foodid);
    	      FoodOrder foodOrder= foodOrderdao.fetchbiFoodOrderId(foodorderID);
    	      List<FoodOrder>foodOrders=food.getFoodOrders();
    	      for(FoodOrder foodOrder2: foodOrders) {
    	    	  if(foodOrder2.getFoodOrderId()==foodid) {
				    	throw new EnteredDuplicateEntries();

    	    	  }
    	      }
        if(food!=null&&foodOrder!=null ) {
    	 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Added Existing FoodOrder to Exiting Food From DB");
	    	responseStructure.setData(fooddao.AddExistingFodOrderToFood(foodorderID, foodid));
	    	return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.OK);
        	}
        else if(foodOrder==null) {
			throw new BranchNotFound();
		}else {
			throw new FoodOrderNotFound();
         }
    }
    public ResponseEntity<ResponseStructure<Food>> AddNewFoodOrderToExsistingFood(int foodid,FoodOrder newfoodOrder) {
    	Food food=fooddao.fetchByFoodId(foodid);
	      FoodOrder foodOrder= foodOrderdao.savefoodOrder(newfoodOrder);
  if(food!=null&&foodOrder!=null ) {
    	 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully  Added new FoodOrder to Exiting Food From DB");
	    	responseStructure.setData(fooddao.AddNewFoodOrderToExsistingFood(foodid, newfoodOrder));
	    	return new ResponseEntity<ResponseStructure<Food>>(responseStructure, HttpStatus.OK);
    }else {
   	 throw new FoodNotFound();
    }
    }
}
