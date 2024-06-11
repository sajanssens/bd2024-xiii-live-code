package com.example.cdi.greetings;

import javax.enterprise.inject.Alternative;

@Alternative // not loaded, unless explicitly selected in beans.xml
// @Priority(20) // used when more than one alternatives are loaded; overwrites default bean...
public class AltGreeting implements IGreeting {
    @Override public String greet(String name) { return "Mock " + name; }
}