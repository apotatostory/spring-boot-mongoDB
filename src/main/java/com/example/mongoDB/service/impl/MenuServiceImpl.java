package com.example.mongoDB.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.example.mongoDB.entity.MenuEntity;
=======
import com.example.mongoDB.entity.Menu;
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64
import com.example.mongoDB.repository.MenuRepository;
import com.example.mongoDB.service.IMenuService;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {

	@Autowired
	MenuRepository menuRepository;

	/**
	 * 取得Menu
	 */
	@Override
<<<<<<< HEAD
	public Map<String, List<MenuEntity>> getMenu() {
		List<MenuEntity> menuList = menuRepository.findAll();

		return Optional.ofNullable(menuList).orElse(new ArrayList<MenuEntity>()).stream().sorted(Comparator.comparingInt(MenuEntity::getNode))
				.collect(Collectors.groupingBy(MenuEntity::getGroup));
=======
	public Map<String, List<Menu>> getMenu() {
		List<Menu> menuList = menuRepository.findAll();

		return Optional.ofNullable(menuList).orElse(new ArrayList<Menu>()).stream().sorted(Comparator.comparingInt(Menu::getNode))
				.collect(Collectors.groupingBy(Menu::getGroup));
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64
	}

	/**
	 * 設定表單
	 */
	@Override
<<<<<<< HEAD
	public void setMenu(MenuEntity menu) {
=======
	public void setMenu(Menu menu) {
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64
		menuRepository.save(menu);
	}

}
