package com.example.mongoDB.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongoDB.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	Optional<List<User>> findByFirstName(String firstName);
}
