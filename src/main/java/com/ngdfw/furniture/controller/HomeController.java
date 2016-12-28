package com.ngdfw.furniture.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ngdfw.StaticData;
import com.ngdfw.furniture.model.Product;
import com.ngdfw.furniture.service.ProductService;
import com.ngdfw.furniture.service.ResultSize;

@Controller
public class HomeController {
	@Autowired
	ProductService productService;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getHome(Locale locale,Model model){
		SortedMap<String,List<Product>> allProducts = new TreeMap<>();
		for(int catid:StaticData.Categories.keySet()){
			List<Product> products= productService.getTopProducts(catid,ResultSize.SMALL);
			allProducts.put(StaticData.Categories.get(catid), products);
		}		
		model.addAttribute("topproducts", allProducts);
		model.addAttribute("greeting","This is the shop");
		return "home";
	}
}
