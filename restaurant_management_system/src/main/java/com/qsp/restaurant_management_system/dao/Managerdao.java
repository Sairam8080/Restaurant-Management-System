package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Manager;
import com.qsp.restaurant_management_system.repo.ManagerRepo;

@Repository
public class Managerdao {
	@Autowired
	ManagerRepo managerRepo;
	
	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}
	public Manager fetchbyManagerId(int managerId) {
		
		Optional<Manager>manager= managerRepo.findById( managerId);
		if(manager.isPresent()) {
			return manager.get();
		}
		return null;
	}
	public Manager updateManager(Manager newmanager,int Oldmanagerid) {
		    newmanager.setManagerId(Oldmanagerid);
		return managerRepo.save(newmanager);
	}
	public Manager deleteManager(int managerid) {
		Manager manager = managerRepo.findById(managerid).get();
		managerRepo.delete(manager);
		return manager;
	}
	public List<Manager> fetchallManagers(){
		return managerRepo.findAll();
	}

}
