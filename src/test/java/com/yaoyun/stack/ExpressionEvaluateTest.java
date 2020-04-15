package com.yaoyun.stack;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author yaoyun created on 4月 15, 2020
 * @version 1.0
 */
public class ExpressionEvaluateTest {

    @Test
    public void evaluate() {
        double result = ExpressionEvaluate.evaluate("((((1+2)*(3+4))/5)*(4+6))");
        assertEquals(42, result, 0);
    }

}