package com.example.mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import com.example.mongoDB.entity.ProductEntity;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String>{
=======
import com.example.mongoDB.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64

}
