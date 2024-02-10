package com.example.springdatajparevisited.jpa;



import com.example.springdatajparevisited.jpa.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
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
}
