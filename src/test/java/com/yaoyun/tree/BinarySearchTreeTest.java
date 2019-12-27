package com.yaoyun.tree;

import static org.junit.Assert.*;

import com.yaoyun.tree.BinaryTree.TreeNode;
import org.junit.Test;

/**
 * @author yaoyun created on 12月 27, 2019
 * @version 1.0
 */
public class BinarySearchTreeTest {

    private static BinarySearchTree<Integer> createBST() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(6);
        bst.insert(2);
        bst.insert(7);
        bst.insert(4);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        return bst;
    }

    @Test
    public void find() {
        BinarySearchTree<Integer> bst = BinarySearchTreeTest.createBST();
        TreeNode<Integer> p = bst.find(3);
        assertEquals(new Integer(3), p.getData());
    }

    @Test
    public void minimum() {
        BinarySearchTree<Integer> bst = BinarySearchTreeTest.createBST();
        assertEquals(new Integer(1), bst.minimum());
    }

    @Test
    public void maximum() {
        BinarySearchTree<Integer> bst = BinarySearchTreeTest.createBST();
        assertEquals(new Integer(8), bst.maximum());
    }

    @Test
    public void removeMin() {
        BinarySearchTree<Integer> bst = BinarySearchTreeTest.createBST();
        assertEquals(new Integer(1), bst.removeMin());
        assertEquals(new Integer(2), bst.minimum());
    }

    @Test
    public void removeMax() {
        BinarySearchTree<Integer> bst = BinarySearchTreeTest.createBST();
        assertEquals(new Integer(8), bst.removeMax());
        assertEquals(new Integer(7), bst.maximum());
    }

    @Test
    public void remove() {
        BinarySearchTree<Integer> bst = BinarySearchTreeTest.createBST();
        TreeNode<Integer> p = bst.remove(2);
        assertEquals(new Integer(1), p.getLeftChild().getData());
    }
}