package com.yaoyun.tree;

import static org.junit.Assert.*;

import com.yaoyun.tree.BinaryTree.TreeNode;
import org.junit.Test;

/**
 * @author yaoyun created on 12月 16, 2019
 * @version 1.0
 */
public class IsSubTreeTest {

    @Test
    public void isSubTree() {
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

        TreeNode<Integer> nodeB2 = new TreeNode(2, 2);
        TreeNode<Integer> nodeD2 = new TreeNode(4, 4);
        TreeNode<Integer> nodeE2 = new TreeNode(5, 5);
        nodeB2.setLeftChild(nodeD2);
        nodeB2.setRightChild(nodeE2);

        assertTrue(IsSubTree.isSubTree(root, nodeB));
        assertTrue(IsSubTree.isSubTree(root, nodeB2));

        TreeNode<Integer> nodeG = new TreeNode(7, 7);
        nodeE.setLeftChild(nodeG);
        assertFalse(IsSubTree.isSubTree(root, nodeB2));
    }
}