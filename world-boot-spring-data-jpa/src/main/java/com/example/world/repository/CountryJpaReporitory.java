package com.example.world.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.world.entity.jpa.Country;

public interface CountryJpaReporitory extends JpaRepository<Country, String> {
	@Query("select distinct c.continent from Country c")
	List<String> getAllContinents();

	@Query(nativeQuery = true, value = "select distinct continent from country")
	List<String> getNativeAllContinents();

	List<Country> findAllByContinent(String continent);
}
