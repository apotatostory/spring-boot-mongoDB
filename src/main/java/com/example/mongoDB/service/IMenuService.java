package com.example.mongoDB.service;

import java.util.List;
import java.util.Map;

import com.example.mongoDB.entity.Menu;

public interface IMenuService {

	public Map<String, List<Menu>> getMenu();

	public void setMenu(Menu menu);

}
