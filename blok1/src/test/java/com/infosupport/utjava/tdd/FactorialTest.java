package com.infosupport.utjava.tdd;

import org.junit.jupiter.api.Test;

import static com.infosupport.utjava.tdd.Faculty.fac;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    @Test
    void faculty_nIs0_is1() {
        // Arrange

        // Act
        var result = fac(0);

        assertEquals(1, result);
    }

    @Test
    void faculty_nIs1_is1() {
        assertEquals(1, fac(1));
    }

    @Test
    void faculty_nIs5_is120() {
        assertEquals(120, fac(5));
    }

    @Test
    void faculty_nIs6_is720() {
        assertEquals(720, fac(6));
    }

    @Test
    void faculty_nIsMinus2_is1() {
        assertThrows(IllegalArgumentException.class, () -> fac(-2));
    }
}
