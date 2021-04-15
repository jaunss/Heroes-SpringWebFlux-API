package com.joaogcm.api.herois.marvel;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class SuperHeroisMarvelApplication {
	public static void main(String[] args) {
		SpringApplication.run(SuperHeroisMarvelApplication.class, args);
		System.out.println("Super poderes com WebFlux");
	}
}