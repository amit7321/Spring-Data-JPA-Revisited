package com.example.springdatajparevisited.jpa.repository;

import com.example.springdatajparevisited.jpa.entity.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;

@Repository
public class CourseJpaRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

}
