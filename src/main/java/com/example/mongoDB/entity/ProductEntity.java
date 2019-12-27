package com.example.mongoDB.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "PRODUCT")
public class ProductEntity {

	@Id // 子類
	private String id;

	@Field(value = "NAME")
	private String name;

	@Field(value = "PRICE") // 單價
	private BigDecimal price;

	@Field(value = "REMAINED") // 剩餘數量
	private int remained;

	@Field(value = "CREATIONDATE") // 建立日期
	private Date creationDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getRemained() {
		return remained;
	}

	public void setRemained(int remained) {
		this.remained = remained;
	}

}
