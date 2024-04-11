package com.infosupport.utjava.tdd;

import org.junit.jupiter.api.Test;

import static com.infosupport.utjava.tdd.Factorial.fac;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    @Test
    void factorial_nIs0_is1() {
        // Arrange

        // Act
        var result = fac(0);

        assertEquals(1, result);
    }

    @Test
    void factorial_nIs1_is1() {
        assertEquals(1, fac(1));
    }

    @Test
    void factorial_nIs5_is120() {
        assertEquals(120, fac(5));
    }

    @Test
    void factorial_nIs6_is720() {
        assertEquals(720, fac(6));
    }

    @Test
    void factorial_nIsMinus2_is1() {
        assertThrows(IllegalArgumentException.class, () -> fac(-2));
    }
}
