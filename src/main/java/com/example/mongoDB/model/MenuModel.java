package com.example.mongoDB.model;

import java.util.List;

import com.example.mongoDB.entity.Menu;

public class MenuModel {

	private String cateName;

	private List<Menu> menuList;

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
}
