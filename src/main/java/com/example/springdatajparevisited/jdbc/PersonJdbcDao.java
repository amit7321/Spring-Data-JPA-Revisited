package com.example.springdatajparevisited.jdbc;

import com.example.springdatajparevisited.jdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id = ?", new Object[]{id});
    }

    public int updatePerson(Person person) {
        return jdbcTemplate.update("update person set name = ?, location = ?, birth_day = ? where id = ?",
                new Object[]{person.getName(), person.getLocation(), new Timestamp(person.getBirth_day().getTime()), person.getId()});
    }
}