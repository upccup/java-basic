package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yaoyun created on 12月 23, 2019
 * @version 1.0
 */
public class AverageOfLevels {

    /**
     * https://leetcode.com/problems/average-of-levels-in-binary-tree/
     * @param root
     * @return
     */
    public static List<Double> averageOfLevels(TreeNode<Integer> root) {
        if(root == null) {
            return null;
        }

        List<Double> averages = new ArrayList<>();
        Queue<TreeNode<Integer>> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            int count = nodes.size();
            double sum = 0;

            for (int i = 0; i < count; i++) {
                TreeNode<Integer> p = nodes.poll();
                sum += p.getData();

                if(p.getLeftChild() != null) {
                    nodes.add(p.getLeftChild());
                }

                if(p.getRightChild() != null) {
                    nodes.add(p.getRightChild());
                }
            }
            averages.add((sum/count));
        }

        return averages;
    }
}
