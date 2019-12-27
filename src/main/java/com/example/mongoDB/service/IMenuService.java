package com.example.mongoDB.service;

import java.util.List;
import java.util.Map;

import com.example.mongoDB.entity.MenuEntity;

public interface IMenuService {

	public Map<String, List<MenuEntity>> getMenu();

	public void setMenu(MenuEntity menu);

}
