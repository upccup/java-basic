package com.yaoyun.tree;

import static org.junit.Assert.*;

import com.yaoyun.tree.BinaryTree.TreeNode;
import org.junit.Test;

/**
 * @author yaoyun created on 12月 13, 2019
 * @version 1.0
 */
public class MergeBinaryTreeTest {

    @Test
    public void mergeTwoBinaryTrees() {
        TreeNode<Integer> root = new TreeNode(1, 1);
        BinaryTree tree = new BinaryTree(root);
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

        TreeNode<Integer> root2 = new TreeNode(1, 1);
        TreeNode<Integer> nodeB2 = new TreeNode(2, 2);
        TreeNode nodeC2 = new TreeNode(3, 3);
        root2.setLeftChild(nodeB2);
        root2.setRightChild(nodeC2);
        TreeNode<Integer> nodeD2 = new TreeNode(4, 4);
        TreeNode<Integer> nodeE2 = new TreeNode(5, 5);
        TreeNode<Integer> nodeF2 = new TreeNode(6, 6);
        nodeC2.setLeftChild(nodeD2);
        nodeC2.setRightChild(nodeE2);
        nodeB2.setRightChild(nodeF2);

        TreeNode<Integer> mergeNode = MergeBinaryTree.mergeTwoBinaryTrees(root, root2);
        tree.inOrder(mergeNode);
    }
}