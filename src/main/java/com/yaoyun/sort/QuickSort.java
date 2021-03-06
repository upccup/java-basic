package com.yaoyun.sort;

/**
 * @author yaoyun created on 4月 24, 2020
 * @version 1.0 快速排序
 */
public class QuickSort {

    public static int[] quickSort(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    private static int[] sort(int[] nums, int left, int right) {
        if (left >= right) {
            return nums;
        }

        int temp = nums[left];
        int i = left;
        int j = right;

        while (i < j) {

            while (nums[j] >= temp && i < j) {
                j--;
            }

            while (nums[i] <= temp && i < j) {
                i++;
            }

            if (i < j) {
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }

        }

        nums[left] = nums[i];
        nums[i] = temp;

        nums = sort(nums, left, i - 1);
        nums = sort(nums, i + 1, right);

        return nums;
    }


    public static int[] quickSort2(int[] nums) {
        return sort2(nums, 0, nums.length - 1);
    }

    private static int[] sort2(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            sort2(arr, left, partitionIndex - 1);
            sort2(arr, partitionIndex + 1, right);
        }

        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        // 设置基准值(pivot)
        // int pivot = left;
        int index = left + 1;

        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[left]) {
                Utils.swap(arr, i, index);
                index++;
            }
        }

        Utils.swap(arr, left, index - 1);
        return index - 1;
    }
}
