package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 1月 07, 2020
 * @version 1.0
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 */
public class ConvertBST {

    private static int sum;

    public static TreeNode<Integer> convertBST(TreeNode<Integer> root) {
        traverse(root);
        return root;
    }

    private static void traverse(TreeNode<Integer> p) {
        if(p == null) {
            return;
        }

        traverse(p.getRightChild());
        sum += p.getData();
        p.setData(sum);
        traverse(p.getLeftChild());
    }
}
