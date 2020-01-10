package com.yaoyun.tree;

import static org.junit.Assert.*;

import com.yaoyun.tree.BinaryTree.TreeNode;
import org.junit.Test;

/**
 * @author yaoyun created on 1月 10, 2020
 * @version 1.0
 */
public class LowestCommonAncestorBTTest {

    @Test
    public void lowestCommonAncestor() {
        TreeNode<Integer> root = new TreeNode(1, 1);
        TreeNode<Integer> nodeB = new TreeNode(2, 2);
        TreeNode<Integer> nodeC = new TreeNode(3, 3);
        root.setLeftChild(nodeB);
        root.setRightChild(nodeC);
        TreeNode<Integer> nodeD = new TreeNode(4, 4);
        TreeNode<Integer> nodeE = new TreeNode(5, 5);
        TreeNode<Integer> nodeF = new TreeNode(6, 6);
        nodeB.setLeftChild(nodeD);
        nodeB.setRightChild(nodeE);
        nodeC.setRightChild(nodeF);

        TreeNode result = LowestCommonAncestorBT.lowestCommonAncestor(root, nodeD, nodeE);
        assertEquals(nodeB, result);
    }
}