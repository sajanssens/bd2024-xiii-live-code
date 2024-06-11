package com.example.cdi.greetings;

import com.example.cdi.greetings.qualifiers.EN;

import javax.enterprise.inject.Default;

@EN
@Default
public class ENGreeting implements IGreeting {
    @Override public String greet(String name) { return "Hello " + name; }
}