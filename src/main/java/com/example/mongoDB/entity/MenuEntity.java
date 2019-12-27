package com.example.mongoDB.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "MENU")
public class MenuEntity {

	@Id // 子類
	private String menuId;

	@Field(value = "GROUP") // 大類
	private String group;

	@Field(value = "NODE") // 1:父節點 2:子節點
	private int node;

	@Field(value = "NAME") // 名稱
	private String name;

	@Field(value = "TASK") // task
	private String task;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

}
