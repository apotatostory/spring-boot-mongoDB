package com.example.mongoDB.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongoDB.entity.Menu;
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
	public Map<String, List<Menu>> getMenu() {
		List<Menu> menuList = menuRepository.findAll();

		return Optional.ofNullable(menuList).orElse(new ArrayList<Menu>()).stream().sorted(Comparator.comparingInt(Menu::getNode))
				.collect(Collectors.groupingBy(Menu::getGroup));
	}

	/**
	 * 設定表單
	 */
	@Override
	public void setMenu(Menu menu) {
		menuRepository.save(menu);
	}

}
