package com.example.Pharmacie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.example.Pharmacie.repository")
@ComponentScan(basePackages = "com.example.Service")
@SpringBootApplication
public class PharmacieApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacieApplication.class, args);
	}

}
