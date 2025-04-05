package edu.miu.lab5.prob1.duckTypes;

import edu.miu.lab5.prob1.behaviour.flyBehaivour.CannontFly;
import edu.miu.lab5.prob1.behaviour.quackBehaivour.MuteQuack;

public class DecoyDuck extends Duck{
    public DecoyDuck(){
        quackBehaviorInterface = new MuteQuack();
        flyBehaviorInterface = new CannontFly();
    }
    @Override
    public void display(){
        System.out.println("Displaying ");
    }    
}
