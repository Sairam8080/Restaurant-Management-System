package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Owner;
import com.qsp.restaurant_management_system.dto.Restaurant;
import com.qsp.restaurant_management_system.repo.OwnerRepo;

@Repository
public class Ownerdao {
    @Autowired
	OwnerRepo ownerRepo;
    @Autowired
    RestaurantDao restaurantDao;
    
    public Owner saveOwner(Owner owner ) {
    	return ownerRepo.save(owner);
    }
    public Owner fetchbyOwnerid(int ownerid) {
    	
    	Optional<Owner> owner= ownerRepo.findById(ownerid);
    	if(owner.isPresent() ) {
    		return owner.get();
    	}
    	return null;
    }
    public Owner updateOwner(int oldOwnerId,Owner newOwner) {
    	newOwner.setOwnerId(oldOwnerId);
    	return ownerRepo.save(newOwner);
    }
    public Owner deleteOwner(int ownerid) {
    	   Owner owner =ownerRepo.findById(ownerid).get();
    	   ownerRepo.delete(owner);
    	   return owner;
    }
    public List<Owner> fetchOwners(){
    	return ownerRepo.findAll();
    }
    
   public Owner addExistingRestaurantToExisting(int ownerid,int restaurantid) {
	   
	        Owner owner=fetchbyOwnerid(ownerid);
	                Restaurant restaurant  =restaurantDao.findBYRestaurantId(restaurantid);
	                owner.setRestaurant(restaurant);
	                return saveOwner(owner);
   }
   
    public Owner addNewRestaurantToExistingOwner(int ownerid,Restaurant restaurant) {
    	  Owner owner  =fetchbyOwnerid(ownerid);
    	  owner.setRestaurant(restaurant);
    	  return saveOwner(owner);
    }
    
}
