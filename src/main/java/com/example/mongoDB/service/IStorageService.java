package com.example.mongoDB.service;

import java.util.List;

import com.example.mongoDB.entity.Product;
import com.example.springbootfeignclient.model.OrderModel;

public interface IStorageService {

	public List<OrderModel> doOrder();

	public List<OrderModel> getProduct();

	public Product setProduct(Product product);
}
