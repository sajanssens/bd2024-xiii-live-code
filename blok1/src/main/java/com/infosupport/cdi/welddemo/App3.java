package com.infosupport.cdi.welddemo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class App3 {

    private Screen screen;

    @Inject
    private List<Integer> lijstje;

    void start() {
        this.screen.print();
    }

    @Inject // 3: setter injection
    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
