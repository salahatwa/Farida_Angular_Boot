package com.igi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.igi.entities.Country;
import com.igi.entities.User;
import com.igi.repositories.CountryRepository;
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
	
	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Angular2Ee01CrudApplication.class, args);
	}

	
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User(11L, "salah", "atwa", 24));
		userRepository.save(new User(21L, "salah2", "atwa2", 24));
		userRepository.save(new User(31L, "salah3", "atwa2", 25));
		
		
		countryRepository.save(new Country(1L, "Egypt", "+024"));
		countryRepository.save(new Country(2L, "Egypt3", "+024"));
		countryRepository.save(new Country(3L, "Egypt2", "+024"));
		countryRepository.save(new Country(4L, "Egypt1", "+024"));
		countryRepository.save(new Country(11L, "Egysdt", "+024"));
		countryRepository.save(new Country(21L, "Egypsdt3", "+024"));
		countryRepository.save(new Country(31L, "Egypxct2", "+024"));
		countryRepository.save(new Country(41L, "Egyzxpt1", "+024"));
		countryRepository.save(new Country(141L, "Ezxypt", "+024"));
		countryRepository.save(new Country(412L, "Egypt3", "+024"));
		countryRepository.save(new Country(853L, "Egzxypt2", "+024"));
		countryRepository.save(new Country(465L, "Egypt1", "+024"));
		countryRepository.save(new Country(101L, "Egzxypt", "+024"));
		countryRepository.save(new Country(452L, "Egyzzpt3", "+024"));
		countryRepository.save(new Country(354L, "Egzxpt2", "+024"));
		countryRepository.save(new Country(4457L, "Egcxzypt1", "+024"));
		countryRepository.save(new Country(4454L, "Egypt", "+024"));
		countryRepository.save(new Country(2560L, "Egypt3", "+024"));
		countryRepository.save(new Country(3404L, "Egypt2", "+024"));
		countryRepository.save(new Country(4974L, "Egypt1", "+024"));
		countryRepository.save(new Country(14750L, "Egypt", "+024"));
		countryRepository.save(new Country(7502L, "Egypt3", "+024"));
		countryRepository.save(new Country(4503L, "Egypt2", "+024"));
		countryRepository.save(new Country(547024L, "Egypt1", "+024"));
		
	}
}

