package com.example.springdatajparevisited.jpa.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springdatajparevisited.jpa.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
@NamedQuery(name = "find_all_person", query = "select p from Person p")
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(Integer id) {
        Person person = entityManager.find(Person.class, id);
        return person;
    }

    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_person", Person.class);
        return namedQuery.getResultList();
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(int id) {
        Person person = findById(id);
        entityManager.remove(person);
    }
}
