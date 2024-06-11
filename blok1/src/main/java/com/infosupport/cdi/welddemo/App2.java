package com.infosupport.cdi.welddemo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class App2 {

    private Screen screen;

    @Inject // 2: ctor injection
    public App2(Screen screen) {
        this.screen = screen;
    }

    void start() {
        this.screen.print();
    }
}
