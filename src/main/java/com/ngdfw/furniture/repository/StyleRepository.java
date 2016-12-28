package com.ngdfw.furniture.repository;

import javax.transaction.Transactional;
import java.util.*;

import org.springframework.data.repository.CrudRepository;

import com.ngdfw.furniture.model.Style;
@Transactional
public interface StyleRepository extends CrudRepository<Style, Integer>{
	public List<Style> findAll();
}
