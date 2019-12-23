package com.yaoyun.tree;

import static org.junit.Assert.*;

import com.yaoyun.tree.BinaryTree.TreeNode;
import org.junit.Test;

/**
 * @author yaoyun created on 12月 23, 2019
 * @version 1.0
 */
public class TrimBSTTest {

    @Test
    public void trimBST() {
        TreeNode<Integer> root = new TreeNode(1, 3);
        TreeNode<Integer> nodeB = new TreeNode(2, 1);
        root.setLeftChild(nodeB);
        TreeNode<Integer> nodeC = new TreeNode(3, 0);
        root.setRightChild(nodeC);
        TreeNode<Integer> nodeD = new TreeNode(4, 4);
        nodeB.setLeftChild(nodeD);

        root = TrimBST.trimBST(root, 1,3);
        assertEquals(root.getData(), new Integer(3));
        assertNull(root.getRightChild());
        assertNull(root.getLeftChild().getLeftChild());
        assertEquals(root.getLeftChild(), nodeB);
    }
}