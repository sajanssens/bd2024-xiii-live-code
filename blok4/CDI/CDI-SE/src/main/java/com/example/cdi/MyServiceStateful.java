package com.example.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MyServiceStateful {

    @Inject // example of field injection
    private Greeter greeter;

    public String doeIets() {
        return greeter.hi();
    }

    public void logGreeterState() {
        greeter.logNumbers();
    }

}
