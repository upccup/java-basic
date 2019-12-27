package com.yaoyun.binarysearch;

/**
 * @author yaoyun created on 12月 11, 2019
 * @version 1.0
 */
public class FindMid {

    /* https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/  */
    public static int findMid(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[l];
    }

    /* https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/ */
    public static int findMidII(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (r < 0){
            return -1;
        }

        if (r==0) {
            return nums[r];
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r--;
            }
        }

        return nums[l];
    }

}
