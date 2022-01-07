package com.example.world.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.world.entity.jpa.Country;
import com.example.world.repository.CountryRepository;

@RestController
@RequestMapping
@CrossOrigin("*")
public class WorldRestController {
	private CountryRepository countryRepository;
	
	public WorldRestController(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@GetMapping("continents")
	public Collection<String> getContinents(){
		return countryRepository.getAllContinents();
	}
	
	@GetMapping("countries")
	public Collection<Country> getCountries(@RequestParam String continent){
		return countryRepository.getCountriesByContinent(continent);
	}
		
}
