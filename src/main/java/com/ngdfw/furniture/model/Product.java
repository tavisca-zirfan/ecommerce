package com.ngdfw.furniture.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="product")

public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String sku;
	private String name;
	@NotNull
	private int categoryId;
	@NotNull
	private int subCategoryId;
	@Transient
	private String category;
	@Transient
	private String subCategory;
	@Transient
	private String url;
	@ManyToOne(cascade=CascadeType.ALL)
	private Brand brand;
	private boolean assemblyRequired;
	private String countryOfOrigin;
	private int catalogYear;
	private int popularity;
	@ManyToOne(cascade=CascadeType.ALL)
	private CollectionInfo collection;
	@Column(length = 1000000)
	private String description;
	private String image;
	@Embedded
	private Cost cost;
	@Embedded
	private Dimension dimension;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Product_Color",
	joinColumns={@JoinColumn(name="Product_Id")},
	inverseJoinColumns={@JoinColumn(name="Color_Id")})
	private List<Color> colors;
	@ElementCollection
	@CollectionTable(name="Tags",joinColumns={@JoinColumn(name="Product_Id")})
	private Set<String> tags;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Product_Material",
			joinColumns={@JoinColumn(name="Product_Id")},
			inverseJoinColumns={@JoinColumn(name="Material_Id")})
	private Set<Material> materials;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Product_Style",
			joinColumns={@JoinColumn(name="Product_Id")},
			inverseJoinColumns={@JoinColumn(name="Style_Id")})
	private Set<Style> styles;
	@ElementCollection
	@CollectionTable(name="Images",joinColumns={@JoinColumn(name="Product_Id")})
	private List<String> images;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getUrl() {
		return String.format("/product/%s/%s/%d", String.join("", category.split(" ")).toLowerCase(),String.join("", subCategory.split(" ")).toLowerCase(),id);
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public boolean isAssemblyRequired() {
		return assemblyRequired;
	}
	public void setAssemblyRequired(boolean assemblyRequired) {
		this.assemblyRequired = assemblyRequired;
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	public int getCatalogYear() {
		return catalogYear;
	}
	public void setCatalogYear(int catalogYear) {
		this.catalogYear = catalogYear;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public CollectionInfo getCollection() {
		return collection;
	}
	public void setCollection(CollectionInfo collection) {
		this.collection = collection;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Cost getCost() {
		return cost;
	}
	public void setCost(Cost cost) {
		this.cost = cost;
	}
	public Dimension getDimension() {
		return dimension;
	}
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	public List<Color> getColors() {
		return colors;
	}
	public void setColors(List<Color> colors) {
		this.colors = colors;
	}
	public Set<String> getTags() {
		return tags;
	}
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	public Set<Material> getMaterials() {
		return materials;
	}
	public void setMaterials(Set<Material> materials) {
		this.materials = materials;
	}
	public Set<Style> getStyles() {
		return styles;
	}
	public void setStyles(Set<Style> styles) {
		this.styles = styles;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public Product() {
		this.colors = new ArrayList<Color>();
		this.tags = new HashSet<String>();
		this.materials = new HashSet<Material>();
		this.styles = new HashSet<Style>();
		this.images = new ArrayList<String>();
		this.dimension = new Dimension();
		this.cost = new Cost();
	}
	public Product(int id, String sku, String name, int categoryId, int subCategoryId, Brand brand,
			boolean assemblyRequired, String countryOfOrigin, int catalogYear, CollectionInfo collection,
			String description, String image, Cost cost, Dimension dimension) {
		this();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.categoryId = categoryId;
		this.subCategoryId = subCategoryId;
		this.brand = brand;
		this.assemblyRequired = assemblyRequired;
		this.countryOfOrigin = countryOfOrigin;
		this.catalogYear = catalogYear;
		this.collection = collection;
		this.description = description;
		this.image = image;
		this.cost = cost;
		this.dimension = dimension;
	}
	
}
