package com.yaoyun.tree;

import static org.junit.Assert.*;

import com.yaoyun.tree.BinaryTree.TreeNode;
import org.junit.Test;

/**
 * @author yaoyun created on 1月 07, 2020
 * @version 1.0
 */
public class LowestCommonAncestorTest {

    @Test
    public void lowestCommonAncestor() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(6);
        bst.insert(2);
        bst.insert(7);
        bst.insert(4);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        TreeNode<Integer> p = new TreeNode<>(1, 1);
        TreeNode<Integer> q = new TreeNode<>(1, 4);
        TreeNode<Integer> result = LowestCommonAncestor.lowestCommonAncestor(bst.getRoot(), p,q);
        assertEquals(new Integer(2), result.getData());
    }
}