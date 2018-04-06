package com.igi.configration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.igi.repositories.TodoRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan("com.igi.entities")
@ComponentScan(basePackages = "com.igi.controller")
@EnableJpaRepositories("com.igi.repositories")
//@EnableSwagger2
//@EnableAutoConfiguration
// @Import(WebConfiguration.class)
public class Angular2Ee01CrudApplication implements CommandLineRunner {
	
	@Autowired
	TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Angular2Ee01CrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		tod

	}
}
