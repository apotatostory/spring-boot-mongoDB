package com.example.mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongoDB.entity.ProductEntity;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String>{

}
