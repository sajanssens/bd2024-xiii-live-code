package com.example.dependent.high;

import org.junit.jupiter.api.Test;

import static com.example.dependencyinverted.cdi.util.Util.OK;
import static org.assertj.core.api.Assertions.assertThat;

class SenderTest {

    // See src/main/resources/img/DependencyInversion.png

    Sender target = new Sender();

    @Test
    void sendAll() {
        // given a target

        // when
        String s = target.sendAll();

        // then
        assertThat(s).contains(OK);
    }

}
