package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 1月 10, 2020
 * @version 1.0
 */
public class LowestCommonAncestorBT {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.getLeftChild(), p, q);
        TreeNode right = lowestCommonAncestor(root.getRightChild(), p, q);
        if(left == null) {
            return right;
        }

        if(right == null) {
            return left;
        }

        return root;
    }
}
