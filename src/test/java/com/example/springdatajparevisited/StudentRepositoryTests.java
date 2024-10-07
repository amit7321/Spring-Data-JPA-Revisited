package com.example.springdatajparevisited;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdatajparevisited.jpa.entity.Passport;
import com.example.springdatajparevisited.jpa.repository.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
class StudentRepositoryTests{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;

	@Autowired
	StudentRepository studentRepository;

	@Test
	@Transactional
	public void retrievePassportAndStudent() {
		Passport passport = entityManager.find(Passport.class, 2001L);
		logger.info("passport -> {}", passport);
		logger.info("student -> {}", passport.getStudent());
	}

}
