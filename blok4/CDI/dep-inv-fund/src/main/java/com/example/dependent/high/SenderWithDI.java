package com.example.dependent.high;

// A. Inversion of Control (IoC):
//      Laat je dependencies (objecten) instantiëren en aanleveren door iemand anders.
//      Dependency injection is een vorm van IoC.

// B. The Dependency Inversion principle states that:
//      1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
//      2. Abstractions should not depend on details. Details should depend on abstractions.

import com.example.dependent.low.Email;
import com.example.dependent.low.Sms;

// High level module
// See Main and test class
public class SenderWithDI {

    // violation of 1.; hard to maintain and extend
    private Email email; // DI via field injection
    private Sms sms;

    public SenderWithDI() {
    }

    // A. Inversion of control: new is gone. Let someone else supply the object(s) either:

    // 1) DI via ctor
    public SenderWithDI(Email email, Sms sms) {
        this.email = email;
        this.sms = sms;
    }

    // 2) DI via setters
    public void setEmail(Email email) {
        this.email = email;
    }

    public void setSms(Sms sms) {
        this.sms = sms;
    }

    public String sendAll() {
        // violation of 2.; hard to maintain and extend
        return email.run() + ", " + sms.stuur();
    }
}
