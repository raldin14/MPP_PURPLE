package edu.miu.lab9.prob1.ProbD;

class D implements B, C {
    @Override
    public void doSomething() {
        B.super.doSomething(); 
    }
}
