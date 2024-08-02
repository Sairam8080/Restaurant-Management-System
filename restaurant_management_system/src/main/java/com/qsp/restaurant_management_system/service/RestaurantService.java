package com.qsp.restaurant_management_system.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.Branchdao;
import com.qsp.restaurant_management_system.dao.RestaurantDao;
import com.qsp.restaurant_management_system.dto.Branch;
import com.qsp.restaurant_management_system.dto.Restaurant;
import com.qsp.restaurant_management_system.exception.BranchNotFound;
import com.qsp.restaurant_management_system.exception.EnteredDuplicateEntries;
import com.qsp.restaurant_management_system.exception.OwnerIdNotFound;
import com.qsp.restaurant_management_system.exception.RestaurantNotFound;
import com.qsp.restaurant_management_system.repo.RestaurantRepo;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@Service
public class RestaurantService {
	
	@Autowired
	 RestaurantDao restaurantDao;
	@Autowired
	RestaurantRepo restaurantRepo;
	@Autowired
	Branchdao branchdao;
	@Autowired
    ResponseStructure<Restaurant> responseStructure;
	@Autowired
	ResponseStructure1<Restaurant> responseStructure1;
	
	public ResponseEntity<ResponseStructure<Restaurant>> saveRestaurant(Restaurant restaurant) {
		 responseStructure.setStatusCode(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Sucessfully inserted Restaurant into DB");
	    	responseStructure.setData( restaurantDao.saveRestaurant(restaurant));
	    	return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Restaurant>> findBYRestaurantId(int restaurantId) {
	Restaurant restaurant	=restaurantDao.findBYRestaurantId(restaurantId);
	if(restaurant!=null) {
		 responseStructure.setStatusCode(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Sucessfully Updated Restaurant into DB");
	    	responseStructure.setData(restaurantDao.findBYRestaurantId(restaurantId));
	    	return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.FOUND);
	  } else {
			throw new RestaurantNotFound();
		}
	}
	public ResponseEntity<ResponseStructure<Restaurant>> updateRestaurant(Restaurant newrestaurant,int oldrestaurantId) {
		Restaurant restaurant	=restaurantDao.findBYRestaurantId(oldrestaurantId);
		if(restaurant!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
    	responseStructure.setMessage("Sucessfully Updated Restaurant From DB");
    	responseStructure.setData(restaurantDao.updateRestaurant(newrestaurant, oldrestaurantId));
    	return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
		 } else {
				throw new RestaurantNotFound();
			}
	}
	public ResponseEntity<ResponseStructure<Restaurant>> deleteRestaurant(int restaurantId) {
		Restaurant restaurant	=restaurantDao.findBYRestaurantId(restaurantId);
		if(restaurant!=null) {
		 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Deleted Restaurant From DB");
	    	responseStructure.setData(restaurantDao.deleteRestaurant(restaurantId));
	    	return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
		 } else {
				throw new RestaurantNotFound();
			}
		 
	}
	public ResponseEntity<ResponseStructure1<Restaurant>> fetchAllRestaurants(){
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
    	responseStructure1.setMessage("Sucessfully Fetched all Restaurantes From DB");
    	responseStructure1.setData(restaurantDao.fetchAllRestaurants());
    	return new ResponseEntity<ResponseStructure1<Restaurant>>(responseStructure1, HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<Restaurant>> addExsistingBranchToexstingRestaurant(int branchid,int resturantid) {
		Restaurant restaurant	=restaurantDao.findBYRestaurantId(resturantid);
		 Branch branch  =  branchdao.fetchbyBranchId(branchid);
		 List<Branch>branchs=restaurant.getBranchs();
		 for(Branch branch2:branchs) {
			 if(branch2.getBranchId()==branchid) {
			    	throw new EnteredDuplicateEntries();
			 }
		 }
		if(restaurant!=null && branch!=null) { 
			 responseStructure.setStatusCode(HttpStatus.OK.value());
		    	responseStructure.setMessage("Sucessfully Added Existing Branch to Existing Restaurant from DB");
		    	responseStructure.setData(restaurantDao.addExsistingBranchToexstingRestaurant(branchid, resturantid));
		    	return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
			}
		else if(branch==null) {
				throw new BranchNotFound();
			}
		else throw new RestaurantNotFound();
			
	}
	public ResponseEntity<ResponseStructure<Restaurant>> addNewBranchTOExstingRestaurant(int restaurantid, Branch branch) {
		Restaurant restaurant	=restaurantDao.findBYRestaurantId(restaurantid);
		if(restaurant!=null) {
		 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Added New Branch to Existing Restaurant from DB");
	    	responseStructure.setData( restaurantDao.addNewBranchTOExstingRestaurant(restaurantid, branch));
	    	return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
	 } else {
			throw new RestaurantNotFound();
		}
	}
	
}
