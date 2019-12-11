package com.yaoyun.stack;

import java.util.EmptyStackException;

/**
 * @author yaoyun created on 12月 09, 2019
 * @version 1.0
 */
public class StackLinked<T> implements Stack<T> {

    private static class Node<U> {
        private U item;
        private Node<U> next;

        Node() {
            this.item=null;
            this.next=null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top;
    StackLinked() {
        top = new Node<T>();
    }

    public T pop() {
        if(this.isEmpty())  {
            throw new EmptyStackException();
        }

        T result = top.item;
        if(!top.end()) {
            top = top.next;
        }

        return result;
    }

    public void push(T element) {
        top = new Node<T>(element, top);
    }

    public T peek() {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }

        return top.item;
    }

    public boolean isEmpty() {
        return top.end();
    }
}
