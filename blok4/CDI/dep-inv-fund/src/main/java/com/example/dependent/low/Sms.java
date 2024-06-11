package com.example.dependent.low;

import static com.example.dependencyinverted.cdi.util.Util.OK;

// Low level module
public class Sms {

    public String stuur() {
        System.out.println("sending sms.....");
        // ....
        return OK;
    }
}
