package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 12月 17, 2019
 * @version 1.0
 */
public class SumOfLeftLeaves {

    /**
     * https://leetcode.com/problems/sum-of-left-leaves/
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        TreeNode<Integer> leftChild = root.getLeftChild();
        TreeNode<Integer> rightChild = root.getRightChild();
        if (isLeaf(leftChild)) {
            return leftChild.getData() + sumOfLeftLeaves(rightChild);
        }

        return sumOfLeftLeaves(leftChild) + sumOfLeftLeaves(rightChild);
    }

    private static boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }

        if(node.getLeftChild() == null && node.getRightChild() == null)  {
            return true;
        }

        return false;
    }
}
