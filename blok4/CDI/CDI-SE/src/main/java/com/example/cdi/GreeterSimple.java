package com.example.cdi;

import com.example.cdi.greetings.IGreeting;
import com.example.cdi.observer.nieuwsbrief.Nieuwsbrief;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Dependent
public class GreeterSimple {

    @Inject IGreeting iGreeting;

    public String hi() { return iGreeting.greet("Bram"); }

    @Inject @Any Event<Nieuwsbrief> nieuwsbriefEvent;

    public void nieuweNieuwsbrief(String inhoud) {
        Nieuwsbrief n = new Nieuwsbrief(inhoud);
        nieuwsbriefEvent.fire(n);
    }

}
