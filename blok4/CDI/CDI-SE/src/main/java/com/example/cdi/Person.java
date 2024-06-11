package com.example.cdi;

import javax.enterprise.inject.Vetoed;

@Vetoed // since bean discovery mode = all, we don't want this class to get picked up by CDI
public class Person {
    public String name;

    public Person() { }

    public Person(String name) {
        this.name = name;
    }

}
