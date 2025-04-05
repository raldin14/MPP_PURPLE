package edu.miu.lab5.prob1.duckTypes;

import edu.miu.lab5.prob1.behaviour.flyBehaivour.FlyWithWings;
import edu.miu.lab5.prob1.behaviour.quackBehaivour.Quack;

public class RedheadDuck extends Duck {
    public RedheadDuck(){
        flyBehaviorInterface = new FlyWithWings();
        quackBehaviorInterface = new Quack();
    }

    @Override
    public void display(){
        System.out.println("  displaying");
    }
}
