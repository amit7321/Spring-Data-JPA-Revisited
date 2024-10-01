package com.example.springdatajparevisited.jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springdatajparevisited.jpa.entity.Passport;
import com.example.springdatajparevisited.jpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager entityManager;

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            entityManager.persist(student);
        } else {
            entityManager.merge(student);
        }

        return student;
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("z1244324");
        Student student = new Student("Mile");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    /*     public void playWithEntiyManager() {
        Student student1 = new Student("web services in 100 steps");
        entityManager.persist(student1);
        student1.setName("web services in 50 steps - updated");
        entityManager.flush();

        Student student2 = new Student("name of course2 is course2");
        entityManager.persist(student2);

        entityManager.clear();

        entityManager.detach(student2);

        student2.setName("name of course2 is course2 - updated");
        entityManager.flush();
    } */
}
