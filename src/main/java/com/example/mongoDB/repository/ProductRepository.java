package com.example.mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongoDB.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

}
