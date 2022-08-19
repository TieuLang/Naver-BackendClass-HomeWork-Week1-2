package com.example.demo.service.impl;

import com.example.demo.repository.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.service.PersonService;
import com.example.demo.repository.PersonRepository;

import java.util.*;

@Service
@Component
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> sortPersonByAge(List<Person> Persons) {
        boolean check=true;
        int exp=1;
        int count[]=new int[200];
        for (int i=0;i<Persons.size();++i)
            ++count[Persons.get(i).getAge()];
        for (int i=1;i<count.length;++i)
            count[i]+=count[i-1];
        List<Person> sortedPersons=new ArrayList<>(Persons);
        for (int i=0;i<Persons.size();++i) {
            sortedPersons.set((count[Persons.get(i).getAge()]--)-1, Persons.get(i));
        };
        return sortedPersons;
    }

    @Override
    public List<Person> getPersonSortedByAge() {
        List<Person> sortedPersons=sortPersonByAge(personRepository.getAllPerson());
        personRepository.setPersons(sortedPersons);
        return sortedPersons;
    }

    @Override
    public Person getPersonById(String Id) {
        return personRepository.getPersonByID(Id);
    }
}
