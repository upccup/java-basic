package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 1月 07, 2020
 * @version 1.0
 */
public class KthSmallest {

    public static int kthSmallest(TreeNode<Integer> root, int k) {
        int leftChildCount = count(root.getLeftChild());
        if (leftChildCount == k - 1) {
            return root.getData();
        }

        if (leftChildCount > k - 1) {
            return kthSmallest(root.getLeftChild(), k);
        }

        return kthSmallest(root.getRightChild(), k - leftChildCount - 1);
    }

    private static int count(TreeNode p) {
        if (p == null) {
            return 0;
        }

        return 1 + count(p.getLeftChild()) + count(p.getRightChild());
    }
}
