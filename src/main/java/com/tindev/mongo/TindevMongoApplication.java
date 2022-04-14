package com.tindev.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TindevMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TindevMongoApplication.class, args);
	}

}
