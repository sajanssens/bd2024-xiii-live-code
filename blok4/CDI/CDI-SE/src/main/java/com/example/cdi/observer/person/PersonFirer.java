package com.example.cdi.observer.person;

import com.example.cdi.Person;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

public class PersonFirer {

    // See test for demo.

    @Inject @Any Event<Person> personEvent;

    public void fireEvent() {
        personEvent.fire(new Person("I'm fired!"));
    }

}
