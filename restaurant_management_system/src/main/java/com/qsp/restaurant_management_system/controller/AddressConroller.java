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

import com.qsp.restaurant_management_system.dto.Address;
import com.qsp.restaurant_management_system.service.AddressSrevice;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@RestController
public class AddressConroller {
	
	@Autowired
	AddressSrevice addressSrevice;
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressSrevice.saveAddress(address);
	}
	@GetMapping("/fetchAddress")
	public ResponseEntity<ResponseStructure<Address>> fetchAddress(@RequestParam int addressid) {
		return addressSrevice.fetchAddress(addressid);
	}
	@PutMapping("/updateAddress")
	 public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int oldAddressId,@RequestBody Address newaddress) {
		return addressSrevice.updateAddress(oldAddressId, newaddress);
	}
     @DeleteMapping("/deleteAddress")
	  public ResponseEntity<ResponseStructure<Address>> deleteaddress (@RequestParam int addressId){
		  return addressSrevice.deleteAddress(addressId);
	  }
     @GetMapping("/fetchalladdress")
     public ResponseEntity<ResponseStructure1<Address>> fetchalladdress  (){
    	 return addressSrevice.fetchalladdress();
     }
}
