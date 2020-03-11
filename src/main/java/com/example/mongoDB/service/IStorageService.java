package com.example.mongoDB.service;

import java.util.List;

<<<<<<< HEAD
import com.example.mongoDB.entity.ProductEntity;
import com.example.springbootfeignclient.vo.OrderVo;

public interface IStorageService {

	public List<OrderVo> doOrder();

	public List<OrderVo> getProduct();

	public ProductEntity setProduct(ProductEntity product);

=======
import com.example.mongoDB.entity.Product;
import com.example.springbootfeignclient.model.OrderModel;

public interface IStorageService {

	public List<OrderModel> doOrder();

	public List<OrderModel> getProduct();

	public Product setProduct(Product product);
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64
}
