package com.qsp.restaurant_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.Ownerdao;
import com.qsp.restaurant_management_system.dao.RestaurantDao;
import com.qsp.restaurant_management_system.dto.Owner;
import com.qsp.restaurant_management_system.dto.Restaurant;
import com.qsp.restaurant_management_system.exception.EnteredDuplicateEntries;
import com.qsp.restaurant_management_system.exception.FoodOrderNotFound;
import com.qsp.restaurant_management_system.exception.OwnerIdNotFound;
import com.qsp.restaurant_management_system.exception.RestaurantNotFound;
import com.qsp.restaurant_management_system.repo.OwnerRepo;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;
@Service
public class OwnerService {
    @Autowired
	Ownerdao ownerdao;
    @Autowired
    RestaurantDao restaurantDao;
    @Autowired
    OwnerRepo ownerRepo;
	@Autowired
    ResponseStructure<Owner> responseStructure;
	@Autowired
	ResponseStructure1< Owner> responseStructure1;
    
    public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner ) {
    	responseStructure.setStatusCode(HttpStatus.CREATED.value());
    	responseStructure.setMessage("Sucessfully inserted owner into DB");
    	responseStructure.setData(ownerdao.saveOwner(owner));
    	return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
    }
    public ResponseEntity<ResponseStructure<Owner>> fetchbyOwnerid(int ownerid) {
    	Owner owner = ownerdao.fetchbyOwnerid(ownerid);
    	if(owner!=null) {
    	responseStructure.setStatusCode(HttpStatus.FOUND.value());
    	responseStructure.setMessage("Sucessfully Fetched owner From DB");
    	responseStructure.setData(ownerdao.fetchbyOwnerid(ownerid));
    	return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.FOUND);
    	}else {
    		throw new OwnerIdNotFound();
    	}
    }
    public ResponseEntity<ResponseStructure<Owner>> updateOwner(int oldOwnerId,Owner newOwner) {
    	Owner owner = ownerdao.fetchbyOwnerid( oldOwnerId);
    	if(owner!=null) {
    	responseStructure.setStatusCode(HttpStatus.OK.value());
    	responseStructure.setMessage("Sucessfully owner Updated in DB");
    	responseStructure.setData(ownerdao.updateOwner(oldOwnerId, newOwner));
    	return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
    	}else {
    		throw new OwnerIdNotFound();
    	}
    }
    public ResponseEntity<ResponseStructure<Owner>> deleteOwner(int ownerid) {
    	Owner owner = ownerdao.fetchbyOwnerid(ownerid);
    	if(owner!=null) {
    	responseStructure.setStatusCode(HttpStatus.OK.value());
    	responseStructure.setMessage("Sucessfully owner Deleted From DB");
    	responseStructure.setData(ownerdao.deleteOwner(ownerid));
    	return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
    	}else {
    		throw new OwnerIdNotFound();
    	}
    }
    public ResponseEntity<ResponseStructure1<Owner>> fetchOwners(){
    	responseStructure1.setStatusCode(HttpStatus.FOUND.value());
    	responseStructure1.setMessage("Sucessfully  Fetched ALL owners  From DB");
    	responseStructure1.setData(ownerdao.fetchOwners());
    	return new ResponseEntity<ResponseStructure1<Owner>>(responseStructure1,HttpStatus.FOUND);
    
    }
    public ResponseEntity<ResponseStructure<Owner>> addExistingRestaurantToExisting(int ownerid,int restaurantid) {
    	Owner owner = ownerdao.fetchbyOwnerid(ownerid);
    	Restaurant restaurant  =  restaurantDao.findBYRestaurantId(restaurantid);
        Restaurant restaurant2=owner.getRestaurant();
        if(restaurant2.getRestaurantId()==restaurantid) {
	    	throw new EnteredDuplicateEntries();
        }
    	if(owner!=null && restaurant!=null) {
    	responseStructure.setStatusCode(HttpStatus.OK.value());
    	responseStructure.setMessage("Sucessfully added Existing Restaurant To Existing Owner  From DB");
    	responseStructure.setData(ownerdao.addExistingRestaurantToExisting(ownerid, restaurantid));
    	return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
    		}else if(restaurant==null) {
    		throw new RestaurantNotFound();
		}else {
    		throw new OwnerIdNotFound();
    	}	
    	
    }
    
    public ResponseEntity<ResponseStructure<Owner>> addNewRestaurantToExistingOwner(int ownerid,Restaurant newrestaurant) {
    	Owner owner = ownerdao.fetchbyOwnerid(ownerid);
    	Restaurant restaurant  =  restaurantDao.saveRestaurant(newrestaurant);
    	if(owner!=null && restaurant!=null) {
    	responseStructure.setStatusCode(HttpStatus.OK.value());
    	responseStructure.setMessage("Sucessfully adding new Restaurant To Existing Owner  From DB");
    	responseStructure.setData(ownerdao.addNewRestaurantToExistingOwner(ownerid, restaurant));
    	return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);	
    }
    else {
		throw new OwnerIdNotFound();
	}
    }
}
