package com.yaoyun.stack;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author yaoyun created on 4月 15, 2020
 * @version 1.0
 */
public class BasicCalculatorIITest {

    @Test
    public void calculator() {
        int result = BasicCalculatorII.calculator("3+2*2");
        assertEquals(7, result, 0);
        result = BasicCalculatorII.calculator(" 3/2 ");
        assertEquals(1, result, 0);
        result = BasicCalculatorII.calculator(" 3+5 / 2 ");
        assertEquals(5, result, 0);
        result = BasicCalculatorII.calculator("42");
        assertEquals(42, result, 0);
        result = BasicCalculatorII.calculator("1-1+1");
        assertEquals(1, result, 0);
        result = BasicCalculatorII.calculator("0-2147483647");
        assertEquals(-2147483647, result, 0);
        result = BasicCalculatorII.calculator("1*2-3/4+5*6-7*8+9/10");
        assertEquals(-24, result, 0);
        result = BasicCalculatorII.calculator("14/3*2");
        assertEquals(8, result, 0);
    }
}