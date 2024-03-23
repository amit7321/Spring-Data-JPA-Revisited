package com.example.springdatajparevisited.jpa;

import com.example.springdatajparevisited.jpa.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(Integer id) {
        Person person = entityManager.find(Person.class, id);
        return person;
    }

    public Person update(Person person) {
         return entityManager.merge(person);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public void delete(int id) {
        Person person =  findById(id);
        entityManager.remove(person);
    }

}
