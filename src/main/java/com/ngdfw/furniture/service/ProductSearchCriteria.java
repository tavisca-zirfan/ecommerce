package com.ngdfw.furniture.service;

import com.ngdfw.furniture.model.*;
import java.util.*;
public class ProductSearchCriteria {
	private Cost cost;
	private String name;
	private Color color;
	private CollectionInfo collection;
	private List<Style> styles;
	private int pageNumber;
	private int pageSize;
	public Cost getCost() {
		return cost;
	}
	public void setCost(Cost cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public CollectionInfo getCollection() {
		return collection;
	}
	public void setCollection(CollectionInfo collection) {
		this.collection = collection;
	}
	public List<Style> getStyles() {
		return styles;
	}
	public void setStyles(List<Style> styles) {
		this.styles = styles;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
