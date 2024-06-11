package com.example.dependent;

import com.example.dependent.high.SenderWithDI;
import com.example.dependent.low.Email;
import com.example.dependent.low.Sms;

// Do It Yourself DI, just like CDI does.
public class Main {

    public static void main(String[] args) {
        // create dependencies:
        Email e = new Email();
        Sms s = new Sms();

        // inject them via constructor injection:
        SenderWithDI sender1 = new SenderWithDI(e, s);
        System.out.println(sender1.sendAll());

        // inject them via setter injection:
        SenderWithDI sender2 = new SenderWithDI();
        sender2.setEmail(e);
        sender2.setSms(s);
        System.out.println(sender2.sendAll());
    }

}
