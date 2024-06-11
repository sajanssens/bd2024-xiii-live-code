package com.example.cdi;

import com.example.cdi.observer.person.PersonFirer;
import com.example.cdi.observer.person.PersonListener;
import com.example.cdi.producers.LoggerProducer;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@EnableAutoWeld // CDI container, not for EJB's.
@AddBeanClasses(PersonFirer.class)
@AddBeanClasses(PersonListener.class)
@AddBeanClasses(LoggerProducer.class)
class PersonFirerIT {

    @Inject private PersonFirer target;

    @Test
    void fireEvent() {
        target.fireEvent();
    }
}
