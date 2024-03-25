package com.infosupport.cdi.welddemo;

import jakarta.inject.Inject;

public class App {

    @Inject
    private Screen screen;

    void start() {
        this.screen.print();
    }
}
