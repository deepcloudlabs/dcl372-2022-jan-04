package com.example.world.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.world.entity.document.Country;

public interface CountryMongoRepository extends MongoRepository<Country, String> {
	List<Country> findAllByContinent(String continent);
	Country findTopByOrderByPopulationDesc();
	@Aggregation(pipeline = { "{ '$group': { '_id' : '$continent' } }" })
	List<String> getAllContinents();
}
