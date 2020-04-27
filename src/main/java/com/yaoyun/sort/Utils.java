package com.yaoyun.sort;

/**
 * @author yaoyun created on 4月 27, 2020
 * @version 1.0
 */
public class Utils {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
