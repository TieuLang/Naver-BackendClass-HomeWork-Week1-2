package com.example.demo.repository.model;

import java.util.List;

public class Person {
    private String Id, Name;
    private int Age;
    private List<String> Favorite;

    public Person(String Id, String Name, int Age, List<String> Favorite) {
        this.Id = Id;
        this.Name = Name;
        this.Age = Age;
        this.Favorite = Favorite;
    }

    public int getAge()
    {
        return this.Age;
    }

    public String getId()
    {
        return this.Id;
    }

    public String getName()
    {
        return this.Name;
    }

    public String getFavorite()
    {
        String temp="";
        for (int i=0;i<this.Favorite.size()-1;++i)
            temp=temp+this.Favorite.get(i).toString()+", ";
        temp=temp+this.Favorite.get(this.Favorite.size()-1).toString()+".";
        return temp;
    }
}
