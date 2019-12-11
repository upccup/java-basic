package com.yaoyun.stack;

/**
 * @author yaoyun created on 12月 09, 2019
 * @version 1.0
 */
public interface Stack<T> {

    public T pop();
    public void push(T element);
    public boolean isEmpty();
    public T peek();
}
