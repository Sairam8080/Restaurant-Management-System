package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.repo.CustomerRepo;

@Repository
public class Customerdao {
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	FoodOrderdao foodOrderdao;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	public Customer fetchbyCustomerId(int customerid) {
		Optional<Customer> customer= customerRepo.findById(customerid);
		if(customer.isPresent()) {
			return customer.get();
		}
	return null;
	}
	public Customer updateCustomer(Customer newcustomer,int oldCustomerId) {
		newcustomer.setCustomerId(oldCustomerId);
		return customerRepo.save(newcustomer);
	}
	public Customer deleteCustomer(int deleteId) {
		Customer customer = customerRepo.findById(deleteId).get();
		customerRepo.delete(customer);
		return customer;
	}
	public List<Customer> fetchallCustomers (){
		return customerRepo.findAll();
	}
    public Customer AddExistingFoodOrderToExistingCustomer(int foodorderid,int customerid) {
    	   Customer customer=fetchbyCustomerId(customerid);
    	       FoodOrder foodOrder= foodOrderdao.fetchbiFoodOrderId(foodorderid);
    	       List<FoodOrder>list = customer.getFoodOrders();
    	       list.add(foodOrder);
    	       customer.setFoodOrders(list);
    	       return saveCustomer(customer);
    }
    public Customer AddNewFooodOrderToExistingCustomer(int customerid,FoodOrder newfoodOrder) {
    	  Customer customer=fetchbyCustomerId(customerid);
	       FoodOrder foodOrder= foodOrderdao.savefoodOrder(newfoodOrder);
	       List<FoodOrder>list = customer.getFoodOrders();
	       list.add(foodOrder);
	       customer.setFoodOrders(list);
	       return saveCustomer(customer);
    }
}
