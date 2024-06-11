package com.example.dependent.high;

import com.example.dependent.low.Email;
import com.example.dependent.low.Sms;
import org.junit.jupiter.api.Test;

import static com.example.dependencyinverted.cdi.util.Util.OK;
import static org.assertj.core.api.Assertions.assertThat;

class SenderWithDITest {

    @Test
    void sendAllConstructorDI() {
        // given
        SenderWithDI target = new SenderWithDI(new Email(), new Sms());

        // when
        String s = target.sendAll();

        // then
        assertThat(s).contains(OK);
    }

    @Test
    void sendAllSetterDI() {
        // given
        SenderWithDI target = new SenderWithDI();
        target.setEmail(new Email());
        target.setSms(new Sms());

        // when
        String s = target.sendAll();

        // then
        assertThat(s).contains(OK);
    }
}
