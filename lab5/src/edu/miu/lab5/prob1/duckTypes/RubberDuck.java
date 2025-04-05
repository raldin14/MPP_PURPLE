package edu.miu.lab5.prob1.duckTypes;

import edu.miu.lab5.prob1.behaviour.flyBehaivour.CannontFly;
import edu.miu.lab5.prob1.behaviour.quackBehaivour.Squeak;

public class RubberDuck extends Duck {
    public RubberDuck(){
        flyBehaviorInterface = new CannontFly();
        quackBehaviorInterface = new Squeak();
    }
    @Override
    public void display(){
        System.out.println("displaying");
    }
}
