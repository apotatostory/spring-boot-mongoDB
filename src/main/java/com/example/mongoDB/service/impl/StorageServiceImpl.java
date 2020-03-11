package com.example.mongoDB.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.example.mongoDB.entity.ProductEntity;
import com.example.mongoDB.repository.ProductRepository;
import com.example.mongoDB.service.IStorageService;
import com.example.springbootfeignclient.vo.OrderVo;
=======
import com.example.mongoDB.entity.Product;
import com.example.mongoDB.repository.ProductRepository;
import com.example.mongoDB.service.IStorageService;
import com.example.springbootfeignclient.model.OrderModel;
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64

@Service("storageService")
public class StorageServiceImpl implements IStorageService {

	@Autowired
	ProductRepository productRepository;

	@Override
<<<<<<< HEAD
	public List<OrderVo> doOrder() {
=======
	public List<OrderModel> doOrder() {
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64
		// TODO Auto-generated method stub
		return null;
	}

	@Override
<<<<<<< HEAD
	public List<OrderVo> getProduct() {
		List<ProductEntity> result = productRepository.findAll();

		return result.stream().map(product -> {
			OrderVo model = new OrderVo();
=======
	public List<OrderModel> getProduct() {
		List<Product> result = productRepository.findAll();

		return result.stream().map(product -> {
			OrderModel model = new OrderModel();
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64
			BeanUtils.copyProperties(product, model);
			return model;
		}).collect(Collectors.toList());
	}

	@Override
<<<<<<< HEAD
	public ProductEntity setProduct(ProductEntity product) {
=======
	public Product setProduct(Product product) {
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64
		return productRepository.save(product);
	}

}
