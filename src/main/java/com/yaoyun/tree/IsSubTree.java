package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 12月 16, 2019
 * @version 1.0
 */
public class IsSubTree {

    /**
     * https://leetcode.com/problems/subtree-of-another-tree/
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubTree(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }

        if (isSubTreeFromRoot(s, t)) {
            return true;
        }

        if(isSubTree(s.getLeftChild(), t)) {
            return true;
        }

        if(isSubTree(s.getRightChild(), t)) {
            return true;
        }

        return false;
    }

    private static boolean isSubTreeFromRoot(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        if (s.getData() != t.getData()) {
            return false;
        }

        if(isSubTreeFromRoot(s.getLeftChild(), t.getLeftChild()) && isSubTreeFromRoot(s.getRightChild(), t.getRightChild())) {
            return true;
        }

        return false;
    }
}
