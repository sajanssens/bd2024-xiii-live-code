package com.example.dependencyinverted.cdi.low;

import com.example.dependencyinverted.cdi.high.Sendable;
import com.example.dependencyinverted.cdi.util.SMS;

// @Alternative
@SMS
public class Sms implements Sendable {

    private String stuur() {
        System.out.println("sending sms.....");
        // ....
        return "SMS is sent!";
    }

    @Override
    public String send() {
        return stuur();
    }
}

