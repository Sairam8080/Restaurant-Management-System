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

import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.Menu;
import com.qsp.restaurant_management_system.service.Menuservice;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructure1;

@RestController
public class MenuController {
    @Autowired
	Menuservice menuservice;
    @PostMapping("/saveMenu")
    public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu) {
		return menuservice.saveMenu(menu);
	}
    @GetMapping("/fetchbiMenuId")
	 public ResponseEntity<ResponseStructure<Menu>> fetchbiMenuId(@RequestParam int menuId) {
		 return menuservice.fetchbiMenuId(menuId);
	 }
    @PutMapping("/updateMenu")
	 public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestBody Menu newmenu,@RequestParam int oldmenuid) {
		 return menuservice.updateMenu(newmenu, oldmenuid);
	 }
    @DeleteMapping("/deleteMenu")
	 public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@RequestParam int menuId) {
		 return  menuservice.deleteMenu(menuId);
	 }
    @GetMapping("/fetchallMenus")
	 public ResponseEntity<ResponseStructure1<Menu>> fetchallMenus(){
		 return menuservice.fetchallMenus();

}   @PutMapping("/AddingExistingFoodtoExsistingmenu")
    public ResponseEntity<ResponseStructure<Menu>> AddingExistingFoodtoExsistingmenu(@RequestParam int foodid,@RequestParam int menuid) {
		   return menuservice.AddingExistingFoodtoExsistingmenu(foodid, menuid);
	   }
@PutMapping("/AddingNewFoodToExistingMenu")
    public ResponseEntity<ResponseStructure<Menu>> AddingNewFoodToExistingMenu(@RequestParam int menuid,@RequestBody Food newfood) {
		   return menuservice.AddingNewFoodToExistingMenu(menuid, newfood);
	   }
}
