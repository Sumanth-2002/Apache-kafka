package com.example.exit_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ExitServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExitServiceApplication.class, args);
	}

}
