package edu.miu.lab5.prob1.behaviour.quackBehaivour;

import edu.miu.lab5.prob1.interfaces.QuackBehaviorInterface;

public class Squeak implements QuackBehaviorInterface {
    @Override
    public void quack(){
        System.out.println("  squeaking");
    }
}
