package com.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testCalculateZero () {
        double x = 0;
        double eps = Math.pow(10, -10);
        double expected = Main.calculateActualValue(x);
        double actual = Main.calculateTailor(eps, x);
        assertEquals(expected, actual, 10E-6);
    }

    @Test
    void testCalculateHalf () {
        double x = 0.5;
        double eps = Math.pow(10, -10);
        double expected = Main.calculateActualValue(x);
        double actual = Main.calculateTailor(eps, x);
        assertNotEquals(expected, actual, 10E-6);
    }
}
