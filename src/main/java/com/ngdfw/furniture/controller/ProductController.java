package com.ngdfw.furniture.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ngdfw.StaticData;
import com.ngdfw.furniture.model.*;
import com.ngdfw.furniture.repository.ProductRepository;
import com.ngdfw.furniture.service.ProductService;
import com.ngdfw.furniture.service.ResultSize;
@Controller
@SessionAttributes("recent")
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping(value="/products/{category}/{subcategory}",method=RequestMethod.GET)
	public String getProductList(@PathVariable(value="category") String category
			,@PathVariable(value="subcategory") String subcategory,Locale locale,Model model){
		int page =1;
		int categoryId = StaticData.CategoryMapping.get(category);
		int subcategoryId = StaticData.SubCategoryMapping.get(subcategory);
		List<Product> products = productService
				.getProducts(categoryId, subcategoryId, page,12);
		int size = productService.getCount(categoryId,subcategoryId);
		int startpage = page-5>1?page-5:1;
		int endpage = startpage+9>Math.ceil((size/12))?(int)Math.ceil((size/12)):startpage+9;
		model.addAttribute("size", size);
		model.addAttribute("curpage", page);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("products",products);
		model.addAttribute("category", StaticData.Categories.get(categoryId));
		model.addAttribute("catstr", category);
		model.addAttribute("subcatstr",subcategory);
		return "productlist";
	}
	
	@RequestMapping(value="/products/{category}/{subcategory}/{page}",method=RequestMethod.GET)
	public String getProductList(@PathVariable(value="category") String category
			,@PathVariable(value="subcategory") String subcategory
			,@PathVariable(value="page") int page,
			Locale locale,Model model){
		
		int categoryId = StaticData.CategoryMapping.get(category);
		int subcategoryId = StaticData.SubCategoryMapping.get(subcategory);
		List<Product> products = productService
				.getProducts(categoryId, subcategoryId, page,12);
		int size = productService.getCount(categoryId,subcategoryId);
		int startpage = page-5>1?page-5:1;
		int endpage = startpage+9>Math.ceil((size/12))?(int)Math.ceil((size/12)):startpage+9;
		model.addAttribute("size", size);
		model.addAttribute("curpage", page);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("products",products);
		model.addAttribute("category", StaticData.Categories.get(categoryId));
		model.addAttribute("catstr", category);
		model.addAttribute("subcatstr",subcategory);
		return "productlist";
	}
	
	@ModelAttribute("recent")
	public List<Product> populateForm() {
       return new LinkedList<Product>(); // populates recent for the first time if its null
    }
	
	@RequestMapping(value="/product/{category}/{subcategory}/{id}",method=RequestMethod.GET)
	
	public String getProduct(@PathVariable(value="category") String category
			,@PathVariable(value="subcategory") String subcategory
			,@PathVariable(value="id") String id,Locale locale,Model model
			,@ModelAttribute("recent") LinkedList<Product> recentProducts){
		int categoryId = StaticData.CategoryMapping.get(category);
		int subcategoryId = StaticData.SubCategoryMapping.get(subcategory);
		Product product = productService.getProduct(Integer.parseInt(id));
		if(recentProducts==null){
			recentProducts = new LinkedList<Product>();
			model.addAttribute("recent", recentProducts);
		}
		
		if(!recentProducts.contains(product)){
			if(recentProducts.size()>=5){
				recentProducts.removeLast();
			}
			recentProducts.addFirst(product);
		}
		List<Product> topProducts = productService.getTopProducts(categoryId,subcategoryId).subList(0, 5);
		if(product.getCollection()!=null){
			List<Product> relatedProducts = productService.getRelatedProducts(product.getCollection().getId());
			HashMap<String,Product> relatedProductsDistinct = new HashMap<>();
			for(Product p:relatedProducts){
				relatedProductsDistinct.put(p.getName(), p);
			}
			relatedProducts.clear();relatedProducts.addAll(relatedProductsDistinct.values());
			model.addAttribute("collection", relatedProducts);
		}
		model.addAttribute("topproducts", topProducts);
		model.addAttribute("product",product);
		model.addAttribute("category", category);
		return "product";
	}
}
