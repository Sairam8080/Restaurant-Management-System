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

import com.qsp.restaurant_management_system.dto.Owner;
import com.qsp.restaurant_management_system.dto.Restaurant;
import com.qsp.restaurant_management_system.service.OwnerService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@RestController
public class OwnerController {
     @Autowired
	OwnerService ownerService;
     
     @PostMapping("/saveOwner")
     public ResponseEntity<ResponseStructure<Owner>> saveOwner( @RequestBody Owner owner ) {
    	 return ownerService.saveOwner(owner);
     }
   @GetMapping("/fetchbyOwnerid")
     public ResponseEntity<ResponseStructure<Owner>> fetchbyOwnerid(@RequestParam int ownerid) {
     	return ownerService.fetchbyOwnerid(ownerid);
     }
   
     @PutMapping("/updateOwner")
     public ResponseEntity<ResponseStructure<Owner>> updateOwner(@RequestParam  int oldOwnerId,@RequestBody Owner newOwner) {
     	return ownerService.updateOwner(oldOwnerId, newOwner);
     }
     @DeleteMapping("/deleteOwner")
     public ResponseEntity<ResponseStructure<Owner>> deleteOwner(@RequestParam int ownerid) {
     	 return ownerService.deleteOwner(ownerid);
     }
   @GetMapping("/fetchOwners")
     public ResponseEntity<ResponseStructure1<Owner>> fetchOwners(){
     	return ownerService.fetchOwners();
     }
   @PutMapping("/addExistingRestaurantToExisting")
   public ResponseEntity<ResponseStructure<Owner>> addExistingRestaurantToExisting(@RequestParam int ownerid,@RequestParam int restaurantid) {
	   return ownerService.addExistingRestaurantToExisting(ownerid, restaurantid);
   }
   @PutMapping("/addNewRestaurantToExistingOwner")
   public ResponseEntity<ResponseStructure<Owner>> addNewRestaurantToExistingOwner(@RequestParam int ownerid,@RequestBody Restaurant restaurant) {
   	return ownerService.addNewRestaurantToExistingOwner(ownerid, restaurant);
   }

     
}
