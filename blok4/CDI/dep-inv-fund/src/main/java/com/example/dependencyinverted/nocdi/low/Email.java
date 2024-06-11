package com.example.dependencyinverted.nocdi.low;

import com.example.dependencyinverted.nocdi.high.Sendable;

import static com.example.dependencyinverted.cdi.util.Util.OK;

// Low level module, depends on high level Sendable
public class Email implements Sendable {

    private String run() {
        System.out.println("sending email.....");
        // ....
        return "Email" + OK;
    }

    @Override
    public String send() {
        return run();
    }
}
