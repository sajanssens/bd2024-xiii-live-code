package com.example.dependencyinverted.nocdi.high;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

// High level module
// See Main and test class
public class Sender {

    // Satisfies:
    // 1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
    // No references to Email and Sms anymore.
    private final List<Sendable> sendables = new ArrayList<>();

    public Sender(Sendable... s) { sendables.addAll(Arrays.asList(s)); }

    // Inversion of Control:
    public void plugin(Sendable s) {
        // Satisfies:
        // 2. Abstractions should not depend on details. Details should depend on abstractions.

        // Inversion of control: new is gone. Let someone else supply the object(s)
        sendables.add(s);
    }

    public String sendAll() {
        String result = "";
        for (Sendable sendable : sendables) {
            String s = sendable.send();
            result = result + s;
        }
        return result;
        // return sendables.stream()
        //         .map(Sendable::send)
        //         .collect(joining(", "));
    }

    public <S extends Sendable> String send(Class<S> type) {
        return sendables.stream()
                .filter(s -> s.getClass().equals(type))
                .map(Sendable::send)
                .collect(joining(", "));
    }
}
