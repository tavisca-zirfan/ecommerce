package com.ngdfw.furniture.repository;

import javax.transaction.Transactional;
import java.util.*;

import org.springframework.data.repository.CrudRepository;

import com.ngdfw.furniture.model.Category;
@Transactional
public interface CategoryRepository extends CrudRepository<Category, Integer>{
	public List<Category> findAll();
}
