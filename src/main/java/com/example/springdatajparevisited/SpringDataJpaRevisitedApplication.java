package com.example.springdatajparevisited;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.example.springdatajparevisited.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringDataJpaRevisitedApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	//@Autowired
	PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaRevisitedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", personJdbcDao.findAll());
		logger.info("Users -> {}", personJdbcDao.findById(1001));
		logger.info("deleted user -> {}", personJdbcDao.deleteById(1000));
	}
}
