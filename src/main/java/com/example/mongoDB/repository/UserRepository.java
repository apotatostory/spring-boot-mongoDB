package com.example.mongoDB.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import com.example.mongoDB.entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Long> {

	Optional<List<UserEntity>> findByFirstName(String firstName);
=======
import com.example.mongoDB.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	Optional<List<User>> findByFirstName(String firstName);
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64
}
