package com.yaoyun.sort;

/**
 * @author yaoyun created on 4月 27, 2020
 * @version 1.0 三向切分的快速排序 对于存在大量重复元素的数组，这种方法比标准的快速排序的效率高得多(<<>算法>7534页)
 */
public class QuickSort3 {

    public static int[] quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int compareNum = nums[left];
        int small = left;
        int large = right;
        int i = left;
        while (i <= large) {
            int n = nums[i];
            if (n > compareNum) {
                Utils.swap(nums, i, large);
                large--;
            } else if (n < compareNum) {
                Utils.swap(nums, i, small);
                small++;
                i++;
            } else {
                i++;
            }
        }

        sort(nums, left, small - 1);
        sort(nums, large + 1, right);
    }
}
