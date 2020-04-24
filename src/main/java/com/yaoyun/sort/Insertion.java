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

    public static int[] insertion2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = temp;
        }
        return nums;
    }
}
