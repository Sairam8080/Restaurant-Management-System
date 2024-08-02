package com.qsp.restaurant_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.Managerdao;
import com.qsp.restaurant_management_system.dto.Manager;
import com.qsp.restaurant_management_system.exception.ManagerNotFound;
import com.qsp.restaurant_management_system.exception.OwnerIdNotFound;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@Service
public class ManagerService {

	@Autowired
	Managerdao managerdao;
	@Autowired
    ResponseStructure<Manager> responseStructure;
	@Autowired
	ResponseStructure1<Manager> responseStructure1;
	
	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager manager) {
		 responseStructure.setStatusCode(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Sucessfully inserted Food into DB");
	    	responseStructure.setData(managerdao.saveManager(manager));
	    	return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Manager>> fetchbyManagerId(int managerId) {
		      Manager manager= managerdao.fetchbyManagerId(managerId);
		      if(manager!=null) {
		 responseStructure.setStatusCode(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Sucessfully Updated Manager into DB");
	    	responseStructure.setData(managerdao.fetchbyManagerId(managerId));
	    	return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.FOUND);
		      } else {
					throw new ManagerNotFound();
				}
	}
	public ResponseEntity<ResponseStructure<Manager>> updateManager(Manager newmanager,int Oldmanagerid) {
		 Manager manager= managerdao.fetchbyManagerId(Oldmanagerid);
	      if(manager!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
    	responseStructure.setMessage("Sucessfully Updated Manager From DB");
    	responseStructure.setData(managerdao.updateManager(newmanager, Oldmanagerid));
    	return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
	      } else {
				throw new ManagerNotFound();
			}
	}
	public ResponseEntity<ResponseStructure<Manager>> deleteManager(int managerid) {
		 Manager manager= managerdao.fetchbyManagerId(managerid);
	      if(manager!=null) {
		 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Deleted Manager From DB");
	    	responseStructure.setData(managerdao.deleteManager(managerid));
	    	return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
	      } else {
				throw new ManagerNotFound();
			}
	}
	public ResponseEntity<ResponseStructure1<Manager>> fetchallManagers(){
		 responseStructure1.setStatusCode(HttpStatus.FOUND.value());
	    	responseStructure1.setMessage("Sucessfully Fetched all Manager From DB");
	    	responseStructure1.setData(managerdao.fetchallManagers());
	    	return new ResponseEntity<ResponseStructure1<Manager>>(responseStructure1, HttpStatus.FOUND);
	}
}
