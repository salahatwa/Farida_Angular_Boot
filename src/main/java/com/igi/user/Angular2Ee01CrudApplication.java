package com.igi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.igi.entities.User;
import com.igi.repositories.UserRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EntityScan("com.igi.entities")
@ComponentScan(basePackages = "com.igi.controller")
@EnableJpaRepositories("com.igi.repositories")
@EnableSwagger2
@Import(WebConfiguration.class)
public class Angular2Ee01CrudApplication implements CommandLineRunner {
	

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Angular2Ee01CrudApplication.class, args);
	}

	
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User(11L, "salah", "atwa", 24));
		userRepository.save(new User(21L, "salah2", "atwa2", 24));
		userRepository.save(new User(31L, "salah3", "atwa2", 25));
	}
}

