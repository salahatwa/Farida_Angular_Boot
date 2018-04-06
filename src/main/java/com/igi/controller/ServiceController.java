package com.igi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.igi.entities.Service;
import com.igi.repositories.ServiceRepositpory;

/**
 * Parent Service
 * 
 * @author salah
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(value = "http://localhost:4200", allowedHeaders = "*")
public class ServiceController {

	@Autowired
	private ServiceRepositpory serviceRepositpory;

	@GetMapping("/services")
	public List<Service> getAllServices() {
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "id");
		return serviceRepositpory.findAll(sortByCreatedAtDesc);
	}

	@GetMapping("/service/{id}")
	public @ResponseBody Optional<Service> getServiceByID(@PathVariable long id) {
		return serviceRepositpory.findById(id);
	}

	@DeleteMapping("/service/{id}")
	public ResponseEntity<?> deleteServiceByID(@PathVariable long id) {
		try {
			serviceRepositpory.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping(value = "/service")
	public ResponseEntity<Service> updateService(@Valid @RequestBody Service service) {
		try {
			Service updatedService = serviceRepositpory.save(service);

			return ResponseEntity.ok().body(updatedService);
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/service")
	public Service createService(@Valid @RequestBody Service service) {
		return serviceRepositpory.save(service);
	}

}
