package com.example.demo.controller;

import com.example.demo.repository.model.Person;
import com.example.demo.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.PersonService;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String index(Model model) {
        List<Person> Persons= personService.getPersonSortedByAge();
        model.addAttribute("persons",Persons);
        return "index";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getPersonById(@PathVariable("id") String id) {
        Person person=personService.getPersonById(id);
        if (person!=null)
            return "Id: "+person.getId().toString()+"<br>Name: "+person.getName().toString()+"<br>Age: "+Integer.toString(person.getAge())+"<br>Favorite: "+person.getFavorite().toString();
        return "not have this person";
    }
}
