package edu.miu.lab9.prob1.partE;

interface B extends A {
    default void doSomething() {
        System.out.println("B says Hello");
    }
}
