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

import com.qsp.restaurant_management_system.dto.Branch;
import com.qsp.restaurant_management_system.dto.Restaurant;
import com.qsp.restaurant_management_system.service.RestaurantService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@RestController
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	@PostMapping("/saveRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> saveRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantService.saveRestaurant(restaurant);
	}

	@GetMapping("/findBYRestaurantId")
	public ResponseEntity<ResponseStructure<Restaurant>> findBYRestaurantId(@RequestParam int restaurantId) {
		return restaurantService.findBYRestaurantId(restaurantId);
	}

	@PutMapping("/updateRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> updateRestaurant(@RequestBody Restaurant newrestaurant, @RequestParam int oldrestaurantId) {
		return restaurantService.updateRestaurant(newrestaurant, oldrestaurantId);
	}
    @DeleteMapping("/deleteRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> deleteRestaurant(@RequestParam int restaurantId) {
		return restaurantService.deleteRestaurant(restaurantId);

	}
     @GetMapping("/fetchAllRestaurants")
	public ResponseEntity<ResponseStructure1<Restaurant>> fetchAllRestaurants() {
		return restaurantService.fetchAllRestaurants();
	}
     @PutMapping("/addExsistingBranchToexstingRestaurant")
     public ResponseEntity<ResponseStructure<Restaurant>> addExsistingBranchToexstingRestaurant(@RequestParam int branchid,@RequestParam int resturantid) {
    	 
           return restaurantService.addExsistingBranchToexstingRestaurant(branchid, resturantid);
     }
     @PutMapping("/addNewBranchTOExstingRestaurant")
     public ResponseEntity<ResponseStructure<Restaurant>> addNewBranchTOExstingRestaurant(@RequestParam int restaurantid,@RequestBody Branch branch) {
    	 return restaurantService. addNewBranchTOExstingRestaurant(restaurantid, branch);
    	 
     }
     
}
