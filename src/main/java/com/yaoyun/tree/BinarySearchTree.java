package com.yaoyun.tree;

import com.yaoyun.tree.BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * @author yaoyun created on 12月 27, 2019
 * @version 1.0 若它的左子树不为空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不为空，则右子树上所有结点的值均大于它的根结点的值;
 * 它的左、右子树也分别为二叉查找树
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

    public TreeNode<T> find(T t) {
        return this.find(this.root, t);
    }

    private TreeNode<T> find(TreeNode<T> p, T t) {
        if (p == null) {
            return null;
        }

        if (t.compareTo(p.getData()) < 0) {
            return this.find(p.getLeftChild(), t);
        } else if (t.compareTo(p.getData()) > 0) {
            return this.find(p.getRightChild(), t);
        } else {
            return p;
        }
    }

    /**
     * 寻找最小元素
     */
    public T minimum() {
        return this.minimum(this.root).getData();
    }

    private TreeNode<T> minimum(TreeNode<T> p) {
        if (p == null) {
            throw new IllegalArgumentException("empty BST");
        }

        if (p.getLeftChild() == null) {
            return p;
        }

        return this.minimum(p.getLeftChild());
    }

    /**
     * 寻找最大元素
     */
    public T maximum() {
        return this.maximum(this.root).getData();
    }

    private TreeNode<T> maximum(TreeNode<T> p) {
        if (p == null) {
            throw new IllegalArgumentException("empty BST");
        }

        if (p.getRightChild() == null) {
            return p;
        }

        return this.maximum(p.getRightChild());
    }

    /**
     * 移除并返回最小元素
     */
    public T removeMin() {
        T t = this.minimum();
        this.removeMin(this.root).getData();
        return t;
    }

    private TreeNode<T> removeMin(TreeNode<T> p) {
        if (p == null) {
            throw new IllegalArgumentException("empty BST");
        }

        // 从根节点开始一直往左找找到的叶子节点就是最小值
        if (p.getLeftChild() == null) {
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
     */
    public T removeMax() {
        T t = this.maximum();
        this.removeMax(this.root);
        return t;
    }

    private TreeNode<T> removeMax(TreeNode<T> p) {
        if (p == null) {
            throw new IllegalArgumentException("empty BST");
        }

        // 同上 从根节点一直往右找找到找到的叶子节点就是最大值
        if (p.getRightChild() == null) {
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
     */
    public TreeNode<T> remove(T t) {
        return this.remove(this.root, t);
    }

    /**
     *
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

    /**
     * 前序遍历
     */
    public void preOrderTraverse() {
        this.preOrderTraverse(this.root);
    }

    private void preOrderTraverse(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        System.out.println(root.getData());
        this.preOrderTraverse(root.getLeftChild());
        this.preOrderTraverse(root.getRightChild());
    }

    /**
     * 前序遍历非递归实现
     */
    public void preOrderTraverseNonRecursion() {
        this.preOrderTraverseNonRecursion(this.root);
    }

    private void preOrderTraverseNonRecursion(TreeNode<T> root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (p != null || stack.size() > 0) {
            while (p != null) {
                System.out.println(p.getData());
                stack.push(p);
                p = p.getLeftChild();
            }

            if (stack.size() > 0) {
                p = stack.pop();
                p = p.getRightChild();
            }
        }
    }

    /**
     * 中序遍历 对于搜索 二叉树来说中序遍历是从小到大遍历所有节点
     */
    public void inOrderTraverse() {
        this.inOrderTraverse(this.root);
    }

    private void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        this.inOrderTraverse(root.getLeftChild());
        System.out.println(root.getData());
        this.inOrderTraverse(root.getRightChild());
    }

    /**
     * 中序遍历非递归实现
     */
    public void inOrderTraverseNonRecursion() {
        this.inOrderTraverseNonRecursion(this.root);
    }

    private void inOrderTraverseNonRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || stack.size() > 0) {
            while (p != null) {
                stack.push(p);
                p = p.getLeftChild();
            }

            if (stack.size() > 0) {
                p = stack.pop();
                System.out.println(p.getData());
                p = p.getRightChild();
            }
        }
    }

    /**
     * 后序遍历
     */
    public void postOrderTraverse() {
        this.postOrderTraverse(this.root);
    }

    private void postOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        this.postOrderTraverse(root.getLeftChild());
        this.postOrderTraverse(root.getRightChild());
        System.out.println(root.getData());
    }

    /**
     * 后序遍历的非递归实现
     */
    public void postOrderTraverseNonRecursion() {
        this.postOrderTraverseNonRecursion(this.root);
    }

    private void postOrderTraverseNonRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p =  root;
        stack.push(p);

        while (stack.size() >0) {
            p = stack.peek();
            if(p == null)  {
                return;
            }

            boolean isLeftChildVisited = (p.getLeftChild() == null || p.getLeftChild().getVisited());
            boolean isRightChildVisited = (p.getRightChild() == null || p.getRightChild().getVisited());
            if(isLeftChildVisited && isRightChildVisited) {
                System.out.println(p.getData());
                p.setVisited(true);
                stack.pop();
            } else {
                if(p.getRightChild() != null) {
                    stack.push(p.getRightChild());
                }

                if(p.getLeftChild() != null) {
                    stack.push(p.getLeftChild());
                }
            }
        }
    }

    public void broadFirstTraverse() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            System.out.println(p.getData());

            if(p.getLeftChild()!=null) {
                queue.add(p.getLeftChild());
            }

            if(p.getRightChild() != null) {
                queue.add(p.getRightChild());
            }
        }
    }
}
