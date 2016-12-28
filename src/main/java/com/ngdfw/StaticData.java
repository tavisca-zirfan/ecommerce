package com.ngdfw;
import java.util.*;
public class StaticData {
	public static final HashMap<Integer,String> Categories;
	public static final HashMap<Integer,String> SubCategories;
	public static final HashMap<Integer,String> Colors;
	public static final HashMap<Integer,String> Materials;
	public static final HashMap<Integer,String> Styles;
	public static final HashMap<String,Integer> CategoryMapping;
	public static final HashMap<String,Integer> SubCategoryMapping;
	static{
		Categories = new HashMap<Integer, String>();
		SubCategories = new HashMap<Integer, String>();
		Colors = new HashMap<Integer, String>();
		Materials = new HashMap<Integer, String>();
		Styles = new HashMap<Integer, String>();
		CategoryMapping = new HashMap<>();
		SubCategoryMapping = new HashMap<>();
	}
}
