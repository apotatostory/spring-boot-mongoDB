package com.example.mongoDB.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongoDB.entity.StockDetailEntity;
import com.example.mongoDB.repository.StockDetailRepository;
import com.example.mongoDB.service.IStockDetailService;

@Service("stockDetailService")
public class StockDetailServiceImpl implements IStockDetailService {

	@Autowired
	private StockDetailRepository repository;

	@Override
	public void setStock(List<StockDetailEntity> stocks) {
		repository.saveAll(stocks);
	}

	@Override
	public List<StockDetailEntity> getStock() {
		return repository.findAll();
	}

}
