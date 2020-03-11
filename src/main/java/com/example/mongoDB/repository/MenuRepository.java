package com.example.mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import com.example.mongoDB.entity.MenuEntity;

@Repository
public interface MenuRepository extends MongoRepository<MenuEntity, String> {
=======
import com.example.mongoDB.entity.Menu;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64

}
