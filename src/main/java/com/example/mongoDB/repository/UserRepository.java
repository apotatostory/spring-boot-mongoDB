package com.example.mongoDB.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongoDB.entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Long> {

	Optional<List<UserEntity>> findByFirstName(String firstName);

}
