package com.example.dependencyinverted.cdi;

import com.example.dependencyinverted.cdi.util.Boot;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class App {

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        Boot boot = container.select(Boot.class).get(); // CDI container managed bean
        // Boot boot = new Boot(); // app managed bean
        boot.go();
    }
}
