package com.yaoyun.sort;

/**
 * @author yaoyun created on 4月 17, 2020
 * @version 1.0
 */
public class Selection {

    public static int[] selection(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            int minNum = nums[min];
            nums[min] = nums[i];
            nums[i] = minNum;
        }

        return nums;
    }

}
