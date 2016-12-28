package com.ngdfw.furniture.model;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Category")
public class Category {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="category")
	private List<SubCategory> subCategories;
	private String url;
	private String image;
	private BigDecimal lowestCost;
	private BigDecimal discount;
	
	public Category(String name, String url, String image) {
		this();
		this.name = name;
		this.url = url;
		this.image = image;		
	}

	public Category(String name, String url, String image, BigDecimal lowestCost, BigDecimal discount) {
		this(name,url,image);		
		this.lowestCost = lowestCost;
		this.discount = discount;
	}

	public Category() {
		// TODO Auto-generated constructor stub
		this.subCategories = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}
	
	public void addSubCategory(SubCategory subcategory){
		subcategory.setCategory(this);
		this.subCategories.add(subcategory);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getLowestCost() {
		return lowestCost;
	}

	public void setLowestCost(BigDecimal lowestCost) {
		this.lowestCost = lowestCost;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
}
