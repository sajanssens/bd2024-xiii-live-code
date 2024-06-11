package com.example.cdi.greetings;

import javax.enterprise.inject.Alternative;

@Alternative // not loaded, unless explicitly selected in beans.xml
// @Priority(10) // used when more than one alternatives are loaded; overwrites default bean...
public class AltGreetingLowPrio implements IGreeting {
    @Override public String greet(String name) { return "M2ck " + name; }
}