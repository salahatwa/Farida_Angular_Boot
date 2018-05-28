package com.igi.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.igi.entities.BusinessServiceConfig;
import com.igi.entities.BusinessServiceStep;
import com.igi.entities.QueryModel;
import com.igi.entities.Service;
import com.igi.entities.ServiceConfigMap;
import com.igi.repositories.BusinessServiceConfigRepository;
import com.igi.repositories.ServiceConfigMapRepository;

/**
 * Parent Service
 * 
 * @author salah
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(value = "http://localhost:4200", allowedHeaders = "*")
public class ServiceConfigMapController {

	@Autowired
	private ServiceConfigMapRepository serviceConfigMapRepository;

	@Autowired
	private BusinessServiceConfigRepository businessServiceConfigRepository;

	@GetMapping("/serviceConfigMap/all")
	public Page<ServiceConfigMap> getAllService(@RequestParam(defaultValue = "0") int page) {
		return serviceConfigMapRepository.findAll(new PageRequest(page, 5));
	}

	@GetMapping("/serviceConfigMap/{id}")
	public Optional<ServiceConfigMap> getServiceByID(@PathVariable Integer id) {
		System.err.println("::::::" + id);
		return serviceConfigMapRepository.findById(id);
	}

	@DeleteMapping("/serviceConfigMap/{id}")
	public void deleteServiceByID(@PathVariable int id) {
		serviceConfigMapRepository.deleteById(id);
	}

	@PutMapping(value = "/serviceConfigMap")
	public void updateService(@RequestBody ServiceConfigMap serviceConfigMap) {
		serviceConfigMapRepository.save(serviceConfigMap);
	}

	@PostMapping("/serviceConfigMap")
	public void createService(@RequestBody ServiceConfigMap serviceConfigMap) {
		serviceConfigMapRepository.save(serviceConfigMap);

		BusinessServiceConfig businessServiceConfig = new BusinessServiceConfig();
		businessServiceConfig.setBusinessServiceType(serviceConfigMap);
		businessServiceConfig.setName(serviceConfigMap.getName());
		businessServiceConfig.setDefaultService(true);
	}

	@GetMapping("/serviceConfigMap/listQueuries/{id}")
	public QueryModel getServiceQuery(@PathVariable int id) {
		String query = "";
		BusinessServiceConfig config = null;
		ServiceConfigMap map = serviceConfigMapRepository.getOne(id);

		if (map != null)
			config = businessServiceConfigRepository.findByBusinessServiceType(map);

		if (config != null) {
			query += map.toString() + "\n" + config.toString() + "\n";

			Set<BusinessServiceStep> steps = config.getSteps();

			for (BusinessServiceStep businessServiceStep : steps) {
				query += businessServiceStep.toString() + "\n";

				Service service = businessServiceStep.getService();

				query += service.toString() + "\n";
			}
		}

		QueryModel model=new QueryModel();
		model.setQueryBody(query);
		System.err.println(query);

		return model;

	}

}
