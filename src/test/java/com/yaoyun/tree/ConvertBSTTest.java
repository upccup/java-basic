package com.yaoyun.tree;

import static org.junit.Assert.*;

import com.yaoyun.tree.BinaryTree.TreeNode;
import org.junit.Test;

/**
 * @author yaoyun created on 1月 07, 2020
 * @version 1.0
 */
public class ConvertBSTTest {

    @Test
    public void convertBST() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(6);
        bst.insert(2);
        bst.insert(7);
        bst.insert(4);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        TreeNode<Integer> p = ConvertBST.convertBST(bst.getRoot());
        assertEquals(new Integer(21), p.getData());
    }
}