package com.ngdfw.furniture.repository;

import javax.transaction.Transactional;
import java.util.*;

import org.springframework.data.repository.CrudRepository;

import com.ngdfw.furniture.model.Material;
@Transactional
public interface MaterialRepository extends CrudRepository<Material, Integer>{
	public List<Material> findAll();
}
