package com.example.cdi;

import javax.inject.Inject;

// @Dependent
public class MyService {

    @Inject // example of field injection
    private Greeter greeter;

    public String doeIets() { return greeter.hi(); }

    public void logGreeterState() { greeter.logNumbers(); }

}
