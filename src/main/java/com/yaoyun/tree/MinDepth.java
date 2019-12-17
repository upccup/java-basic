package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 12月 16, 2019
 * @version 1.0
 */
public class MinDepth {

    /**
     * https://leetcode.com/problems/minimum-depth-of-binary-tree/
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.getLeftChild());
        int right = minDepth(root.getRightChild());
        if (left == 0 || right == 0) {
            // in put [1,2] Expected 2
            return 1 + left + right;
        }

        return 1 + Math.min(left, right);
    }
}
