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

import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.service.FoodService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@RestController
public class FoodController {
   @Autowired
	FoodService foodService;
   
   @PostMapping("/saveFood")
   public ResponseEntity<ResponseStructure<Food>> saveFood(@RequestBody Food food) {
   	return foodService.saveFood(food);
   }
   @GetMapping("/fetchByFoodId")
   public ResponseEntity<ResponseStructure<Food>>  fetchByFoodId(@RequestParam int foodId) {
   	return foodService.fetchByFoodId(foodId);
   }
   @PutMapping("/updateFood")
   public ResponseEntity<ResponseStructure<Food>> updateFood(@RequestBody Food newfood,@RequestParam int oldfoodId) {
   	return foodService.updateFood(newfood, oldfoodId);
   }
   @DeleteMapping("/deleteFood")
   public ResponseEntity<ResponseStructure<Food>> deleteFood(@RequestParam int foodId) {
   	return foodService.deleteFood(foodId);
   }
   @GetMapping("/fetchAllFood")
   public ResponseEntity<ResponseStructure1<Food>> fetchAllFood(){
   	return foodService.fetchAllFood();
   }
   @PutMapping("/AddExistingFodOrderToFood")
   public ResponseEntity<ResponseStructure<Food>> AddExistingFodOrderToFood(@RequestParam int foodorderID,@RequestParam int foodid) {
   	return foodService.AddExistingFodOrderToFood(foodorderID, foodid);
   }
   @PutMapping("/AddNewFoodOrderToExsistingFood")
   public ResponseEntity<ResponseStructure<Food>> AddNewFoodOrderToExsistingFood(@RequestParam int foodid,@RequestBody FoodOrder newfoodOrder) {
   	return foodService.AddNewFoodOrderToExsistingFood(foodid, newfoodOrder);
   }
}
