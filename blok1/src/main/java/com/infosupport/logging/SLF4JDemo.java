package com.infosupport.logging;

import com.github.javafaker.Faker;
import com.infosupport.logging.special.SomethingElse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JDemo {

    private final Logger log = LoggerFactory.getLogger(SLF4JDemo.class);

    public static void main(String[] args) {
        new SLF4JDemo().start();
    }

    private void start() {
        log.error("Er ging iets vreselijk mis....");
        log.warn("waarschuwing!!");
        log.info("human readable voor service desk"); // servicedesk
        log.debug("voor developer");
        log.trace("zeer gedetailleerde info");

        String character = new Faker().aquaTeenHungerForce().character();

        new SomethingElse().doeIets();
    }
}
