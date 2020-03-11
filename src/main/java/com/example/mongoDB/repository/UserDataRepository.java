package com.example.mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import com.example.mongoDB.entity.UserDataEntity;

@Repository
public interface UserDataRepository extends MongoRepository<UserDataEntity, Long> {
=======
import com.example.mongoDB.entity.UserData;

@Repository
public interface UserDataRepository extends MongoRepository<UserData, Long> {
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64

}
