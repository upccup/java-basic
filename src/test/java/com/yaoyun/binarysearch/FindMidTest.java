package com.yaoyun.binarysearch;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author yaoyun created on 12月 11, 2019
 * @version 1.0
 */
public class FindMidTest {

    @Test
    public void findMid() {
        int result = FindMid.findMid(new int[]{3,4,5,1,2});
        assertEquals(result, 1);
        result = FindMid.findMid(new int[]{4,5,6,7,0,1,2});
        assertEquals(result, 0);
    }

    @Test
    public void findMidII() {
        int result = FindMid.findMidII(new int[]{3,4,5,1,2});
        assertEquals(result, 1);
        result = FindMid.findMidII(new int[]{4,5,6,7,0,1,2});
        assertEquals(result, 0);
        result = FindMid.findMidII(new int[]{3,3,1,3});
        assertEquals(result,1);
        result = FindMid.findMidII(new int[]{2,2,2,0,1});
        assertEquals(result,  0);
    }
}