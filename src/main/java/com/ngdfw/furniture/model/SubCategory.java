package com.ngdfw.furniture.model;

import javax.persistence.*;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="Subcategory")
public class SubCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String url;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="category_id",nullable=false)
	private Category category;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public SubCategory(){
		
	}
	public SubCategory(int id,String name){
		this.id = id;
		this.name = name;
	}
}
