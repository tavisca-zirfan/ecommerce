package com.ngdfw.furniture.repository;

import javax.transaction.Transactional;
import java.util.*;

import org.springframework.data.repository.CrudRepository;

import com.ngdfw.furniture.model.Color;
@Transactional
public interface ColorRepository extends CrudRepository<Color, Integer>{
	public List<Color> findAll();
}
