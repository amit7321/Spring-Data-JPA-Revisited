package com.example.springdatajparevisited;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SpringBootTest
class SpringDataJpaRevisitedApplicationTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;

	@Test
	public void native_query_basics() {
		Query query = entityManager.createNativeQuery("select * from course where id = :id");
		query.setParameter("id", 500L);
		List resultList = query.getResultList();
		logger.info("query",resultList);
	}

}
