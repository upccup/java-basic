package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;

/**
 * @author yaoyun created on 12月 27, 2019
 * @version 1.0 若它的左子树不为空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不为空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉查找树
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void insert(T t) {
        this.root = this.insert(this.root, t);
    }

    private TreeNode<T> insert(TreeNode<T> p, T t) {
        if (p == null) {
            size++;
            return new TreeNode(size, t);
        }

        if (t.compareTo(p.getData()) < 0) {
            p.setLeftChild(this.insert(p.getLeftChild(), t));
        } else {
            p.setRightChild(this.insert(p.getRightChild(), t));
        }

        return p;
    }

    public TreeNode<T> find(T t){
        return this.find(this.root, t);
    }

    private TreeNode<T> find(TreeNode<T> p, T t) {
        if(p == null) {
            return null;
        }

        if(t.compareTo(p.getData()) <  0) {
            return this.find(p.getLeftChild(), t);
        } else if(t.compareTo(p.getData()) >  0) {
            return this.find(p.getRightChild(), t);
        } else {
            return p;
        }
    }

    /**
     * 寻找最小元素
     * @return
     */
   public T minimum() {
        return this.minimum(this.root).getData();
    }

    private TreeNode<T> minimum(TreeNode<T> p) {
        if (p == null) {
            throw new IllegalArgumentException("empty BST");
        }

        if(p.getLeftChild() == null) {
            return p;
        }

        return this.minimum(p.getLeftChild());
    }

    /**
     * 寻找最大元素
     * @return
     */
    public T maximum() {
       return this.maximum(this.root).getData();
    }

    private TreeNode<T> maximum(TreeNode<T> p) {
        if (p == null) {
            throw new IllegalArgumentException("empty BST");
        }

        if(p.getRightChild() == null) {
            return p;
        }

        return this.maximum(p.getRightChild());
    }

    /**
     * 移除并返回最小元素
     * @return
     */
    public T removeMin() {
        T t = this.minimum();
        this.removeMin(this.root).getData();
        return t;
    }

    private TreeNode<T> removeMin(TreeNode<T> p) {
        if(p ==  null) {
            throw new IllegalArgumentException("empty BST");
        }

        // 从根节点开始一直往左找找到的叶子节点就是最小值
        if(p.getLeftChild() == null) {
            // 如果最小值节点有右孩子则右孩子代替被删除节点为父节点的左孩子
            TreeNode<T> rightChild = p.getRightChild();
            size--;
            p.setRightChild(null);
            return rightChild;
        }

        p.setLeftChild(this.removeMin(p.getLeftChild()));
        return p;
    }

    /**
     * 移除并返回最大元素
     * @return
     */
    public T removeMax() {
        T t = this.maximum();
        this.removeMax(this.root);
        return t;
    }

    private TreeNode<T> removeMax(TreeNode<T> p) {
        if(p ==  null) {
            throw new IllegalArgumentException("empty BST");
        }

        // 同上 从根节点一直往右找找到找到的叶子节点就是最大值
        if(p.getRightChild() == null) {
            TreeNode<T> leftChild = p.getLeftChild();
            size--;
            p.setLeftChild(null);
            return leftChild;
        }

        p.setRightChild(this.removeMax(p.getRightChild()));
        return p;
    }

    /**
     * 移除指定元素
     * @param t
     * @return
     */
    public TreeNode<T> remove(T t) {
        return this.remove(this.root, t);
    }

    /**
     * @param p
     * @param t
     * @return
     */
    private TreeNode<T> remove(TreeNode<T> p, T t) {
        if (p == null) {
            return null;
        }

        TreeNode<T> leftChild = p.getLeftChild();
        TreeNode<T> rightChild = p.getRightChild();
        if (t.compareTo(p.getData()) < 0) {
            p.setLeftChild(this.remove(leftChild, t));
            return p;
        } else if (t.compareTo(p.getData()) > 0) {
            p.setRightChild(this.remove(rightChild, t));
            return p;
        } else {
            // 隐含逻辑如果是叶子节点(左右孩子节点均为空)时直接删除节点即可这步逻辑与只有一个孩子节点的逻辑重合


            // 如果只有一个孩子节点的,则让父节点直接指向子节点
            if (leftChild == null) {
                p.setRightChild(null);
                size--;
                return rightChild;
            }

            if (rightChild == null) {
                p.setLeftChild(null);
                size--;
                return leftChild;
            }

            // 左右孩子均不为空 删除策略是用其右子树最小的数据代替该节点的数据并递归的删除掉右子树中最小数据的节点。
            // 因为右子树中数据最小的节点肯定没有左儿子，所以删除的时候容易一些
            TreeNode<T> rightMinNode = this.minimum(p);
            rightMinNode.setRightChild(this.removeMin(rightChild));
            rightMinNode.setLeftChild(leftChild);

            p.setLeftChild(null);
            p.setRightChild(null);
            return rightMinNode;
        }
    }
}
