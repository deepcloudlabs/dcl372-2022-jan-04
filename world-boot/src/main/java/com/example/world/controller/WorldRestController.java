package com.example.world.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.world.dao.CountryDao;
import com.example.world.entity.Country;

@RestController
@RequestMapping
@CrossOrigin("*")
public class WorldRestController {
	private CountryDao countryDao;
	
	public WorldRestController(CountryDao countryDao) {
		this.countryDao = countryDao;
	}

	@GetMapping("continents")
	public Collection<String> getContinents(){
		return countryDao.getAllContinents();
	}
	
	@GetMapping("countries")
	public Collection<Country> getCountries(@RequestParam String continent){
		return countryDao.findCountriesByContinent(continent);
	}
		
}
