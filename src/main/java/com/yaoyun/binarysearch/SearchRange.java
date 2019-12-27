package com.yaoyun.binarysearch;

/**
 * @author yaoyun created on 12月 11, 2019
 * @version 1.0
 */
public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target+1) - 1;

        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    private static int findFirst(int[] nums, int tatget) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= tatget) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

}
