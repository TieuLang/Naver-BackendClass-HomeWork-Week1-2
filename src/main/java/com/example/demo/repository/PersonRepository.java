package com.example.demo.repository;

import com.example.demo.repository.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@Component
public class PersonRepository {
    private List<Person> Persons;

    @PostConstruct
    public void initPersons(){
        Persons=new ArrayList<>();
        Persons.add(new Person("002","Vu",23,Arrays.asList("Game","Music")));
        Persons.add(new Person("004","Thang",12,Arrays.asList("Game","Sport")));
        Persons.add(new Person("001","Hieu",42,Arrays.asList("Swimming","Music")));
        Persons.add(new Person("003","Nghia",33,Arrays.asList("Game","Music")));
        Persons.add(new Person("005","Phong",20,Arrays.asList("Game","Music")));
    }

    public List<Person> getAllPerson()
    {
        return Persons;
    }

    public Person getPersonByID(String Id)
    {
        for (int i=0;i<Persons.size();++i) {
            String temp = Persons.get(i).getId();
            if (Persons.get(i).getId().compareTo(Id)==0) return Persons.get(i);
        };
        return null;
    }

    public void setPersons(List<Person> Persons)
    {
        this.Persons=Persons;
    }
}
