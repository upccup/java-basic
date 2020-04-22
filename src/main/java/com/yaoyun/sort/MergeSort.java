package com.yaoyun.sort;

/**
 * @author yaoyun created on 4月 20, 2020
 * @version 1.0 归并排序
 */
public class MergeSort {

    public static int[] mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    /**
     * 自上而下的递归
     *
     * @param nums 待排序数组
     * @param left 起始位置
     * @param right 终点位置
     * @param temp 临时数组
     */
    private static void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid, temp);
            sort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = nums[i++];
        }

        while (j <= right) {
            temp[t++] = nums[j++];
        }

        t = 0;
        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }


    /**
     * 自底向上的归并排序
     *
     * @param nums 待排序数组
     * @return 已排序数组
     */
    public static int[] mergeSort2(int[] nums) {
        int[] temp = new int[nums.length];

        int mergeCoefficient = 2;
        for (int step = 1; step < nums.length; step *= mergeCoefficient) {

            for (int start = 0; start < nums.length; start = start + step * mergeCoefficient) {
                int end = Math.min(start+step*mergeCoefficient-1, nums.length-1);

                // mid 不能超过数组长度
                int mid = Math.min(start + step -1, end);
                int i = start;
                int j = mid +1;
                int t = 0;

                // 有可能 j 已经 等于 nums.length 但是由于[i, mid(这个时候mid已经是end了)]已经有序所以会进入  while (i <= mid) 这个循环
                while (i <= mid && j <= end) {
                    if(nums[i] < nums[j]) {
                        temp[t++] = nums[i++];
                    } else {
                        temp[t++] = nums[j++];
                    }
                }

                while (i <= mid) {
                    temp[t++] = nums[i++];
                }

                while (j <= end) {
                    temp[t++] = nums[j++];
                }

                t = 0;
                i = start;
                while (i <= end) {
                    nums[i++] = temp[t++];
                }
            }
        }
        return nums;
    }
}
