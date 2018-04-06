package com.igi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.igi.entities.OfferedServiceType;
import com.igi.repositories.OfferedServiceTypeRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "http://localhost:4200", allowedHeaders = "*")
public class OfferedServiceTypeController {
	
	@Autowired	
	private OfferedServiceTypeRepository offeredServiceTypeRepository;	
	
	@GetMapping("/service/types")
	public @ResponseBody Iterable<OfferedServiceType> getServiceTypes()
	{
		Iterable<OfferedServiceType> types=offeredServiceTypeRepository.findAll();	
		
		return types;	
	}

}
