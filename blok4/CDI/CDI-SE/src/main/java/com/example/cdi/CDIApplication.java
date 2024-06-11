package com.example.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CDIApplication {

    private static final Logger logger = LoggerFactory.getLogger(CDIApplication.class);

    public static void main(String[] args) {

        // CDI < 2.0 (JEE7)
        // Container is hard coded to be Weld.
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        // CDI 2.0 (portable bootstrap API) (JEE8)
        // Container will be weld since it sits on the classpath; when omitted, no CDI-container will be found.
        // DisableDiscovery ignores beans.xml; classes can be added manually.
        // SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        // SeContainer container2 = initializer.disableDiscovery().addPackages(CDIApplication.class).initialize();

        GreeterSimple greeterSimple = container.select(GreeterSimple.class).get();
        String hi = greeterSimple.hi();
        System.out.println("Default simple greeting: " + hi);

        greeterSimple.nieuweNieuwsbrief("Nieuws van week 23: ...");

        // 1) call bean method to check its dependencies.
        MyService myService = container.select(MyService.class).get();
        logger.info(myService.doeIets());

        // 2) create and call several beans to check their state.
        MyServiceStateful myServiceStateful = container.select(MyServiceStateful.class).get();
        MyServiceStateful myServiceStateful2 = container.select(MyServiceStateful.class).get();
        MyService myService2 = container.select(MyService.class).get();

        myServiceStateful.logGreeterState();
        myServiceStateful2.logGreeterState();
        myService.logGreeterState();
        myService2.logGreeterState();

        container.close();
    }
}
