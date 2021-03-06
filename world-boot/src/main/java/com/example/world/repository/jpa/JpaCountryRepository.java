package com.example.world.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.example.world.entity.jpa.Country;
import com.example.world.repository.CountryRepository;

@Repository
public class JpaCountryRepository implements CountryRepository {
	private EntityManager entityManager;
	
	public JpaCountryRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<String> getAllContinents() {
		return entityManager.createNamedQuery("Country.findAllContinents", 
				   String.class).getResultList();
	}

	@Override
	public List<Country> getCountriesByContinent(String continent) {
		return entityManager.createNamedQuery("Country.findCountriesByContinent",
				Country.class).setParameter("continent", continent)
				   .getResultList();
	}

}
