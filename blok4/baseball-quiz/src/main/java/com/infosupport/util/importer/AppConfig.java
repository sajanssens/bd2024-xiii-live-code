package com.infosupport.util.importer;

import jakarta.ejb.Singleton;
import jakarta.enterprise.inject.Produces;
import jakarta.jms.Queue;

@Singleton
public class AppConfig {

    @Produces
    public Queue testQueue() {
        return () -> "testQueue";
    }
}
