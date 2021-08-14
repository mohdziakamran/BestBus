package com.example.bestbus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bestbus.model.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
	@Query
    User findByEmail(String email);

}
