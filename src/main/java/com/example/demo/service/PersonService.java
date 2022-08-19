package com.example.demo.service;

import com.example.demo.repository.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> sortPersonByAge(List<Person> Persons);

    List<Person> getPersonSortedByAge();

    Person getPersonById(String Id);
}
