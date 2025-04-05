package lab5;

import lab5.duckTypes.DecoyDuck;
import lab5.duckTypes.MallardDuck;
import lab5.duckTypes.RedheadDuck;
import lab5.duckTypes.RubberDuck;

public class Main {
    public static void main(String[] args){
        Duck[] ducks = {
            new MallardDuck(), new DecoyDuck(), new RedheadDuck(), new RubberDuck()};

            for(Duck d: ducks){
                System.out.println(d.getClass().getSimpleName() + ":");
                d.display();
                d.fly();
                d.quack();
                d.swim();
            }
        

    }
    
}
