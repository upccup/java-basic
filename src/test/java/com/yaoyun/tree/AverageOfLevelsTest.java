package com.yaoyun.tree;

import static org.junit.Assert.*;

import com.yaoyun.tree.BinaryTree.TreeNode;
import java.util.List;
import org.junit.Test;

/**
 * @author yaoyun created on 12月 23, 2019
 * @version 1.0
 */
public class AverageOfLevelsTest {

    @Test
    public void averageOfLevels() {
        TreeNode<Integer> root = new TreeNode(1, 1);
        TreeNode<Integer> nodeB = new TreeNode(2, 3);
        root.setLeftChild(nodeB);
        TreeNode<Integer> nodeC = new TreeNode(3, 1);
        root.setRightChild(nodeC);
        TreeNode<Integer> nodeD = new TreeNode(4, 4);
        TreeNode<Integer> nodeE = new TreeNode(5, 3);
        nodeB.setLeftChild(nodeD);
        nodeB.setRightChild(nodeE);

        List<Double> averages = AverageOfLevels.averageOfLevels(root);
        assertEquals(new Double(1), averages.get(0));
        assertEquals(new Double(2), averages.get(1));
        assertEquals(new Double(3.5), averages.get(2));
    }
}