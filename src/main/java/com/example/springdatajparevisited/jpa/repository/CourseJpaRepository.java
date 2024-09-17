package com.example.springdatajparevisited.jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdatajparevisited.jpa.entity.Course;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class CourseJpaRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }

        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public void playWithEntiyManager() {
        Course course1 = new Course("web services in 100 steps");
        entityManager.persist(course1);
        course1.setName("web services in 50 steps - updated");
        entityManager.flush();

        Course course2 = new Course("name of course2 is course2");
        entityManager.persist(course2);

        entityManager.clear();

        entityManager.detach(course2);

        course2.setName("name of course2 is course2 - updated");
        entityManager.flush();
    } 

}
