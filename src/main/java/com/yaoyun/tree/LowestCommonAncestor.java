package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 1月 07, 2020
 * @version 1.0 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
public class LowestCommonAncestor {

    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root.getData() > p.getData() && root.getData() > q.getData()) {
            return lowestCommonAncestor(root.getLeftChild(), p, q);
        }

        if (root.getData() < p.getData() && root.getData() < q.getData()) {
            return lowestCommonAncestor(root.getRightChild(), p, q);
        }

        return root;
    }
}
