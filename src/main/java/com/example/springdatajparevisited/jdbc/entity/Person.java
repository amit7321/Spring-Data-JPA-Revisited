package com.example.springdatajparevisited.jdbc.entity;

import java.util.Date;

public class Person {

    private int id;
    private String name;
    private String location;
    private Date birth_day;

    public Person(int id, String name, String location, Date birth_day) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birth_day = birth_day;
    }

    public Person() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(Date birth_day) {
        this.birth_day = birth_day;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birth_day +
                '}';
    }
}

