package com.yaoyun.tree;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author yaoyun created on 1月 07, 2020
 * @version 1.0
 */
public class KthSmallestTest {

    @Test
    public void kthSmallest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(6);
        bst.insert(2);
        bst.insert(7);
        bst.insert(4);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        int kthSmallest = KthSmallest.kthSmallest(bst.getRoot(), 3);
        assertEquals(kthSmallest, 3);
    }
}