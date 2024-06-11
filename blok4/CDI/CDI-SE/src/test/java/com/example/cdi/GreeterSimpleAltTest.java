package com.example.cdi;

import com.example.cdi.greetings.AltGreeting;
import com.example.cdi.greetings.AltGreetingLowPrio;
import com.example.cdi.greetings.ENGreeting;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class GreeterSimpleAltTest {

    private GreeterSimple greeterSimple;

    @Before
    public void setUp() {
        try (WeldContainer container = new Weld().disableDiscovery()
                .addBeanClass(GreeterSimple.class)
                .addBeanClass(ENGreeting.class)
                .addBeanClass(AltGreeting.class)
                .addBeanClass(AltGreetingLowPrio.class)
                .addAlternative(AltGreeting.class) // as if you add it to beans.xml as <alternative>
                // .addAlternative(AltGreetingLowPrio.class) // needs priority, but that overwrites default...
                .initialize()) {
            greeterSimple = container.select(GreeterSimple.class).get();
        }
    }

    @Test
    public void hiContainsMock() {
        assertThat(greeterSimple.hi(), containsString("Mock"));
    }
}