package com.example.cdi.observer.person;

import com.example.cdi.Person;
import org.slf4j.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class PersonListener {

    @Inject Logger log;

    public void handleEvent(@Observes Person p) {
        log.info("Event caught: " + p.name);
    }
}
