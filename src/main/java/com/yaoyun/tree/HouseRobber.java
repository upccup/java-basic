package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 12月 18, 2019
 * @version 1.0
 */
public class HouseRobber {

    /**
     * https://leetcode.com/problems/house-robber-iii/
     * @param root
     * @return
     */
    public static int rob(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        int val1 = root.getData();
        TreeNode<Integer> leftChild = root.getLeftChild();
        TreeNode<Integer> rightChild = root.getRightChild();
        if(leftChild != null){
            val1 += rob(leftChild.getLeftChild()) + rob(leftChild.getRightChild());
        }

        if(rightChild != null) {
            val1 += rob(rightChild.getLeftChild()) + rob(rightChild.getRightChild());
        }

        int val2 = rob(leftChild) + rob(rightChild);
        return Math.max(val1, val2);
    }
}
