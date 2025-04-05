package lab5.behaviour.flyBehaivour;

import lab5.interfaces.FlyBehaivourInterface;

public class CannontFly implements FlyBehaivourInterface {
    @Override
    public void fly(){

        System.out.println("cannot fly");

    }
}
