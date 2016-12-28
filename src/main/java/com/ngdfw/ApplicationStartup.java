package com.ngdfw;
import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.ngdfw.furniture.model.*;
import com.ngdfw.furniture.repository.CategoryRepository;
import com.ngdfw.furniture.repository.ColorRepository;
import com.ngdfw.furniture.repository.MaterialRepository;
import com.ngdfw.furniture.repository.ProductRepository;
import com.ngdfw.furniture.repository.StyleRepository;

@Component
public class ApplicationStartup 
implements ApplicationListener<ApplicationReadyEvent> {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ColorRepository colorRepository;
	@Autowired
	private MaterialRepository materialRepository;
	@Autowired
	private StyleRepository styleRepository;
	@Autowired
	private ProductRepository productRepository;
	
	public void onApplicationEvent(final ApplicationReadyEvent arg0) {
		// TODO Auto-generated method stub
		loadDataset();
		
	}
	public void loadDataset(){
		loadCategories();
		loadColors();
		loadMaterials();
		loadStyles();
	}
	
	public void insertDataSet(){
		
	}
	
	public void loadCategories(){
		List<Category> categories = categoryRepository.findAll();
		for(Category category:categories){
			StaticData.Categories.put(category.getId(), category.getName());
			StaticData.CategoryMapping.put(String.join("",category.getName().split(" ")).toLowerCase(),category.getId());
			for(SubCategory subcategory:category.getSubCategories()){
				StaticData.SubCategories.put(subcategory.getId(), subcategory.getName());
				StaticData.SubCategoryMapping.put(String.join("",subcategory.getName().split(" ")).toLowerCase(),subcategory.getId());
			}
		}
	}
		
	
	public void loadColors(){
		List<Color> colors = colorRepository.findAll();
		for(Color color:colors){
			StaticData.Colors.put(color.getId(), color.getName());
		}
	}
	
	public void loadMaterials(){
		List<Material> materials = materialRepository.findAll();
		for(Material material:materials){
			StaticData.Materials.put(material.getId(), material.getName());
		}
	}
	
	public void loadStyles(){
		List<Style> styles = styleRepository.findAll();
		for(Style style:styles){
			StaticData.Styles.put(style.getId(), style.getName());
		}
	}
	
	String baseLink = "http://www.hopkinsfurniture.com";
	int counter = 0;
	public void start(){		
		Document doc;
		try {
			doc = Jsoup.connect(baseLink+"/by-brand/coaster/Coaster.html").get();
			Element panel = doc.getElementById("panel1");
			Elements categories = panel.select("li.view_all a");
			for (Element link : categories) {
				getAllProducts(baseLink+link.attr("href"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getAllProducts(String url){
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			Element nextPage = doc.select("a.selected.numbered_link")
					.first().nextElementSibling();
			do {
				Elements productURLs = doc.select("div.cat_list_product a.cat_product_img");
				for (Element product : productURLs) {
					getProduct(baseLink+product.attr("href"));					
				}
				if(nextPage!=null){
					doc = Jsoup.connect(baseLink+nextPage.attr("href")).get();
					nextPage = doc.select("a.selected.numbered_link")
							.first().nextElementSibling();
				}
			} while (nextPage!=null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getProduct(String url){
		System.out.println("Product : "+counter++);
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			String img = doc.getElementById("main_product_image")
					.select("img").attr("src");
			System.out.println(img);
			Element panel1 = doc.getElementById("panel1");
			if(panel1!=null){
				Element description = panel1.select("p").get(0);
				System.out.println(description.text());
			}
			Element panel2 = doc.getElementById("panel2");
			if(panel2!=null){
				Elements attributes = panel2
						.select("tr");
				for (Element rowdata : attributes) {
					if(rowdata.children().size()<2)
						continue;
					Elements cell = rowdata.select("td");
					System.out.println(cell.get(0).select("b").get(0).text()+":"+cell.get(1).text());
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  /**
   * This event is executed as late as conceivably possible to indicate that 
   * the application is ready to service requests.
   */
  
 
} // class
