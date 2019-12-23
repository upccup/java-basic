package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 12月 23, 2019
 * @version 1.0
 */
public class SecondMinNode {

    /**
     * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
     * 对于任意一个结点，要么其没有子结点，要么就同时有两个子结点，而且父结点值是子结点值中较小的那个(对于一棵树根节点值就是最小值，
     * 当然两个子结点值可以相等 也就是说对于根节点来说第二小的值要么是和以它值不相等的节点的值为子树的第二小值
     * @param root
     * @return
     */
    public static int findSecondMinimumValue(TreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }

        TreeNode<Integer> leftChild = root.getLeftChild();
        TreeNode<Integer> rightChild = root.getRightChild();

        if (leftChild == null && rightChild == null) {
            return -1;
        }

        int rootValue = root.getData();
        int leftValue = leftChild.getData();
        int rightValue = rightChild.getData();

        if (leftValue == rootValue) {
            leftValue = findSecondMinimumValue(leftChild);
        }

        if(rightValue == rootValue) {
            rightValue = findSecondMinimumValue(rightChild);
        }

        if(leftValue != -1 && rightValue != -1) {
            return Math.min(leftValue, rightValue);
        }

        if(leftValue != -1) {
            return leftValue;
        }

        return rightValue;
    }
}
