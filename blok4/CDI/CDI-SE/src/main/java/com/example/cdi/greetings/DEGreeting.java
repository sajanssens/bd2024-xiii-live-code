package com.example.cdi.greetings;

import com.example.cdi.greetings.qualifiers.DE;

@DE
public class DEGreeting implements IGreeting {
    @Override public String greet(String name) {
        return "Gutentag " + name;
    }
}