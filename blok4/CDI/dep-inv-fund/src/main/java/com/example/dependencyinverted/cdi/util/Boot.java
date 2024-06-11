package com.example.dependencyinverted.cdi.util;

import com.example.dependencyinverted.cdi.high.Sender;
import jakarta.inject.Inject;
import org.slf4j.Logger;

public class Boot {

    @Inject Logger log;
    @Inject Sender sender;

    public void go() {
        // sender.addSendable(new Email());
        String s = sender.sendAll();
        log.info(s);
    }
}
