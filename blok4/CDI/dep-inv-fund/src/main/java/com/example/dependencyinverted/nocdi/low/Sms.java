package com.example.dependencyinverted.nocdi.low;

import com.example.dependencyinverted.nocdi.high.Sendable;

import static com.example.dependencyinverted.cdi.util.Util.OK;

// Low level module, depends on high level Sendable
public class Sms implements Sendable {

    private String stuur() {
        System.out.println("sending sms.....");
        // ....
        return "Sms" + OK;
    }

    @Override
    public String send() {
        return stuur();
    }
}
