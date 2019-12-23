package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 12月 23, 2019
 * @version 1.0
 */
public class TrimBST {

    public static TreeNode<Integer> trimBST(TreeNode<Integer> root, int L, int R) {
        if(root == null) {
            return null;
        }

        int rootValue = root.getData();
        if(rootValue  > R) {
            return trimBST(root.getRightChild(), L, R);
        }

        if(rootValue < L) {
            return trimBST(root.getLeftChild(), L, R);
        }

        root.setLeftChild(trimBST(root.getLeftChild(), L, R));
        root.setRightChild(trimBST(root.getRightChild(), L, R));
        return root;
    }
}
