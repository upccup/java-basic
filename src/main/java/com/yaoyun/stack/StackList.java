package com.yaoyun.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * @author yaoyun created on 12月 09, 2019
 * @version 1.0
 */
public class StackList<T> implements Stack<T> {

    private List<T> list;

    public StackList() {
        list = new ArrayList<T>();
    }

    public T pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    public void push(T element) {
        list.add(element);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }
}
