package com.yaoyun;

import com.yaoyun.stack.MinStack;
import com.yaoyun.stack.QueueStack;

public class App {

    public static void main(String[] args) {
        // passByValueExample();

        testMinStack();
        testQueueStack();
    }

    public static void testMinStack() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    public static void testQueueStack() {
        QueueStack queueStack = new QueueStack();
        queueStack.push(5);
        queueStack.push(1);
        queueStack.push(2);
        queueStack.push(8);
        queueStack.push(3);
        queueStack.push(0);
        queueStack.push(4);

        System.out.println(queueStack.peek());
        System.out.println(queueStack.pop());
        System.out.println(queueStack.pop());
        System.out.println(queueStack.pop());
        queueStack.push(22);
        System.out.println(queueStack.peek());
    }


    // Java works exactly like C.
    // You can assign a pointer, pass the pointer to a method, follow the pointer in the method and change the data that was pointed to.
    // However, you cannot change where that pointer points.
    public static void passByValueExample() {
        Dog dog = new Dog("A");
        System.out.println(dog.getObjectAddress());
        passByValueFunc(dog);
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());

        passByValueFunc2(dog);
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());
    }

    public static void passByValueFunc(Dog dog) {
        System.out.println(dog.getObjectAddress());
        dog = new Dog("B");
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());
    }

    public static void passByValueFunc2(Dog dog) {
        System.out.println(dog.getObjectAddress());
        dog.setName("C");
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());
    }
}