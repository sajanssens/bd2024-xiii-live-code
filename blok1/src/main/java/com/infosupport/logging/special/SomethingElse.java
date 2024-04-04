package com.infosupport.logging.special;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SomethingElse {
    private final Logger log = LoggerFactory.getLogger(SomethingElse.class);

    public void doeIets() {
        int i = 42;
        log.debug("We gaan iets leuks doen... i is " + i);
    }
}
