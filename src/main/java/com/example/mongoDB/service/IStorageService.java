package com.example.mongoDB.service;

import java.util.List;

import com.example.mongoDB.entity.ProductEntity;
import com.example.vo.OrderVo;

public interface IStorageService {

	public List<OrderVo> doOrder();

	public List<OrderVo> getProduct();

	public ProductEntity setProduct(ProductEntity product);

}
