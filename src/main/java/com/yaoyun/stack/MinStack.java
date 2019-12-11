package com.yaoyun.stack;

/**
 * @author yaoyun created on 12月 09, 2019
 * @version 1.0
 */

/* https://leetcode.com/problems/min-stack/description/ */
public class MinStack {

    private StackArray dataStack;
    private StackArray minStack;
    private int min;

    public MinStack() {
        dataStack = new StackArray();
        minStack = new StackArray();
        min = Integer.MAX_VALUE;
    }

    public void push(int element) {
        dataStack.push(element);
        min = Math.min(min, element);
        minStack.push(min);
    }

    public void pop(){
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
