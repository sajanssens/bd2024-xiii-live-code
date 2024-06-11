package com.infosupport.cdi.welddemo;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Start {

    public static void main(String[] args) throws InterruptedException {
        // CDI = Contexts and Dependency Injection
        //          Contexts is/was voor als je Front End in Java schrijft,
        //          tegenwoordig vaak in JS, dus Contexts gebruiken we (bijna) niet meer.
        //      = specificatie, verzameling interfaces

        // Weld = Implementatie = DI engine / DI container.
        //  Kan: 1) instanties van al mijn eigen klasses aanmaken of van andere klasses via @Produces-methode(s)
        //       2) instanties injecteren in andere klasses (@Inject)
        //          voorwaarde: de andere klasse moet zélf ook door stap 1 zijn aangemaakt, i.e. door Weld gemanaged zijn.

        try (WeldContainer weldContainer = new Weld().initialize()) {
            App app = weldContainer.select(App.class).get(); // vanaf nu kan ik in App en zijn dependencies (dao) @Inject gebruiken.
            app.start();

            App3 app3 = weldContainer.select(App3.class).get(); // vanaf nu kan ik in App en zijn dependencies (dao) @Inject gebruiken.
            app3.start();
        }
    }
}
