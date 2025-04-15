package edu.miu.lab9.prob1.ProbD;

interface C extends A {
    default void doSomething() {
        System.out.println("C says Hello");
    }
}
