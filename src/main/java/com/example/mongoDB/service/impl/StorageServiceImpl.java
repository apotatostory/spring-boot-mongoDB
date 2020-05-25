package com.example.mongoDB.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongoDB.entity.ProductEntity;
import com.example.mongoDB.repository.ProductRepository;
import com.example.mongoDB.service.IStorageService;
import com.example.vo.OrderVo;

@Service("storageService")
public class StorageServiceImpl implements IStorageService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<OrderVo> doOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVo> getProduct() {
		List<ProductEntity> result = productRepository.findAll();

		return result.stream().map(product -> {
			OrderVo model = new OrderVo();

			BeanUtils.copyProperties(product, model);
			return model;
		}).collect(Collectors.toList());
	}

	@Override
	public ProductEntity setProduct(ProductEntity product) {
		return productRepository.save(product);
	}

}
