package com.example.mongoDB.model;

import java.util.List;

<<<<<<< HEAD
import com.example.mongoDB.entity.MenuEntity;
=======
import com.example.mongoDB.entity.Menu;
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64

public class MenuModel {

	private String cateName;

<<<<<<< HEAD
	private List<MenuEntity> menuList;
=======
	private List<Menu> menuList;
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

<<<<<<< HEAD
	public List<MenuEntity> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuEntity> menuList) {
=======
	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64
		this.menuList = menuList;
	}
}
