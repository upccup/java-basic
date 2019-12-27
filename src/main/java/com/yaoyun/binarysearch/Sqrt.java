package com.yaoyun.binarysearch;

/**
 * @author yaoyun created on 12月 10, 2019
 * @version 1.0
 */
/* https://leetcode.com/problems/sqrtx/description/ */
public class Sqrt {

    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int l = 1, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int sqrt = x/mid;
            if (sqrt == mid) {
                return mid;
            } else if(sqrt < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }
}
