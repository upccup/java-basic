package com.yaoyun.sort;

/**
 * @author yaoyun created on 4月 17, 2020
 * @version 1.0
 */
public class ShellSort {

    public static int[] shellSort(int[] nums) {

        // 先分组
        int splitNum = 2;
        for (int gap = nums.length / splitNum; gap > 0; gap /= splitNum) {

            // 组内使用插入排序
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < nums.length; j += gap) {
                    for (int k = j; k >= 0; k -= gap) {
                        if (k - gap >= 0 && nums[k] < nums[k - gap]) {
                            int min = nums[k];
                            nums[k] = nums[k - gap];
                            nums[k - gap] = min;
                        }
                    }
                }
            }
        }

        return nums;
    }

}
