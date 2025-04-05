package edu.miu.lab5.prob1;

import lab5.interfaces.QuackBehaviorInterface;

public class Duck implements QuackBehaviorInterface, lab5.interfaces.FlyBehaivourInterface {

    @Override
    public  void  quack(){

    }

     public void swim(){

    }


    public void display(){
        System.out.println("display");
    }

    @Override
    public void fly(){
System.out.println("fly With Wings");
    }

   


    
}
