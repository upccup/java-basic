package com.yaoyun;

/**
 * @author yaoyun created on 12月 06, 2019
 * @version 1.0
 */
public class Dog {

    String name;

    Dog(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getObjectAddress() {
        return super.toString();
    }
}
