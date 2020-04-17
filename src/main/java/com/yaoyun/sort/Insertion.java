package com.yaoyun.sort;

/**
 * @author yaoyun created on 4月 17, 2020
 * @version 1.0
 */
public class Insertion {

    public static int[] insertion(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
        
        return nums;
    }
}
