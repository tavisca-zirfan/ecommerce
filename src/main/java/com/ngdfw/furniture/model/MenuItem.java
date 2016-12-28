package com.ngdfw.furniture.model;

import java.util.*;

public class MenuItem {
	private Category category;
	private SubCategory subcategory;
	List<MenuItem> childItems;
	public MenuItem() {
		childItems = new ArrayList<MenuItem>();
	}
	public MenuItem(String title,String url) {
		this();
		this.category = new Category(title,url,"");
	}
	public MenuItem(Category category){
		this();
		this.category = category;
	}
	public MenuItem(SubCategory category){
		this();
		this.subcategory = category;
	}
	public String getTitle() {
		return category!=null ? category.getName():subcategory.getName();
	}	
	public String getUrl() {
		return category!=null ? category.getUrl():subcategory.getUrl();
	}	
	public String getImage(){
		return category!=null ? category.getImage():"";
	}
	public Category getCategory(){
		return category;
	}
	public SubCategory getSubCategory(){
		return subcategory;
	}
	public List<MenuItem> getChildItems() {
		return childItems;
	}
	public void setChildItems(List<MenuItem> childItems) {
		this.childItems = childItems;
	}
}
