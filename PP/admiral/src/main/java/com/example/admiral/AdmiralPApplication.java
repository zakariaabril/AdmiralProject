package com.example.admiral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AdmiralPApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmiralPApplication.class, args);
	}

}
