package com.yaoyun.tree;

import static org.junit.Assert.*;

import com.yaoyun.tree.BinaryTree.TreeNode;
import org.junit.Test;

/**
 * @author yaoyun created on 12月 13, 2019
 * @version 1.0
 */
public class PathSumTest {

    @Test
    public void pathSum() {
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

        assertTrue(PathSum.hasPathSum(root, 7));
        assertTrue(PathSum.hasPathSum(root, 8));
        assertTrue(PathSum.hasPathSum(root, 10));
        assertFalse(PathSum.hasPathSum(root, 9));
    }
}