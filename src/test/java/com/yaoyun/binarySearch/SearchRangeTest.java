package com.yaoyun.binarySearch;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author yaoyun created on 12月 11, 2019
 * @version 1.0
 */
public class SearchRangeTest {

    @Test
    public void searchRange() {
        int[] result = SearchRange.searchRange(new int[]{5,7,7,8,8,10},  8);
        assertArrayEquals(result, new int[]{3, 4});
        result = SearchRange.searchRange(new int[]{5,7,7,8,8,10},  6);
        assertArrayEquals(result, new int[]{-1, -1});
    }
}