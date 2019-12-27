package com.example.mongoDB.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongoDB.entity.Product;
import com.example.mongoDB.repository.ProductRepository;
import com.example.mongoDB.service.IStorageService;
import com.example.springbootfeignclient.model.OrderModel;

@Service("storageService")
public class StorageServiceImpl implements IStorageService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<OrderModel> doOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> getProduct() {
		List<Product> result = productRepository.findAll();

		return result.stream().map(product -> {
			OrderModel model = new OrderModel();
			BeanUtils.copyProperties(product, model);
			return model;
		}).collect(Collectors.toList());
	}

	@Override
	public Product setProduct(Product product) {
		return productRepository.save(product);
	}

}
