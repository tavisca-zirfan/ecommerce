package com.ngdfw.furniture.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngdfw.StaticData;
import com.ngdfw.furniture.model.Category;
import com.ngdfw.furniture.model.Menu;
import com.ngdfw.furniture.model.MenuItem;
import com.ngdfw.furniture.model.SubCategory;
import com.ngdfw.furniture.repository.CategoryRepository;
@Service
public class MenuService {
	@Autowired
	CategoryRepository categoryRepository;
	private Menu mainMenu;
	
	public Menu getMainMenu(){	
		if(mainMenu==null){
			List<Category> categories = categoryRepository.findAll();
			mainMenu = new Menu();
			for(Category category:categories){
				MenuItem item = new MenuItem(category);
				for(SubCategory subcategory:category.getSubCategories()){
					item.getChildItems().add(new MenuItem(subcategory));
				}
				mainMenu.getMenuItems().add(item);
			}
		}
		return mainMenu;
	}
}
