package com.ngdfw.furniture.repository;

import javax.transaction.Transactional;
import java.util.*;

import org.springframework.data.repository.CrudRepository;

import com.ngdfw.furniture.model.Brand;
@Transactional
public interface BrandRepository extends CrudRepository<Brand, Integer>{
	public List<Brand> findAll();
}
