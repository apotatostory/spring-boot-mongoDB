package com.example.mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongoDB.entity.UserDataEntity;

@Repository
public interface UserDataRepository extends MongoRepository<UserDataEntity, Long> {

}
