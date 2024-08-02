package com.qsp.restaurant_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.restaurant_management_system.dto.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer>{

}
