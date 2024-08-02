package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Branch;
import com.qsp.restaurant_management_system.dto.Restaurant;
import com.qsp.restaurant_management_system.repo.RestaurantRepo;

@Repository
public class RestaurantDao {
	
	@Autowired
	RestaurantRepo restaurantRepo;
	@Autowired
	Branchdao branchdao;
	public Restaurant saveRestaurant(Restaurant restaurant ) {
		return restaurantRepo.save(restaurant);
	}
	public Restaurant findBYRestaurantId(int restaurantId) {
		Optional<Restaurant>restaurant= restaurantRepo.findById(restaurantId);
		if(restaurant.isPresent()) {
			return restaurant.get();
		}return null;
	}
	public Restaurant updateRestaurant(Restaurant newrestaurant,int oldrestaurantId) {
		           newrestaurant.setRestaurantId(oldrestaurantId);
		return restaurantRepo.save(newrestaurant);
	}
	public Restaurant deleteRestaurant(int restaurantId) {
		Restaurant restaurant = findBYRestaurantId(restaurantId);
		restaurantRepo.delete(restaurant);
		return restaurant;
	}
	public List<Restaurant> fetchAllRestaurants(){
		return restaurantRepo.findAll();
	}
	public Restaurant addExsistingBranchToexstingRestaurant(int branchid,int resturantid) {
		      Restaurant restaurant = findBYRestaurantId(resturantid);
		  Branch branch   = branchdao.fetchbyBranchId(branchid);
		  List<Branch> list = restaurant.getBranchs();
		  list.add(branch);
		  restaurant.setBranchs(list);
		  return saveRestaurant(restaurant);
	}
	public Restaurant addNewBranchTOExstingRestaurant(int restaurantid, Branch branch) {
	Restaurant restaurant= findBYRestaurantId(restaurantid);
	                 List<Branch> list =restaurant.getBranchs();
	                 list.add(branch);
	                 restaurant.setBranchs(list);
	                 return saveRestaurant(restaurant);
	}
	

}
