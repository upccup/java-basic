package com.yaoyun.stack;

import java.util.EmptyStackException;

/**
 * @author yaoyun created on 12月 09, 2019
 * @version 1.0
 */
public class StackArray {

    private int[] array;
    private int top;

    private final static int size = 100;

    public StackArray() {
        array = new int[size];
        top = -1;
    }

    public void push(int element) {
        if (top == size - 1) {
            throw new StackOverflowError();
        }

        array[++top] = element;
    }

    public int pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }

        return array[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int peek() {
        if(top == -1) {
            throw new EmptyStackException();
        }

        return array[top];
    }
}
