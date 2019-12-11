package com.yaoyun.stack;

/**
 * @author yaoyun created on 12月 09, 2019
 * @version 1.0
 */

/* https://leetcode.com/problems/implement-queue-using-stacks/description/ */
public class QueueStack {

    private StackArray inStack;
    private StackArray outStack;

    public QueueStack() {
        inStack = new StackArray();
        outStack = new StackArray();
    }

    public void push(int element) {
        inStack.push(element);
    }

    public int pop() {
        in2out();
        return outStack.pop();
    }

    private void in2out() {
        if(outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public int peek() {
        in2out();
        return outStack.peek();
    }


    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

}
