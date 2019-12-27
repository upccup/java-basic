package com.yaoyun.binarysearch;

/**
 * @author yaoyun created on 12月 10, 2019
 * @version 1.0
 */

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class NextGreatestLetter {

    public static char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        if (target >= letters[length - 1]) {
            return letters[0];
        } else if (target < letters[0]) {
            return letters[0];
        }

        int l = 0, r = length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target >= letters[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return letters[l];
    }

}
