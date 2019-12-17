package com.yaoyun.tree;

import static org.junit.Assert.*;

import com.yaoyun.tree.BinaryTree.TreeNode;
import org.junit.Test;

/**
 * @author yaoyun created on 12月 16, 2019
 * @version 1.0
 */
public class IsSymmetricTest {

    @Test
    public void isSymmetric() {
        TreeNode<Integer> root = new TreeNode(1, 1);
        TreeNode<Integer> nodeB = new TreeNode(2, 2);
        TreeNode<Integer> nodeC = new TreeNode(3, 2);
        root.setLeftChild(nodeB);
        root.setRightChild(nodeC);
        TreeNode<Integer> nodeD = new TreeNode(4, 3);
        TreeNode<Integer> nodeE = new TreeNode(5, 4);
        TreeNode<Integer> nodeF = new TreeNode(6, 3);
        nodeB.setLeftChild(nodeD);
        nodeB.setRightChild(nodeE);
        nodeC.setRightChild(nodeF);

        assertFalse(IsSymmetric.isSymmetric(root));
        TreeNode<Integer> nodeG = new TreeNode(7, 4);
        nodeC.setLeftChild(nodeG);
        assertTrue(IsSymmetric.isSymmetric(root));
    }
}