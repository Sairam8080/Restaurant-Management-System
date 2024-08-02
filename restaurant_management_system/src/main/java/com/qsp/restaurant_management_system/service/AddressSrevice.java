package com.qsp.restaurant_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.Addressdao;
import com.qsp.restaurant_management_system.dto.Address;
import com.qsp.restaurant_management_system.exception.AddressNotFound;
import com.qsp.restaurant_management_system.exception.OwnerIdNotFound;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@Service
public class AddressSrevice {

	@Autowired
	Addressdao addressdao;
	@Autowired
    ResponseStructure<Address> responseStructure;
	@Autowired
	ResponseStructure1<Address> responseStructure1;
	
	  public ResponseEntity< ResponseStructure<Address>> saveAddress(Address address) {
		  responseStructure.setStatusCode(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Sucessfully inserted Address into DB");
	    	responseStructure.setData(addressdao.saveAddress(address));
	    	return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	    
	    }
	    public ResponseEntity<ResponseStructure<Address>> fetchAddress(int addressid) {
	    	Address address= addressdao.fetchAddress(addressid );
	    	if(address!=null){
	    	  responseStructure.setStatusCode(HttpStatus.FOUND.value());
		    	responseStructure.setMessage("Sucessfully Fetched Address From DB");
		    	responseStructure.setData(addressdao.fetchAddress(addressid));
		    	return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
	    	}else {
	    		throw new AddressNotFound();
	    	}
	    	
	    }
	    public ResponseEntity<ResponseStructure<Address>> updateAddress(int oldAddressId,Address newaddress) {
	    	Address address= addressdao.fetchAddress(oldAddressId );
	    	if(address!=null){
	  	  responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully updated Address From DB");
	    	responseStructure.setData(addressdao.updateAddress(oldAddressId, newaddress));
	    	return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
	    	}else {
	    		throw new AddressNotFound();
	    	}
	    
	    }
	    public ResponseEntity<ResponseStructure<Address>> deleteAddress(int addressId) {
	    	Address address= addressdao.fetchAddress(addressId );
	    	if(address!=null){
	    	 responseStructure.setStatusCode(HttpStatus.OK.value());
		    	responseStructure.setMessage("Sucessfully Deleted Address From DB");
		    	responseStructure.setData(addressdao.deleteAddress(addressId));
		    	return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
	    	}else {
	    		throw new AddressNotFound();
	    	}
	    }
	    public ResponseEntity<ResponseStructure1<Address>> fetchalladdress () {
	    	 responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		    	responseStructure1.setMessage("Sucessfully FetchEd All Address From DB");
		    	responseStructure1.setData(addressdao.fetchalladdress());
		    	return new ResponseEntity<ResponseStructure1<Address>>(responseStructure1,HttpStatus.FOUND);
	    	
	    }
}
