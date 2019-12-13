package com.yaoyun.tree;


import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 12月 13, 2019
 * @version 1.0
 */
public class MergeBinaryTree {

    /**
     * https://leetcode.com/problems/merge-two-binary-trees/
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode<Integer> mergeTwoBinaryTrees(TreeNode<Integer> t1, TreeNode<Integer> t2) {
        if (t1 ==  null) {
            return t2;
        }

        if(t2 == null) {
            return t1;
        }

        TreeNode<Integer> root =  new TreeNode(t1.getKey(), t1.getData() + t2.getData());
        root.setLeftChild(mergeTwoBinaryTrees(t1.getLeftChild(), t2.getLeftChild()));
        root.setRightChild(mergeTwoBinaryTrees(t1.getRightChild(), t2.getRightChild()));
        return root;
    }
}
