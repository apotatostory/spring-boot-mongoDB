package com.example.mongoDB.model;

import java.util.List;

import com.example.mongoDB.entity.MenuEntity;

public class MenuModel {

	private String cateName;

	private List<MenuEntity> menuList;

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public List<MenuEntity> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuEntity> menuList) {
		this.menuList = menuList;
	}
}
