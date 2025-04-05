package edu.miu.lab5.prob1.duckTypes;

import edu.miu.lab5.prob1.interfaces.FlyBehaivourInterface;
import edu.miu.lab5.prob1.interfaces.QuackBehaviorInterface;

public abstract class Duck {
    QuackBehaviorInterface quackBehaviorInterface; 
    FlyBehaivourInterface flyBehaviorInterface;
    
    public  void  quack(){
        quackBehaviorInterface.quack();
    }

     public void swim(){
        System.out.println("  swimming");
    }

    public abstract void display();
    
    public void fly(){
        flyBehaviorInterface.fly();
    } 
}
