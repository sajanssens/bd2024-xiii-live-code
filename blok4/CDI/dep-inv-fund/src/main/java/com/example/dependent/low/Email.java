package com.example.dependent.low;

import static com.example.dependencyinverted.cdi.util.Util.OK;

// Low level module
public class Email {

    public String run() {
        System.out.println("sending email.....");
        // ....
        return OK;
    }

}
