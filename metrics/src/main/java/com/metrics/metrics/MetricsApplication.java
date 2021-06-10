package com.metrics.metrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.metrics.metrics.repository") 
public class MetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetricsApplication.class, args);
	}

}
