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
import com.qsp.restaurant_management_system.dto.Branch;
import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.Employee;
import com.qsp.restaurant_management_system.dto.Manager;
import com.qsp.restaurant_management_system.dto.Menu;
import com.qsp.restaurant_management_system.service.BranchService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@RestController
public class BranchController {
    @Autowired
	BranchService branchService;
    @PostMapping("/saveBranch")
    public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
    	return branchService.saveBranch(branch);
    }
    
    @GetMapping("/fetchbyBranchId")
    public ResponseEntity<ResponseStructure<Branch>> fetchbyBranchId(@RequestParam int branchId) {
    	return branchService.fetchbyBranchId(branchId);
    }
    @PutMapping("/updateBranch")
    public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch newbranch,@RequestParam int oldBranchId) {
    	return branchService.updateBranch(newbranch, oldBranchId);
    }
    @DeleteMapping("/deleteBranch")
    public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int branchId) {
    	return branchService.deleteBranch(branchId);
    }
    @GetMapping("/fetchAllBranches")
    public ResponseEntity<ResponseStructure1<Branch>> fetchAllBranches(){
    	return branchService.fetchAllBranches();
    }
    @PutMapping("/AddExistingManagertoExistingBranch")
    public  ResponseEntity<ResponseStructure<Branch>> AddExistingManagertoExistingBranch(@RequestParam int managerid,@RequestParam int branchid) {
    	return branchService.AddExistingManagertoExistingBranch(managerid, branchid);
    }
    @PutMapping("/AddingNewManagerToExistingBranch")
    public ResponseEntity<ResponseStructure<Branch>> AddingNewManagerToExistingBranch(@RequestParam int branchid,@RequestBody Manager manager) {
    	return branchService.AddingNewManagerToExistingBranch(branchid, manager);
    }
    @PutMapping("/AddingExstingAddressToExsistingBranch")
    public ResponseEntity<ResponseStructure<Branch>> AddingExstingAddressToExsistingBranch(@RequestParam int brachid,@RequestParam int addressId) {
    	return branchService.AddingExstingAddressToExsistingBranch(brachid, addressId);
    }
    @PutMapping("/AddnewAddresstoExistingBranch")
    public ResponseEntity<ResponseStructure<Branch>> AddnewAddresstoExistingBranch(@RequestParam int branchid ,@RequestBody Address address) {
    	return branchService.AddnewAddresstoExistingBranch(branchid, address);
    }
    @PutMapping("/AddingMenuToExistingBranch")
    public ResponseEntity<ResponseStructure<Branch>> AddingMenuToExistingBranch(@RequestParam int branchid,@RequestParam int menuid) {
    	return branchService.AddingMenuToExistingBranch(branchid, menuid);
    }
    
    @PutMapping("/AddingNewMenuToExistingBranch")
    public ResponseEntity<ResponseStructure<Branch>> AddingNewMenuToExistingBranch(@RequestParam int branchid,@RequestBody Menu menu) {
    	return branchService.AddingNewMenuToExistingBranch(branchid, menu);
    }
    @PutMapping("/AddingExistingCustomerToExistingBranch")
    public ResponseEntity<ResponseStructure<Branch>> AddingExistingCustomerToExistingBranch(@RequestParam int customerId,@RequestParam int branchid) {
		return branchService.AddingExistingCustomerToExistingBranch(customerId, branchid);
	}
    @PutMapping("/AddingNewCustomerToExistingBranch")
    public ResponseEntity<ResponseStructure<Branch>> AddingNewCustomerToExistingBranch(@RequestParam int branchid,@RequestBody Customer newcustomer ) {
    	return branchService.AddingNewCustomerToExistingBranch(branchid, newcustomer);
    }
    @PutMapping("/AddingNewEmployeeTOExsistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> AddingNewEmployeeTOExsistingBranch(@RequestParam int branchid,@RequestBody Employee newemployee) {
		return branchService.AddingNewEmployeeTOExsistingBranch(branchid, newemployee);
	}
    @PutMapping("/AddingExistingEmployeeToExstingBranch")
	public ResponseEntity<ResponseStructure<Branch>> AddingExistingEmployeeToExstingBranch(@RequestParam int branchid,@RequestParam int employeeid) {
        return  branchService.AddingExistingEmployeeToExstingBranch(branchid, employeeid);
	}
}
