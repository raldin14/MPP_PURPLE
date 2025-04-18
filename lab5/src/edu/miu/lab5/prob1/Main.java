package edu.miu.lab5.prob1;


import edu.miu.lab5.prob1.duckTypes.DecoyDuck;
import edu.miu.lab5.prob1.duckTypes.Duck;
import edu.miu.lab5.prob1.duckTypes.MallardDuck;
import edu.miu.lab5.prob1.duckTypes.RedheadDuck;
import edu.miu.lab5.prob1.duckTypes.RubberDuck;

public class Main {
    public static void main(String[] args){
        Duck[] ducks = { new MallardDuck(), new DecoyDuck(),new RedheadDuck(), new RubberDuck()};

        for(Duck d: ducks){
            System.out.println(d.getClass().getSimpleName() + ":");
            d.display();
            d.fly();
            d.quack();
            d.swim();
        }
    }
    
}
