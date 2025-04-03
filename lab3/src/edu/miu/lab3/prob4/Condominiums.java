package edu.miu.lab3.prob4;

public class Condominiums extends Property {
    private static double rent = 400;
    private int floors;

    public Condominiums(String address, int floors){
        super(address, rent);
        this.floors = floors;
    }

    public double getRent(){
        return rent * floors;
    }
}
