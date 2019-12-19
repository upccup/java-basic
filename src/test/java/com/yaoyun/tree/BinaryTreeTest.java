package com.yaoyun.tree;

import static org.junit.Assert.*;

import com.yaoyun.tree.BinaryTree.TreeNode;
import org.junit.Test;

/**
 * @author yaoyun created on 12月 12, 2019
 * @version 1.0
 */
public class BinaryTreeTest {

    @Test
    public void preOrder() {
        TreeNode root = new TreeNode(1, "rootNode(A)");
        BinaryTree tree = new BinaryTree(root);
        assertFalse(tree.isEmpty());
        TreeNode nodeB = new TreeNode(2, "B");
        TreeNode nodeC = new TreeNode(3, "C");
        root.setLeftChild(nodeB);
        root.setRightChild(nodeC);
        assertEquals(root.getLeftChild(), nodeB);
        assertEquals(root.getRightChild(), nodeC);

        TreeNode nodeD = new TreeNode(4, "D");
        TreeNode nodeE = new TreeNode(5, "E");
        TreeNode nodeF = new TreeNode(6, "F");
        nodeB.setLeftChild(nodeD);
        nodeB.setRightChild(nodeE);
        nodeC.setRightChild(nodeF);
        assertEquals(tree.height(), 3);
        assertEquals(tree.size(), 6);
        assertEquals(tree.parent(nodeE), nodeB);

        System.out.println("preOrder: ");
        tree.preOrder();
        System.out.println("inOrder: ");
        tree.inOrder();
        System.out.println("postOrder: ");
        tree.postOrder();

        System.out.println("nonRecPreOrder: ");
        tree.nonRecPreOrder();
        System.out.println("nonRecInOrder: ");
        tree.nonRecInOrder();
    }

    @Test
    public void nonRecPostOrder() {
        TreeNode root = new TreeNode(1, "rootNode(A)");
        BinaryTree tree = new BinaryTree(root);
        TreeNode nodeB = new TreeNode(2, "B");
        TreeNode nodeC = new TreeNode(3, "C");
        root.setLeftChild(nodeB);
        root.setRightChild(nodeC);
        TreeNode nodeD = new TreeNode(4, "D");
        TreeNode nodeE = new TreeNode(5, "E");
        TreeNode nodeF = new TreeNode(6, "F");
        nodeB.setLeftChild(nodeD);
        nodeB.setRightChild(nodeE);
        nodeC.setRightChild(nodeF);
        System.out.println("nonRecPostOrder: ");
        tree.nonRecPostOrder();
    }

    @Test
    public void broadFirstTraverse() {
        TreeNode root = new TreeNode(1, "rootNode(A)");
        BinaryTree tree = new BinaryTree(root);
        TreeNode nodeB = new TreeNode(2, "B");
        TreeNode nodeC = new TreeNode(3, "C");
        root.setLeftChild(nodeB);
        root.setRightChild(nodeC);
        TreeNode nodeD = new TreeNode(4, "D");
        TreeNode nodeE = new TreeNode(5, "E");
        TreeNode nodeF = new TreeNode(6, "F");
        nodeB.setLeftChild(nodeD);
        nodeB.setRightChild(nodeE);
        nodeC.setRightChild(nodeF);
        System.out.println("broadFirstTraverse: ");
        tree.broadFirstTraverse(root);
    }
}