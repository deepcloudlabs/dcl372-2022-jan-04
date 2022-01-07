package com.example.world.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.world.entity.document.Country;
import com.example.world.repository.CountryMongoRepository;

@RestController
@RequestScope
@CrossOrigin("*")
public class WorldRestController {
	private CountryMongoRepository countryRepository;
	
	public WorldRestController(CountryMongoRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@GetMapping("continents")
	public Collection<String> getContinents(){
		return countryRepository.getAllContinents();
	}
	
	@GetMapping("countries")
	public Collection<Country> getCountries(@RequestParam String continent){
		return countryRepository.findAllByContinent(continent);
	}
		
}
