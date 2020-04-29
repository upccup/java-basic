package com.yaoyun.sort;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author yaoyun created on 4月 29, 2020
 * @version 1.0
 */
public class MaxHeapSortTest {

    @Test
    public void maxHeapSort() {
        int[] result = MaxHeapSort.maxHeapSort(new int[]{5, 2, 3, 1});
        assertEquals(1, result[0], 0);
        assertEquals(2, result[1], 0);
        assertEquals(5, result[3], 0);
        result = MaxHeapSort.maxHeapSort(new int[]{5, 1, 1, 2, 0, 0});
        assertEquals(0, result[0], 0);
        assertEquals(0, result[1], 0);
        assertEquals(5, result[result.length - 1], 0);
        result = MaxHeapSort.maxHeapSort(new int[]{-1, 2, -8, -10});
        assertEquals(-8, result[1], 0);
        assertEquals(2, result[3], 0);
        result = MaxHeapSort.maxHeapSort(
            new int[]{-74, 48, -20, 2, 10, -84, -5, -9, 11, -24, -91, 2, -71, 64, 63, 80, 28, -30, -58, -11, -44, -87, -22, 54, -74, -10, -55, -28, -46, 29, 10,
                50, -72, 34, 26, 25, 8, 51, 13, 30, 35, -8, 50, 65, -6, 16, -2, 21, -78, 35, -13, 14, 23, -3, 26, -90, 86, 25, -56, 91, -13, 92, -25, 37, 57,
                -20, -69, 98, 95, 45, 47, 29, 86, -28, 73, -44, -46, 65, -84, -96, -24, -12, 72, -68, 93, 57, 92, 52, -45, -2, 85, -63, 56, 55, 12, -85, 77,
                -39});
        assertEquals(-96, result[0], 0);
    }
}