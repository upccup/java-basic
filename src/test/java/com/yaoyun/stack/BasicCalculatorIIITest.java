package com.yaoyun.stack;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author yaoyun created on 4月 16, 2020
 * @version 1.0
 */
public class BasicCalculatorIIITest {

    @Test
    public void calculator() {
        int result = BasicCalculatorIII.calculator("(2+6* 3+5- (3*14/7+2)*5)+3");
        assertEquals(-12, result, 0);
        result = BasicCalculatorIII.calculator("2*(5+5*2)/3+(6/2+8)");
        assertEquals(21, result, 0);
        result = BasicCalculatorIII.calculator(" 6-4 / 2 ");
        assertEquals(4, result, 0);
        result = BasicCalculatorIII.calculator("1 + 1");
        assertEquals(2, result, 0);
    }
}