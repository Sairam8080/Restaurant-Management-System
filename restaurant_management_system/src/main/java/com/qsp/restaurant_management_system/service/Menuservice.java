package com.qsp.restaurant_management_system.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.Fooddao;
import com.qsp.restaurant_management_system.dao.Menudao;
import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.Menu;
import com.qsp.restaurant_management_system.exception.BranchNotFound;
import com.qsp.restaurant_management_system.exception.EnteredDuplicateEntries;
import com.qsp.restaurant_management_system.exception.FoodOrderNotFound;
import com.qsp.restaurant_management_system.exception.MenuNotFound;
import com.qsp.restaurant_management_system.exception.OwnerIdNotFound;
import com.qsp.restaurant_management_system.repo.MenuRepo;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@Service
public class Menuservice {
	@Autowired
	Menudao menudao;
	@Autowired
	Fooddao fooddao;
	@Autowired
	MenuRepo menuRepo;
	@Autowired
    ResponseStructure<Menu> responseStructure;
	@Autowired
	ResponseStructure1<Menu> responseStructure1;
	
	 public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		
		 responseStructure.setStatusCode(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Sucessfully inserted Menu into DB");
	    	responseStructure.setData(menudao.saveMenu(menu));
	    	return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.CREATED);
	}
	 public ResponseEntity<ResponseStructure<Menu>> fetchbiMenuId(int menuId) {
		Menu menu =menudao.fetchbiMenuId(menuId);
		if(menu!=null) {
		 responseStructure.setStatusCode(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Sucessfully Updated Menu into DB");
	    	responseStructure.setData(menudao.fetchbiMenuId(menuId));
	    	return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.FOUND);
		  } else {
				throw new MenuNotFound();
			}
	 }
	 public ResponseEntity<ResponseStructure<Menu>> updateMenu(Menu newmenu,int oldmenuid) {
		 Menu menu =menudao.fetchbiMenuId(oldmenuid);
			if(menu!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Updated Menu From DB");
	    	responseStructure.setData(menudao.updateMenu(newmenu, oldmenuid));
	    	return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
			 } else {
					throw new MenuNotFound();
				}
	 }
	 public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int menuId) {
		 Menu menu =menudao.fetchbiMenuId(menuId);
			if(menu!=null) {
		 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Deleted Menu From DB");
	    	responseStructure.setData(menudao.deleteMenu(menuId));
	    	return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
			 } else {
					throw new MenuNotFound();
				}
	 }
	 public ResponseEntity<ResponseStructure1<Menu>> fetchallMenus(){
		 responseStructure1.setStatusCode(HttpStatus.FOUND.value());
	    	responseStructure1.setMessage("Sucessfully Fetched all Menues From DB");
	    	responseStructure1.setData(menudao.fetchallMenus());
	    	return new ResponseEntity<ResponseStructure1<Menu>>(responseStructure1,HttpStatus.FOUND);
	 }
	   public ResponseEntity<ResponseStructure<Menu>> AddingExistingFoodtoExsistingmenu(int foodid,int menuid) {
		   Menu menu =menudao.fetchbiMenuId(menuid);
		    Food food= fooddao.fetchByFoodId(foodid);
		     List<Food>foods=menu.getFood();
		     for(Food food2:foods) {
		    	if(food2.getFoodId()==foodid) {
			    	throw new EnteredDuplicateEntries();
		    	}
		     }
			if(menu!=null&&food!=null) { 		
		   responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Added Existing Food to Existing Menu from DB");
	    	responseStructure.setData(menudao.AddingExistingFoodtoExsistingmenu(foodid, menuid));
	    	return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
				 }else if(food==null) {
					 throw new FoodOrderNotFound();
				} else {
					throw new MenuNotFound();
				}
	   }
	   public ResponseEntity<ResponseStructure<Menu>> AddingNewFoodToExistingMenu(int menuid,Food newfood) {
		   Menu menu =menudao.fetchbiMenuId(menuid);
			if(menu!=null) {
		   responseStructure.setStatusCode(HttpStatus.OK.value());
	    	responseStructure.setMessage("Sucessfully Added New Food to Existing Menu from DB");
	    	responseStructure.setData(menudao.AddingNewFoodToExistingMenu(menuid, newfood));
	    	return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
			 } else {
					throw new MenuNotFound();
				}
	   }

}
