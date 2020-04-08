package com.example.mongoDB.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "STOCKDETAIL")
public class StockDetailEntity {

	@Field(value = "STOCKID")
	private String stockId;

	@Field(value = "STOCKNAME")
	private String stockName;

	@Field(value = "BRANCHID")
	private String branchId;

	@Field(value = "BUY")
	private BigDecimal buy;

	@Field(value = "SELL")
	private BigDecimal sell;

	@Field(value = "BAL")
	private BigDecimal bal;

	@Field(value = "DATE")
	private Date date;

	@Override
	public String toString() {
		return String.format("%s %s %s %.0f %.0f %.0f", stockId, stockName, branchId, buy, sell, bal);
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public BigDecimal getBuy() {
		return buy;
	}

	public void setBuy(BigDecimal buy) {
		this.buy = buy;
	}

	public BigDecimal getSell() {
		return sell;
	}

	public void setSell(BigDecimal sell) {
		this.sell = sell;
	}

	public BigDecimal getBal() {
		return bal;
	}

	public void setBal(BigDecimal bal) {
		this.bal = bal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
