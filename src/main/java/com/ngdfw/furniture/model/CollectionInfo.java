package com.ngdfw.furniture.model;

import javax.persistence.*;

@Entity
@Table(name="Collection")
public class CollectionInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String collectionId;
	private String collectionName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	 public CollectionInfo() {
		// TODO Auto-generated constructor stub
	}
	public CollectionInfo(String collectionName) {
		super();
		this.collectionName = collectionName;
	}
	 
}
