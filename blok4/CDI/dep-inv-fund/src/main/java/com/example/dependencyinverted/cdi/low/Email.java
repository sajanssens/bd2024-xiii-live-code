package com.example.dependencyinverted.cdi.low;

import com.example.dependencyinverted.cdi.high.Sendable;
import com.example.dependencyinverted.cdi.util.EMAIL;
import jakarta.enterprise.inject.Default;

import static com.example.dependencyinverted.cdi.util.Util.OK;

@EMAIL @Default
public class Email implements Sendable {

    private String run() {
        System.out.println("sending email.....");
        // ....
        return OK;
    }

    @Override
    public String send() {
        return run();
    }
}
