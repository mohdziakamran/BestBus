package com.example.bestbus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.bestbus.model.RememberMeToken;

@Repository
public interface RememberMeTokenReopsitory extends MongoRepository<RememberMeToken, String> {
	RememberMeToken findBySeries(String series);
	RememberMeToken findByUsername(String username);
	void deleteByUsername(String username);
}
