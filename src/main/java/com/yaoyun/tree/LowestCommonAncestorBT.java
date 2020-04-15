package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 1月 10, 2020
 * @version 1.0
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class LowestCommonAncestorBT {

    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode<Integer> left = lowestCommonAncestor(root.getLeftChild(), p, q);
        TreeNode<Integer> right = lowestCommonAncestor(root.getRightChild(), p, q);
        if(left == null) {
            return right;
        }

        if(right == null) {
            return left;
        }

        return root;
    }
}
