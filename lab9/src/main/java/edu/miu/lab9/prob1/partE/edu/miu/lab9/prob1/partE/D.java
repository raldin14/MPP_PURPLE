package edu.miu.lab9.prob1.partE;

class D implements B, C {
    @Override
    public void doSomething() {
        B.super.doSomething(); 
    }
}
