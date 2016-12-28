package com.ngdfw.furniture.model;

import java.util.*;

public class Menu {
	List<MenuItem> menuItems;
	public Menu() {
		menuItems = new ArrayList<MenuItem>();
	}
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
}
