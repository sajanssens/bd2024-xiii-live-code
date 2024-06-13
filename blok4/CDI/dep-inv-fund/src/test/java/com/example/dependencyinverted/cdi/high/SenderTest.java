package com.example.dependencyinverted.cdi.high;

import com.example.dependencyinverted.cdi.low.Email;
import com.example.dependencyinverted.cdi.low.Sms;
import com.example.dependencyinverted.cdi.util.LoggerProducer;
import jakarta.inject.Inject;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static com.example.dependencyinverted.cdi.util.Util.OK;
import static org.assertj.core.api.Assertions.assertThat;

@EnableAutoWeld
@AddBeanClasses({Sender.class, Email.class, Sms.class, LoggerProducer.class})
class SenderTest {

    // See src/main/resources/img/DependencyInversion.png

    @Inject private Logger log;
    @Inject private Sender target;

    @Test
    void hello() { log.info("Hello!"); }

    @Test
    void go() {
        String s = target.sendAll();
        assertThat(s).contains(OK);

        String s1 = target.sendAllCDIBeans();
        assertThat(s1).contains(OK);
    }

    @Test
    void send() {
        // when
        String s = target.send(Email.class);

        // then
        assertThat(s).contains(OK);
    }
}
