package com.yaoyun.sort;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author yaoyun created on 4月 20, 2020
 * @version 1.0
 */
public class MergeSortTest {

    @Test
    public void mergeSort() {
        int[] result = MergeSort.mergeSort(new int[]{5, 2, 3, 1});
        assertEquals(1, result[0], 0);
        assertEquals(2, result[1], 0);
        assertEquals(5, result[3], 0);
        result = MergeSort.mergeSort(new int[]{5, 1, 1, 2, 0, 0});
        assertEquals(0, result[0], 0);
        assertEquals(0, result[1], 0);
        assertEquals(5, result[result.length - 1], 0);
        result = MergeSort.mergeSort(new int[]{-1, 2, -8, -10});
        assertEquals(-8, result[1], 0);
        assertEquals(2, result[3], 0);
    }

    @Test
    public void mergeSort2() {
        int[] result = MergeSort.mergeSort2(new int[]{5, 2, 3, 1});
        assertEquals(1, result[0], 0);
        assertEquals(2, result[1], 0);
        assertEquals(5, result[3], 0);
        result = MergeSort.mergeSort2(new int[]{5, 1, 1, 2, 0, 0});
        assertEquals(0, result[0], 0);
        assertEquals(0, result[1], 0);
        assertEquals(5, result[result.length - 1], 0);
        result = MergeSort.mergeSort2(new int[]{-1, 2, -8, -10});
        assertEquals(-8, result[1], 0);
        assertEquals(2, result[3], 0);
        result = MergeSort.mergeSort2(new int[]{-4, 0, 7, 4, 9, -5, -1, 0, -7, -1});
        assertEquals(-7, result[0], 0);
        assertEquals(9, result[9], 0);
    }
}