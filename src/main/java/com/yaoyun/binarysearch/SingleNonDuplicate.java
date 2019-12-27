package com.yaoyun.binarysearch;

/**
 * @author yaoyun created on 12月 10, 2019
 * @version 1.0
 */
public class SingleNonDuplicate {

    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public static int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }

}
