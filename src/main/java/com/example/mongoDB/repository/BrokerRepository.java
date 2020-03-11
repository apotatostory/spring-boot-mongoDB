package com.example.mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongoDB.entity.BrokerEntity;

@Repository
public interface BrokerRepository extends MongoRepository<BrokerEntity, Long> {

}
