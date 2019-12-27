package com.yaoyun.binarysearch;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author yaoyun created on 12月 10, 2019
 * @version 1.0
 */
public class SingleNonDuplicateTest {

    @Test
    public void singleNonDuplicate() {
        int result = SingleNonDuplicate.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8});
        assertEquals(result,2);
        result = SingleNonDuplicate.singleNonDuplicate(new int[]{3,3,7,7,10,11,11});
        assertEquals(result, 10);
    }
}