package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 12月 17, 2019
 * @version 1.0
 */
public class LongestUnivaluePath {

    private static int path = 0;

    /**
     * https://leetcode.com/problems/longest-univalue-path/
     * @param root
     * @return
     */
    public static int longetsUnivaluePath(TreeNode<Integer> root) {
        countPath(root);
        return path;
    }

    /**
     * TODO  optimize
      * @param root
     * @return
     */
    private static int countPath(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        int left =  countPath(root.getLeftChild());
        int right = countPath(root.getRightChild());
        TreeNode<Integer> leftChild = root.getLeftChild();
        TreeNode<Integer> rightChild = root.getRightChild();

        int leftPath;
        if(leftChild != null && leftChild.getData().equals(root.getData())) {
            leftPath = left + 1;
        } else {
            leftPath = 0;
        }

        int rightPath;
        if(rightChild != null && rightChild.getData().equals(root.getData())) {
            rightPath = right + 1;
        } else {
            rightPath = 0;
        }

        path = Math.max(path, leftPath+rightPath);
        return Math.max(leftPath, rightPath);
    }
}
