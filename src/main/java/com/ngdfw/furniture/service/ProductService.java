package com.ngdfw.furniture.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ngdfw.StaticData;
import com.ngdfw.furniture.model.*;
import com.ngdfw.furniture.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	public List<Product> getProductsBySearch(int category
			,int subcategory,ProductSearchCriteria criteria){
		ArrayList<Product> products = new ArrayList<Product>();
		for(int i=0;i<10;i++){
			Dimension dim = new Dimension(new BigDecimal(26.65), new BigDecimal(34.67),
					new BigDecimal(87.87), new BigDecimal(12.3), 
					new BigDecimal(34.3), new BigDecimal(25.3), new BigDecimal(112.4));
			Product product = new Product(1, "aws23394q", "Abigail Queen Bed With Lion Claws", 
					1, 2, new Brand("Coaster"), 
					true, "China", 
					2016, new CollectionInfo("Ashley Collection"), "Awesome bed that you should totally get", 
					"/images/category/bedroom.jpg", new Cost(799,99), dim);
			product.setUrl("/Bedroom/Beds");
			products.add(product);
		}		
		return products;		
	}
	
	public List<Product> getProducts(int category
			,int subcategory,int page, int size){
		Pageable pageRequest = new PageRequest(page-1, size,Direction.DESC,"popularity");
		List<Product> products = productRepository
				.findByCategoryIdAndSubCategoryId(category, subcategory, pageRequest);
		products.stream().forEach(p->p.setCategory(StaticData.Categories.get(p.getCategoryId())));
		products.stream().forEach(p->p.setSubCategory(StaticData.SubCategories.get(p.getSubCategoryId())));
		return products;
	}
	
	public List<Product> getTopProducts(int category,ResultSize size){
		List<Product> products;
		if(size==ResultSize.SMALL){
			products = productRepository.findFirst4ByCategoryIdOrderByPopularityDesc(category);
		}else{
			products = productRepository.findFirst10ByCategoryIdOrderByPopularityDesc(category);
		}
				
		products.stream().forEach(p->p.setCategory(StaticData.Categories.get(p.getCategoryId())));
		products.stream().forEach(p->p.setSubCategory(StaticData.SubCategories.get(p.getSubCategoryId())));
		return products;
	}
	
	public List<Product> getTopProducts(int category,int subcategory){
		List<Product> products = productRepository
				.findFirst10ByCategoryIdAndSubCategoryIdOrderByPopularityDesc(category,subcategory);
		products.stream().forEach(p->p.setCategory(StaticData.Categories.get(p.getCategoryId())));
		products.stream().forEach(p->p.setSubCategory(StaticData.SubCategories.get(p.getSubCategoryId())));
		return products;
	}
	
	public List<Product> getRelatedProducts(int collectionId){
		List<Product> products = productRepository
				.findByCollectionId(collectionId);
		products.stream().forEach(p->p.setCategory(StaticData.Categories.get(p.getCategoryId())));
		products.stream().forEach(p->p.setSubCategory(StaticData.SubCategories.get(p.getSubCategoryId())));
		return products;
	}
	
	public Integer getCount(int categoryId){
		return productRepository.countByCategoryId(categoryId);
	}
	public Integer getCount(int categoryId,int subcategoryId){
		return productRepository.countByCategoryIdAndSubCategoryId(categoryId, subcategoryId);
	}
	
	public Product getProduct(int id){
		Product product = productRepository.findById(id);
		product.setCategory(StaticData.Categories.get(product.getCategoryId()));
		product.setCategory(StaticData.Categories.get(product.getCategoryId()));
		return product;
	}
	
	public void addProduct(Product product){
		productRepository.save(product);
	}
	
//	public void addProduct(Product prod){
//		Dimension dim = new Dimension(new BigDecimal(26.65), new BigDecimal(34.67),
//				new BigDecimal(87.87), new BigDecimal(12.3), 
//				new BigDecimal(34.3), new BigDecimal(25.3), new BigDecimal(112.4));
//		Product product = new Product(1, "aws23394q", "Abigail Queen Bed With Lion Claws", 
//				1, 2, new Brand("Coaster"), 
//				true, "China", 
//				2016, new CollectionInfo("Ashley Collection"), "Awesome bed that you should totally get", 
//				"/images/category/bedroom.jpg", new Cost(799,99), dim);
//		product.setUrl("/Bedroom/Beds");
//		product.getImages().add(product.getImage());
//		product.getImages().add(product.getImage());
//		product.getImages().add(product.getImage());
//		product.getColors().add(new Color(1,"Red"));
//		product.getColors().add(new Color(1,"Purple"));
//		product.getColors().add(new Color(1,"Brown"));
//		product.getStyles().add(new Style(1,"Bunk Bed"));
//		product.getStyles().add(new Style(1,"Canopy"));
//		product.getMaterials().add(new Material(1, "Metal/iron"));
//		product.getMaterials().add(new Material(1, "Upholstered"));
//		try{
//			productRepository.save(product);
//		}catch(Exception ex){
//			ex.printStackTrace(System.out);
//		}
//	}
}
