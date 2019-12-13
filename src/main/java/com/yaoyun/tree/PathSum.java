package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 12月 13, 2019
 * @version 1.0
 */
public class PathSum {

    /**
     * https://leetcode.com/problems/path-sum/
     * @param node
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode<Integer> node, int sum) {
        if (node == null) {
            return false;
        }
        int rootData = node.getData();
        if (node.getLeftChild() == null && node.getRightChild() == null && rootData == sum) {
            return true;
        }

        if (hasPathSum(node.getLeftChild(), sum - rootData)) {
            return true;
        }

        return hasPathSum(node.getRightChild(), sum - rootData);
    }
}
