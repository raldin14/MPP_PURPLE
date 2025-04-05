package lab5;

import lab5.interfaces.FlyBehaivourInterface;
import lab5.interfaces.QuackBehaviorInterface;

public class Duck implements QuackBehaviorInterface, FlyBehaivourInterface {

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
