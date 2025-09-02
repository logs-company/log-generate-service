package com.math12.log_generate_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LogGenerateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogGenerateServiceApplication.class, args);
	}

}
