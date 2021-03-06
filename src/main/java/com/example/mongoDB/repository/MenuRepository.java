package com.example.mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongoDB.entity.MenuEntity;

@Repository
public interface MenuRepository extends MongoRepository<MenuEntity, String> {

}
