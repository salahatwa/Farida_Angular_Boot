package com.igi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igi.entities.Country;
import com.igi.repositories.CountryRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "http://localhost:4200", allowedHeaders = "*")
public class CountryController {

	private Logger logger = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	private CountryRepository countryRepository;

	@GetMapping("/countries")
	public Page<Country> getAllCOuntries(@RequestParam(defaultValue = "0") int page) {
		return countryRepository.findAll(new PageRequest(page, 4));
	}

	@DeleteMapping("/country/{id}")
	public void deleteCountry(@PathVariable Long id) {
		logger.info("Delete country ...");
		countryRepository.delete(id);
	}

	@PostMapping("/country")
	public void createCountry(@RequestBody Country country) {
		logger.info("Create Country ...");
		countryRepository.save(country);
	}

}
