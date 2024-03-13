package com.infosupport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptellerTest {

    @Test
    void whenTwoPositiveIntsAreAddedTheSumIsCorrect() {
        // given
        int a = 1;
        int b = 2;

        // when
        int som = Opteller.som(a, b);

        // then
        assertEquals(3, som);
    }
}
