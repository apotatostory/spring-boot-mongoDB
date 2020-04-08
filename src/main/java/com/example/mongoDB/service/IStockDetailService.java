package com.example.mongoDB.service;

import java.util.List;

import com.example.mongoDB.entity.StockDetailEntity;

public interface IStockDetailService {

	public void setStock(List<StockDetailEntity> stocks);

	public List<StockDetailEntity> getStock();

}
