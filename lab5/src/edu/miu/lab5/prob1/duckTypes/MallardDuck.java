package edu.miu.lab5.prob1.duckTypes;

import edu.miu.lab5.prob1.behaviour.flyBehaivour.FlyWithWings;
import edu.miu.lab5.prob1.behaviour.quackBehaivour.Quack;

public class MallardDuck extends Duck{
        public MallardDuck(){
                flyBehaviorInterface =  new FlyWithWings();
                quackBehaviorInterface = new Quack();
        }

        @Override
                public void display(){
                System.out.println("  display");
        }
}
