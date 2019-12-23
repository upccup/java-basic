package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yaoyun created on 12月 23, 2019
 * @version 1.0
 */
public class FindBottomLeftValue {

    /**
     * https://leetcode.com/problems/find-bottom-left-tree-value/
     * @param root
     * @return
     */
    public static int findBottomLeftValue(TreeNode<Integer> root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        Queue<TreeNode<Integer>> nodes = new LinkedList<>();
        nodes.add(root);

        int value = 0;
        while (!nodes.isEmpty()) {
            TreeNode<Integer> p = nodes.poll();
            value = p.getData();
            if(p.getRightChild() != null) {
                nodes.add(p.getRightChild());
            }

            if(p.getLeftChild() != null) {
                nodes.add(p.getLeftChild());
            }
        }

        return value;
    }

}
