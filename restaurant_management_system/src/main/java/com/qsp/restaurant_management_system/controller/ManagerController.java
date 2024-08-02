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

import com.qsp.restaurant_management_system.dto.Manager;
import com.qsp.restaurant_management_system.service.ManagerService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;


@RestController
public class ManagerController {
   @Autowired
	ManagerService managerService;
   
   @PostMapping("/saveManager")
   public ResponseEntity<ResponseStructure<Manager>> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}
   @GetMapping("/fetchbyManagerId")
	public ResponseEntity<ResponseStructure<Manager>> fetchbyManagerId(@RequestParam int managerId) {
		return managerService.fetchbyManagerId(managerId);
	}
   @PutMapping("/updateManager")
	public ResponseEntity<ResponseStructure<Manager>> updateManager(@RequestBody Manager newmanager,@RequestParam int Oldmanagerid) {
		return managerService.updateManager(newmanager, Oldmanagerid);
	}
   @DeleteMapping("/deleteManager")
	public ResponseEntity<ResponseStructure<Manager>> deleteManager(@RequestParam int managerid) {
		return managerService.deleteManager(managerid);
	}
   @GetMapping("/fetchallManagers")
	public ResponseEntity<ResponseStructure1<Manager>> fetchallManagers(){
		return managerService.fetchallManagers();
	}
}
