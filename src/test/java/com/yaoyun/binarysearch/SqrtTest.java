package com.yaoyun.binarysearch;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author yaoyun created on 12月 10, 2019
 * @version 1.0
 */
public class SqrtTest {

    @Test
    public void mySqrt() {
        int result = Sqrt.mySqrt(8);
        assertEquals(result, 2);
    }
}