package com.example.cdi.greetings;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

//Also defined in the beans.xml
@Decorator
public class GreetingDecorator implements IGreeting {

    @Inject
    @Delegate @Any
    IGreeting greeting;

    @Override
    public String greet(String name) { return greeting.greet(name + " from GreetingDecorator"); }

}