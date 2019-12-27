package com.example.mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongoDB.entity.Menu;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {

}
