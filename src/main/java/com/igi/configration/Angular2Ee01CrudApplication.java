package com.igi.configration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.igi.entities.BusinessServiceConfig;
import com.igi.entities.BusinessServiceStep;
import com.igi.entities.Service;
import com.igi.entities.ServiceConfigMap;
import com.igi.repositories.BusinessServiceConfigRepository;
import com.igi.repositories.BusinessServiceStepRepository;
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
	BusinessServiceStepRepository businessServiceStepRepository;
	
	@Autowired
	BusinessServiceConfigRepository businessServiceConfigRepository;

	public static void main(String[] args) {
		SpringApplication.run(Angular2Ee01CrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		BusinessServiceConfig conf=new BusinessServiceConfig();
//		conf.setId((long) 502022);
		conf.setName("Conf");
		ServiceConfigMap map=new ServiceConfigMap();
		map.setId(24);
		conf.setBusinessServiceType(map);
		
//		businessServiceConfigRepository.save(conf);
//		tod
		
//		BusinessServiceStep step = new BusinessServiceStep();
//		step.setService(new Service((long) 123213123, null, null));
//		step.setDescription("wawa1");
//		
//		
//		step=businessServiceStepRepository.save(step);

	}
}
