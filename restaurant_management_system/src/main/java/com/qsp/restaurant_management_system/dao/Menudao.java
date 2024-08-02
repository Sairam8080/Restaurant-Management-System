package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.Menu;
import com.qsp.restaurant_management_system.repo.MenuRepo;

@Repository
public class Menudao {
   @Autowired
	MenuRepo menuRepo;
   @Autowired
   Fooddao fooddao;
   
   public Menu saveMenu(Menu menu) {
	   return menuRepo.save(menu);
   }
   public Menu fetchbiMenuId(int menuId) {
	   Optional<Menu>menu= menuRepo.findById(menuId);
	   if(menu.isPresent()) {
		   return menu.get();
	   }
	   return null;
   }
   public Menu updateMenu(Menu newmenu,int oldmenuid) {
	   newmenu.setMenuid(oldmenuid);
	   return menuRepo.save(newmenu);
   }
   public Menu deleteMenu(int menuId) {
	   Menu menu = menuRepo.findById(menuId).get();
	   menuRepo.delete(menu);
	   return menu;
	   
   }
   public List<Menu> fetchallMenus(){
	   return menuRepo.findAll();
   }
   public Menu AddingExistingFoodtoExsistingmenu(int foodid,int menuid) {
	      Menu menu=fetchbiMenuId(menuid);
	            Food food = fooddao.fetchByFoodId(foodid);
	            List<Food> list = menu.getFood();
	            list.add(food);
	            menu.setFood(list);
	            return saveMenu(menu);
   }
   public Menu AddingNewFoodToExistingMenu(int menuid,Food newfood) {
	   Menu menu=fetchbiMenuId(menuid);
       Food food = fooddao.saveFood(newfood);
       List<Food> list = menu.getFood();
       list.add(food);
       menu.setFood(list);
       return saveMenu(menu);
   }
   
}
