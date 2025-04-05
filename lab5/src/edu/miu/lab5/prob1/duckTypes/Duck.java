package edu.miu.lab5.prob1.duckTypes;

import edu.miu.lab5.prob1.interfaces.QuackBehaviorInterface;
import edu.miu.lab5.prob1.interfaces.FlyBehaivourInterface;

public class Duck {
    QuackBehaviorInterface quackBehaviorInterface; 
    FlyBehaivourInterface flyBehaviorInterface;
    
    public  void  quack(){
        quackBehaviorInterface.quack();
    }

     public void swim(){
        System.out.println("swimming");
    }


    public void display(){
        System.out.println("display");
    }

    
    public void fly(){
        flyBehaviorInterface.fly();
    }

   


    
}
