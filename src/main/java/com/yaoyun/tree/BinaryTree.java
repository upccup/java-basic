package com.yaoyun.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yaoyun created on 12月 12, 2019
 * @version 1.0
 */
public class BinaryTree {

    public static class TreeNode<T> {

        private int key = 0;
        private T data = null;
        private boolean isVisited = false;
        private TreeNode leftChild = null;
        private TreeNode rightChild = null;

        public TreeNode() {
        }

        public TreeNode(int key, T data) {
            this.key = key;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        public void setLeftChild(TreeNode childNode) {
            this.leftChild = childNode;
        }

        public TreeNode getLeftChild() {
            return this.leftChild;
        }

        public void setRightChild(TreeNode childNode) {
            this.rightChild = childNode;
        }

        public TreeNode getRightChild() {
            return this.rightChild;
        }

        public void setVisited(boolean visited) {
            this.isVisited = visited;
        }

        public boolean getVisited() {
            return this.isVisited;
        }

        public int getKey() {
            return this.key;
        }

        public T getData() {
            return this.data;
        }

        public void setData(T newData) {
            this.data = newData;
        }
    }

    private TreeNode root;

    public BinaryTree(TreeNode node) {
        this.root = node;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public int height() {
        return this.height(root);
    }

    private int height(TreeNode subTree) {
        if (subTree == null) {
            return 0;
        }

        return 1 + Math.max(this.height(subTree.leftChild), this.height(subTree.rightChild));
    }

    public int size() {
        return this.size(root);
    }

    private int size(TreeNode subTree) {
        if (subTree == null) {
            return 0;
        }

        return 1 + this.size(subTree.leftChild) + this.size(subTree.rightChild);
    }

    public TreeNode parent(TreeNode element) {
        if (root == null || root == element) {
            return null;
        }

        return this.parent(root, element);
    }

    public TreeNode parent(TreeNode subTree, TreeNode element) {
        if (subTree == null) {
            return null;
        }

        if (subTree.leftChild == element || subTree.rightChild == element) {
            return subTree;
        }

        TreeNode p = this.parent(subTree.leftChild, element);
        if (p != null) {
            return p;
        }

        return this.parent(subTree.rightChild, element);
    }

    public TreeNode getLeftChildNode(TreeNode element) {
        return (element == null) ? element.leftChild : null;
    }

    public TreeNode getRightChildNode(TreeNode element) {
        return (element == null) ? element.rightChild : null;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public void destroy(TreeNode subTree) {
        if (subTree != null) {
            this.destroy(subTree.leftChild);
            this.destroy(subTree.rightChild);
            subTree = null;
        }
    }

    public void traverse(TreeNode subTree) {
        if (subTree != null) {
            this.traverse(subTree.leftChild);
            this.traverse(subTree.rightChild);
        }
    }

    public void visited(TreeNode node) {
        node.isVisited = true;
        System.out.println("key: " + node.key + "---data: " + node.data);
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        this.preOrder(root);
    }

    public void preOrder(TreeNode subTree) {
        if (subTree != null) {
            this.visited(subTree);
            this.preOrder(subTree.leftChild);
            this.preOrder(subTree.rightChild);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        this.inOrder(root);
    }

    public void inOrder(TreeNode subTree) {
        if (subTree != null) {
            this.inOrder(subTree.leftChild);
            this.visited(subTree);
            this.inOrder(subTree.rightChild);
        }
    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        this.postOrder(root);
    }

    public void postOrder(TreeNode subTree) {
        if (subTree != null) {
            this.postOrder(subTree.leftChild);
            this.postOrder(subTree.rightChild);
            this.visited(subTree);
        }
    }

    /**
     * 前序遍历非递归实现
     */
    public void nonRecPreOrder() {
        this.nonRecPreOrder(this.root);
    }

    public void nonRecPreOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node;
        while (p != null || stack.size() > 0) {
            while (p != null) {
                this.visited(p);
                stack.push(p);
                p = p.leftChild;
            }

            if (stack.size() > 0) {
                p = stack.pop();
                p = p.rightChild;
            }
        }
    }

    /**
     * 中序遍历非递归实现
     */
    public void nonRecInOrder() {
        this.nonRecInOrder(this.root);
    }

    public void nonRecInOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node;
        while (p != null || stack.size() > 0) {
            while (p != null) {
                stack.push(p);
                p = p.leftChild;
            }

            if (stack.size() > 0) {
                p = stack.pop();
                this.visited(p);
                p = p.rightChild;
            }
        }
    }

    /**
     * 后续遍历非递归实现
     */
    public void nonRecPostOrder() {
        this.nonRecPostOrder(this.root);
    }

    /**
     * 要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。 如果P不存在左孩子和右孩子，则可以直接访问它； 或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。
     * 若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了每次取栈顶元素的时候，左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问
     */
    public void nonRecPostOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node;
        stack.push(p);
        while (!stack.isEmpty()) {
            p = stack.peek();
            if (p == null) {
                return;
            }

            boolean leftChildVisited = (p.leftChild == null || p.leftChild.isVisited);
            boolean rightChildVisited = (p.rightChild == null || p.rightChild.isVisited);
            if (leftChildVisited && rightChildVisited) {
                this.visited(p);
                stack.pop();
            } else {
                if (p.rightChild != null) {
                    stack.push(p.rightChild);
                }

                if (p.leftChild != null) {
                    stack.push(p.leftChild);
                }
            }
        }
    }

    /**
     * 层次遍历(广度优先遍历)
     */
    public void broadFirstTraverse(TreeNode node) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(node);

        while (!treeNodeQueue.isEmpty()) {
            TreeNode p = treeNodeQueue.poll();
            this.visited(p);

            if (p.getLeftChild() != null) {
                treeNodeQueue.add(p.getLeftChild());
            }

            if (p.getRightChild() != null) {
                treeNodeQueue.add(p.getRightChild());
            }
        }
    }
}

