package com.example.springdatajparevisited.jpa;



import com.example.springdatajparevisited.jpa.entity.Person;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

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
