package com.ngdfw.furniture.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Brand")
public class Brand {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String name;
	private String url;
	private String img;
	private int priority;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public Brand() {
		// TODO Auto-generated constructor stub
	}
	public Brand(String name) {
		super();
		this.name = name;
	}
	
	
}
