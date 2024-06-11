package com.example.cdi.producers;

import com.example.cdi.Person;

import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Singleton
public class PersonProducer {

    @Produces
    public Person getSpecialPerson(@New Person p) {
        p.name = "Special";
        return p;
    }
}
