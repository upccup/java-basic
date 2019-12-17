package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 12月 16, 2019
 * @version 1.0
 */
public class IsSymmetric {

    /**
     * https://leetcode.com/problems/symmetric-tree/description/
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.getLeftChild(), root.getRightChild());
    }

    private static boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.getData() != t2.getData()) {
            return false;
        }

        if (isSymmetric(t1.getLeftChild(), t2.getRightChild()) && isSymmetric(t1.getRightChild(), t2.getLeftChild())) {
            return true;
        }

        return false;
    }
}
