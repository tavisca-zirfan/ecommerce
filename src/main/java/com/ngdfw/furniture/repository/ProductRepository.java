package com.ngdfw.furniture.repository;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.ngdfw.furniture.model.Product;
@Transactional
public interface ProductRepository extends CrudRepository<Product, Long>{
	public Product findById(long id);
	public List<Product> 
	findFirst10ByCategoryIdOrderByPopularityDesc(
			int categoryId);
	public List<Product> 
	findFirst4ByCategoryIdOrderByPopularityDesc(
			int categoryId);
	public List<Product> 
	findFirst10ByCategoryIdAndSubCategoryIdOrderByPopularityDesc(
			int categoryId,int subcategoryId);
	public List<Product> 
	findByCategoryId(
			int categoryId,Pageable page);
	public List<Product> 
	findByCategoryIdAndSubCategoryId(
			int categoryId,int subCategoryId,Pageable page);
	public Integer countByCategoryIdAndSubCategoryId(
			int categoryId,int subCategoryId);
	public Integer countByCategoryId(
			int categoryId);
	public List<Product> findByCollectionId(int collectionId);
}
