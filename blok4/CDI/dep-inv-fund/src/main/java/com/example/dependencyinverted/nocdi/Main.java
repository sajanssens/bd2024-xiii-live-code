package com.example.dependencyinverted.nocdi;

import com.example.dependencyinverted.nocdi.high.Sender;
import com.example.dependencyinverted.nocdi.low.Email;
import com.example.dependencyinverted.nocdi.low.Sms;

// Do It Yourself DI, just like CDI does.
public class Main {

    public static void main(String[] args) {
        // create dependencies:
        Email e = new Email();
        Sms s = new Sms();

        // inject them via constructor injection:
        Sender sender = new Sender(e, s);
        System.out.println(sender.sendAll());

        // inject another via setter injection (here plugin(..)):
        Email e2 = new Email();
        sender.plugin(e2);
        System.out.println(sender.sendAll());
    }
}
