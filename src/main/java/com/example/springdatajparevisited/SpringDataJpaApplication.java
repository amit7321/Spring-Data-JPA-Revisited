package com.example.springdatajparevisited;

import com.example.springdatajparevisited.jpa.PersonJpaRepository;
import com.example.springdatajparevisited.jpa.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Users -> {}", personJpaRepository.insert(new Person("amit", "Dhaka", new Date())));
		logger.info("All users -> {}", personJpaRepository.update(new Person("amit", "rangpur", new Date())));
	}

}
