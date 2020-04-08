package com.example.mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongoDB.entity.StockDetailEntity;

@Repository
public interface StockDetailRepository extends MongoRepository<StockDetailEntity, Long> {

}
