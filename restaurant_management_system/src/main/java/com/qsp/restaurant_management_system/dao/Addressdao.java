package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Address;
import com.qsp.restaurant_management_system.repo.AddressRepo;

@Repository
public class Addressdao {
    @Autowired
	AddressRepo addressRepo;
	
    public Address saveAddress(Address address) {
    	return addressRepo.save(address);
    }
    public Address fetchAddress(int addressid) {
    	
    	 Optional<Address> address = addressRepo.findById(addressid);
    	 if(address.isPresent()) {
    		 return address.get();
    	 }
    	 return null;
    }
    
    public Address updateAddress(int oldAddressId,Address newaddress) {
    	newaddress.setAddressId(oldAddressId);
    	return addressRepo.save(newaddress);
    }
    public Address deleteAddress(int addressId) {
     Address address=addressRepo.findById(addressId).get();
               addressRepo.delete(address);
    	return address;
    }
    public List<Address> fetchalladdress (){
    	return addressRepo.findAll();
    }
    
    
	
}
