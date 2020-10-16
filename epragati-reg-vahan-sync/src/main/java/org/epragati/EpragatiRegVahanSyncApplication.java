package org.epragati;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;


@EnableScheduling
@SpringBootApplication
//@EnableJpaRepositories({"org.epragati.*"})
@EnableAutoConfiguration
@EnableJpaAuditing
@Configuration
@EntityScan({ "org.epragati.*" })
@ComponentScan(basePackages={"org.epragati.*"}) 

public class EpragatiRegVahanSyncApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(EpragatiRegVahanSyncApplication.class, args);
	}
	
	@Bean(name = "restTemplate")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
