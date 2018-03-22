package com.igi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igi.entities.User;
import com.igi.repositories.UserRepository;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepository;

	@PostMapping("/user")
	public void createUser(@RequestBody User user) {
		logger.info("Save User :{}", user);
		userRepository.save(user);
	}

	@PutMapping("/user")
	public void updateUser(@RequestBody User user) {
		try
		{
			System.err.println("asasas");

		logger.info("Update User :{}",user);
		userRepository.save(user);
		}catch(Exception ex) {ex.printStackTrace();}
	}

	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable Long id) {
		userRepository.delete(id);
		return true;
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id) {

		User user = userRepository.findOne(id);
		logger.info("Get user:{}", user);
		return user;
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
