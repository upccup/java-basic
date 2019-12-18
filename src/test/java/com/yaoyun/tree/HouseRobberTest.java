package com.yaoyun.tree;

import static org.junit.Assert.*;

import com.yaoyun.tree.BinaryTree.TreeNode;
import org.junit.Test;

/**
 * @author yaoyun created on 12月 18, 2019
 * @version 1.0
 */
public class HouseRobberTest {

    @Test
    public void rob() {
        TreeNode<Integer> root = new TreeNode(1, 1);
        TreeNode<Integer> nodeB = new TreeNode(2, 2);
        root.setLeftChild(nodeB);
        TreeNode<Integer> nodeC = new TreeNode(3, 3);
        root.setRightChild(nodeC);
        TreeNode<Integer> nodeD = new TreeNode(4, 4);
        TreeNode<Integer> nodeE = new TreeNode(5, 5);
        nodeB.setLeftChild(nodeD);
        nodeB.setRightChild(nodeE);

        assertEquals(HouseRobber.rob(root), 12);
    }
}