package com.igi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
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
import com.igi.entities.BusinessServiceStep;
import com.igi.repositories.BusinessServiceStepRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "http://localhost:4200", allowedHeaders = "*")
public class BusinessServiceStepsController {

	@Autowired
	private BusinessServiceStepRepository businessServiceStepRepository;

	@GetMapping("/step/all")
	public Iterable<BusinessServiceStep> getAllSteps() {
		return businessServiceStepRepository.findAll();
	}

	@GetMapping("/step/{id}")
	public Optional<BusinessServiceStep> getStepByID(@PathVariable long id) {
		System.err.println("::::::" + id);
		return businessServiceStepRepository.findById(id);
	}

	@DeleteMapping("/step/{id}")
	public ResponseEntity<?> deleteStepByID(@PathVariable long id) {
		try {
			businessServiceStepRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping(value = "/step")
	public void updateStep(@RequestBody BusinessServiceStep step) {
		businessServiceStepRepository.save(step);
	}

	@PostMapping("/step")
	public BusinessServiceStep createStep(@RequestBody BusinessServiceStep step) {

		System.err.println(step.toString());
		return businessServiceStepRepository.save(step);
	}

}
