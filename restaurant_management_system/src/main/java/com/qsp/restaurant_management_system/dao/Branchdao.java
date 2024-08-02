package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Address;
import com.qsp.restaurant_management_system.dto.Branch;
import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.Employee;
import com.qsp.restaurant_management_system.dto.Manager;
import com.qsp.restaurant_management_system.dto.Menu;
import com.qsp.restaurant_management_system.exception.BranchNotFound;
import com.qsp.restaurant_management_system.exception.EnteredDuplicateEntries;
import com.qsp.restaurant_management_system.repo.BranchRepo;


@Repository
public class Branchdao {
	@Autowired
	BranchRepo branchRepo;
	@Autowired
	Managerdao managerdao;
	@Autowired
	Addressdao addressdao;
	@Autowired
	Menudao menudao;
	@Autowired
	Customerdao customerdao;
	@Autowired
	Employeedao employeedao;
	
	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}
	public Branch fetchbyBranchId(int branchId) {
		Optional<Branch>  branch=branchRepo.findById(branchId);
		if(branch.isPresent()) {
			return branch.get();
		}
		throw new BranchNotFound();
	}
	public Branch updateBranch(Branch newbranch,int oldBranchId) {
		      newbranch.setBranchId(oldBranchId);
		      return branchRepo.save(newbranch);
	}
	public Branch deleteBranch(int branchId) {
		Branch branch = branchRepo.findById(branchId).get();
		branchRepo.delete(branch);
		return branch;
	}
	public List<Branch> fetchAllBranches(){
		return branchRepo.findAll();
	}
	public  Branch AddExistingManagertoExistingBranch(int managerid,int branchid) {
		        Branch branch=fetchbyBranchId(branchid);
		             Manager manager = managerdao.fetchbyManagerId(managerid);
		             branch.setManager(manager);
		             return saveBranch(branch);
		                  
	}
	public Branch AddingNewManagerToExistingBranch(int branchid,Manager manager) {
		     Branch branch =fetchbyBranchId(branchid);
		     branch.setManager(manager);
		     return saveBranch(branch);
	}
	public Branch AddingExstingAddressToExsistingBranch(int brachid,int addressId) {
		 Branch branch = fetchbyBranchId(brachid);
		           Address address= addressdao.fetchAddress(addressId);
		           branch.setAddress(address);
		           return saveBranch(branch);
	}
	public Branch AddnewAddresstoExistingBranch(int branchid , Address address) {
		       Branch branch = fetchbyBranchId(branchid);
		                branch.setAddress(address);
		                return saveBranch(branch);
	}
	public Branch AddingMenuToExistingBranch(int branchid,int menuid) {
		Branch branch = fetchbyBranchId(branchid);
		     Menu menu= menudao.fetchbiMenuId(menuid);
		     branch.setMenu(menu);
		return saveBranch(branch);
	}
	public Branch AddingNewMenuToExistingBranch(int branchid,Menu menu) {
		 Branch branch = fetchbyBranchId(branchid);
         branch.setMenu(menu);
         return saveBranch(branch);
	}
	public Branch AddingExistingCustomerToExistingBranch(int customerId,int branchid) {
		 Branch branch = fetchbyBranchId(branchid);
		  Customer customer   = customerdao.fetchbyCustomerId(customerId);
		  List<Customer> list = branch.getCustomer();
		  list.add(customer);
		  branch.setCustomer(list);
		  return saveBranch(branch);
		          
	}
	public Branch AddingNewCustomerToExistingBranch(int branchid,Customer newcustomer ) {
		Branch branch = fetchbyBranchId(branchid);
		  Customer customer   = customerdao.saveCustomer(newcustomer);
		  List<Customer> list = branch.getCustomer();
		  list.add( customer);
		  branch.setCustomer(list);
		  return saveBranch(branch);
	}
	public Branch AddingExistingEmployeeToExstingBranch(int branchid,int employeeid) {
		Branch branch = fetchbyBranchId(branchid);
		      Employee employee =employeedao.fecthByEmployeeID(branchid);
		      List<Employee> list = branch.getEmployee();
		      list.add(employee);
		      branch.setEmployee(list);
		      return saveBranch(branch);
	}
	public Branch AddingNewEmployeeTOExsistingBranch(int branchid,Employee newemployee) {
		Branch branch = fetchbyBranchId(branchid);
	      Employee employee =employeedao.saveEmployee(newemployee);
	      List<Employee> list = branch.getEmployee();
	      list.add(employee);
	      branch.setEmployee(list);
	      return saveBranch(branch);
	}

}
