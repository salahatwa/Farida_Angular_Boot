package com.igi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.igi.entities.BusinessServiceConfig;
import com.igi.entities.OfferedServiceType;
import com.igi.entities.ServiceConfigMap;
import com.igi.repositories.BusinessServiceConfigRepository;
import com.igi.repositories.OfferedServiceTypeRepository;
import com.igi.repositories.ServiceConfigMapRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "http://localhost:4200", allowedHeaders = "*")
public class BusinessServiceConfigController {

	@Autowired
	private BusinessServiceConfigRepository businessServiceConfigRepository;

	@GetMapping("/config/{id}")
	public BusinessServiceConfig getBusinessServiceConfigById(@PathVariable Integer id) {
		BusinessServiceConfig conf = null;
		try {
			ServiceConfigMap serviceConfigMap = new ServiceConfigMap();
			serviceConfigMap.setId(id);
			conf = businessServiceConfigRepository.findByBusinessServiceType(serviceConfigMap);

			System.err.println("Conf:" + conf.toString() + ":"+conf.getSteps().size());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conf;
	}

	@PostMapping("/config")
	public void createBusinessConfig(@RequestBody BusinessServiceConfig businessServiceConfig) {
		businessServiceConfigRepository.save(businessServiceConfig);
	}

}
