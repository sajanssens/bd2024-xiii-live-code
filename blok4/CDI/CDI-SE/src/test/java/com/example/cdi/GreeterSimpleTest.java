package com.example.cdi;

import com.example.cdi.greetings.ENGreeting;
import com.example.cdi.observer.nieuwsbrief.Bedrijf;
import com.example.cdi.observer.nieuwsbrief.Computer;
import com.example.cdi.observer.nieuwsbrief.Persoon;
import com.example.cdi.producers.LoggerProducer;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@EnableAutoWeld
@AddBeanClasses(GreeterSimple.class)
@AddBeanClasses(LoggerProducer.class)
@AddBeanClasses(ENGreeting.class)
@AddBeanClasses({Bedrijf.class, Computer.class, Persoon.class})
class GreeterSimpleTest {

    @Inject private GreeterSimple target;

    @Test
    void hi() {
        String hi = target.hi();
        assertThat(hi, containsString("Hello"));
    }

    @Test
    void nieuweNieuwsbrief() {
        target.nieuweNieuwsbrief("Donald Duck is vernieuwd!");
    }
}
