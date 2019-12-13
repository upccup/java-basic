package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 12月 13, 2019
 * @version 1.0
 */
public class PathSum {

    /**
     * https://leetcode.com/problems/path-sum/
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

    public static int pathSum(TreeNode<Integer> root, int sum) {
        if (root == null) {
            return 0;
        }

        return subTreePathSum(root, sum)
            + pathSum(root.getLeftChild(), sum) + pathSum(root.getRightChild(), sum);

    }

    private static int subTreePathSum(TreeNode<Integer> root, int sum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        int rootData = root.getData();
        if (rootData == sum) {
            ret++;
        }

        ret += subTreePathSum(root.getLeftChild(), sum - rootData) + subTreePathSum(root.getRightChild(), sum - rootData);
        return ret;
    }
}
