package com.qsp.restaurant_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import com.qsp.restaurant_management_system.dao.Addressdao;
import com.qsp.restaurant_management_system.dao.Branchdao;
import com.qsp.restaurant_management_system.dao.Customerdao;
import com.qsp.restaurant_management_system.dao.Employeedao;
import com.qsp.restaurant_management_system.dao.Managerdao;
import com.qsp.restaurant_management_system.dao.Menudao;
import com.qsp.restaurant_management_system.dto.Address;
import com.qsp.restaurant_management_system.dto.Branch;
import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.Employee;
import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.Manager;
import com.qsp.restaurant_management_system.dto.Menu;
import com.qsp.restaurant_management_system.exception.AddressNotFound;
import com.qsp.restaurant_management_system.exception.BranchNotFound;
import com.qsp.restaurant_management_system.exception.CustomerNotFound;
import com.qsp.restaurant_management_system.exception.EmployeeNotFound;
import com.qsp.restaurant_management_system.exception.EnteredDuplicateEntries;
import com.qsp.restaurant_management_system.exception.ManagerNotFound;
import com.qsp.restaurant_management_system.exception.MenuNotFound;
import com.qsp.restaurant_management_system.exception.OwnerIdNotFound;
import com.qsp.restaurant_management_system.repo.AddressRepo;
import com.qsp.restaurant_management_system.repo.BranchRepo;
import com.qsp.restaurant_management_system.repo.CustomerRepo;
import com.qsp.restaurant_management_system.repo.ManagerRepo;
import com.qsp.restaurant_management_system.repo.MenuRepo;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@Service
public class BranchService {

	@Autowired
	Branchdao branchdao;
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
	@Autowired
	BranchRepo  branchRepo;
	
	@Autowired
	ResponseStructure<Branch> responseStructure;
	@Autowired
	ResponseStructure1<Branch> responseStructure1;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Sucessfully inserted Branch into DB");
		responseStructure.setData(branchdao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Branch>> fetchbyBranchId(int branchId) {
		Branch branch = branchdao.fetchbyBranchId(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Sucessfully Fetch branch into DB");
			responseStructure.setData(branchdao.fetchbyBranchId(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new BranchNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch newbranch, int oldBranchId) {
		Branch branch = branchdao.fetchbyBranchId(oldBranchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Sucessfully updated brach from DB");
			responseStructure.setData(branchdao.updateBranch(newbranch, oldBranchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int branchId) {
		Branch branch = branchdao.fetchbyBranchId(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Sucessfully Deleted brach from DB");
			responseStructure.setData(branchdao.deleteBranch(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchNotFound();
		}

	}

	public ResponseEntity<ResponseStructure1<Branch>> fetchAllBranches() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Sucessfully Fetched All brach from DB");
		responseStructure1.setData(branchdao.fetchAllBranches());
		return new ResponseEntity<ResponseStructure1<Branch>>(responseStructure1, HttpStatus.FOUND);

	}

	public ResponseEntity<ResponseStructure<Branch>> AddExistingManagertoExistingBranch(int managerid, int branchid) {
		Branch branch = branchdao.fetchbyBranchId(branchid);
		Manager manager = managerdao.fetchbyManagerId(managerid);
		List<Branch> listBranch=branchdao.fetchAllBranches();
		Manager linkedmanager = branch.getManager();
		if(branch != null && manager != null) {
			for(Branch branch1 :listBranch) {
				 if(branch1.getManager().getManagerId()==managerid) {
				    	throw new EnteredDuplicateEntries();
				    }
				  else 
				    {
					responseStructure.setStatusCode(HttpStatus.OK.value());
					responseStructure.setMessage("Sucessfully Added Existing Manager toExisting Branchfrom DB");
					responseStructure.setData(branchdao.AddExistingManagertoExistingBranch(managerid, branchid));
					return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
				    }
		     	}
			}
		     else if(manager==null){
			throw new ManagerNotFound();
		}
		throw new BranchNotFound();
	}
	
	public ResponseEntity<ResponseStructure<Branch>> AddingNewManagerToExistingBranch(int branchid,Manager newmanager) {
		Branch branch = branchdao.fetchbyBranchId(branchid);
		Manager manager = managerdao.saveManager(newmanager);
		if (branch != null && manager != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Sucessfully Added New Manager toExisting Branch from DB");
			responseStructure.setData(branchdao.AddingNewManagerToExistingBranch(branchid, newmanager));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> AddingExstingAddressToExsistingBranch(int brachid, int addressId) {
		Branch branch = branchdao.fetchbyBranchId(brachid);
		Address address = addressdao.fetchAddress(addressId);
		Address address2 = branch.getAddress();
		if(address2.getAddressId()==addressId) {
			throw new EnteredDuplicateEntries();
		}
		if (branch != null && address != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Sucessfully Added Exsting Address toExisting Branch from DB");
			responseStructure.setData(branchdao.AddingExstingAddressToExsistingBranch(brachid, addressId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			}
		 else if(branch==null){
			throw new BranchNotFound();
		}else {
			throw new AddressNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> AddnewAddresstoExistingBranch(int branchid, Address newaddress) {
		Branch branch = branchdao.fetchbyBranchId(branchid);
		Address address = addressdao.saveAddress(newaddress);
		if (branch != null && address != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Sucessfully Added new Address to Existing Branch from DB");
			responseStructure.setData(branchdao.AddnewAddresstoExistingBranch(branchid, newaddress));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> AddingMenuToExistingBranch(int branchid, int menuid) {
		Branch branch = branchdao.fetchbyBranchId(branchid);
		Menu menu = menudao.fetchbiMenuId(menuid);
		Menu menu2 = branch.getMenu();
		if(menu2.getMenuid()==menuid) {
			throw new EnteredDuplicateEntries();
		}
		 if (branch != null && menu != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Sucessfully Added  Existing Menu Existing Branch from DB");
			responseStructure.setData(branchdao.AddingMenuToExistingBranch(branchid, menuid));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			}
		 else if(branch==null){
			throw new BranchNotFound();
		} else {
			throw new MenuNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> AddingNewMenuToExistingBranch(int branchid, Menu newmenu) {
		Branch branch = branchdao.fetchbyBranchId(branchid);
		Menu menu = menudao.saveMenu(newmenu);
		if (branch != null && menu != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Sucessfully Added new Adding Menu Existing Branch from DB");
			responseStructure.setData(branchdao.AddingNewMenuToExistingBranch(branchid, newmenu));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchNotFound();
		}

	}

	public ResponseEntity<ResponseStructure<Branch>> AddingExistingCustomerToExistingBranch(int customerId,int branchid) {
		Branch branch = branchdao.fetchbyBranchId(branchid);
		Customer customer = customerdao.fetchbyCustomerId(customerId);
		List<Customer>customers= branch.getCustomer();
		for(Customer customer2 :customers) {
			if(customer2.getCustomerId()==customerId) {
				throw new EnteredDuplicateEntries();
			}
		}
		if (branch != null && customer != null) { 
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Sucessfully Added Existing customer tO Existing Branch from DB");
			responseStructure.setData(branchdao.AddingExistingCustomerToExistingBranch(customerId, branchid));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}else if(branch==null) {
			throw new BranchNotFound();
		}
		else {
			throw new CustomerNotFound();
		}

	}

	public ResponseEntity<ResponseStructure<Branch>> AddingNewCustomerToExistingBranch(int branchid,Customer newcustomer) {
		Branch branch = branchdao.fetchbyBranchId(branchid);
		Customer customer = customerdao.saveCustomer(newcustomer);
		if (branch != null && customer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Sucessfully Added New customer to Existing Branch from DB");
			responseStructure.setData(branchdao.AddingNewCustomerToExistingBranch(branchid, newcustomer));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}else if(branch==null) {
			throw new BranchNotFound();
		}
		else {
			throw new CustomerNotFound();
		}

	}

	public ResponseEntity<ResponseStructure<Branch>> AddingNewEmployeeTOExsistingBranch(int branchid,Employee newemployee) {
		Branch branch = branchdao.fetchbyBranchId(branchid);
		Employee employee = employeedao.saveEmployee(newemployee);
		
		if (branch != null && employee != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Sucessfully Added New Employee to Existing Branch from DB");
			responseStructure.setData(branchdao.AddingNewEmployeeTOExsistingBranch(branchid, newemployee));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}if(branch==null) {
			throw new BranchNotFound();
		}
		else {
			throw new EmployeeNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> AddingExistingEmployeeToExstingBranch(int branchid,int employeeid) {
		Branch branch = branchdao.fetchbyBranchId(branchid);
		Employee employee = employeedao.fecthByEmployeeID(employeeid);
		List<Employee>employees=branch.getEmployee();
		for(Employee employee2:employees) {
			if(employee2.getEmployeId()==employeeid) {
				throw new EnteredDuplicateEntries();
			}
		}
		
		if (branch != null && employee != null) {
		 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Added Existing Employee to Existing Branch from DB");
	    	responseStructure.setData(branchdao.AddingExistingEmployeeToExstingBranch(branchid, employeeid));
	    	return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			}
	      else if(branch==null) {
			throw new BranchNotFound();
		}
		else

	{
			throw new EmployeeNotFound();
	
	}

}}
