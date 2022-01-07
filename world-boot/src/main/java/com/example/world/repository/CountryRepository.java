package com.example.world.repository;

import java.util.List;

import com.example.world.entity.jpa.Country;

public interface CountryRepository {
	List<String> getAllContinents();
	List<Country> getCountriesByContinent(String continent);
}
