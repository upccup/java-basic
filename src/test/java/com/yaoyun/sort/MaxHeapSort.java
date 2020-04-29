package com.yaoyun.sort;

/**
 * @author yaoyun created on 4月 29, 2020
 * @version 1.0 https://blog.csdn.net/u010452388/article/details/81283998 更多解释参考MinHeapSort
 */
public class MaxHeapSort {

    public static int[] maxHeapSort(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 -1; i >= 0; i--) {
            maxHeapFixDown(nums, i, n);
        }

        for (int i = n; i > 0; i--) {
            maxHeapDeleteNumber(nums, i);
        }
        return nums;
    }

    private static void maxHeapFixDown(int[] arr, int i, int n) {
        int temp = arr[i];
        int j = 2 * i + 1;
        while (j < n) {
            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j++;
            }

            if (arr[j] <= temp) {
                break;
            }

            arr[i] = arr[j];
            i = j;
            j = 2 * i + 1;
        }
        arr[i] = temp;
    }

    private static void maxHeapDeleteNumber(int[] arr, int n) {
        Utils.swap(arr, 0, n - 1);
        maxHeapFixDown(arr, 0, n - 1);
    }
}
