package com.example.cdi;

import com.example.cdi.greetings.ENGreeting;
import com.example.cdi.greetings.GreetingDecorator;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class GreeterSimpleDecoTest {

    private GreeterSimple greeterSimple;

    @Before
    public void setUp() {
        try (WeldContainer container = new Weld().disableDiscovery()
                .addBeanClass(GreeterSimple.class)
                .addBeanClass(ENGreeting.class)
                .addBeanClass(GreetingDecorator.class)
                .addDecorator(GreetingDecorator.class) // as if you add it to beans.xml as decorator
                .initialize()) {
            greeterSimple = container.select(GreeterSimple.class).get();
        }
    }

    @Test
    public void hiContainsDecoratedGreeting() {
        String hi = greeterSimple.hi();
        System.out.println(hi);

        assertThat(hi, containsString("from GreetingDecorator"));
    }
}
