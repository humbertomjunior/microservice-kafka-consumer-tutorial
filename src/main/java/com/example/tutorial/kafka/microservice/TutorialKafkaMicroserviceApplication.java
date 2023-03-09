package com.example.tutorial.kafka.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class TutorialKafkaMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialKafkaMicroserviceApplication.class, args);
	}

}
