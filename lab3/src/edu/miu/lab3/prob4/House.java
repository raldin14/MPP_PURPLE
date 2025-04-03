package edu.miu.lab3.prob4;

public class House extends Property{
    private static double rent = 0.1;
    private double lotSize;

    public House(String address, double lotSize){
        super(address,rent);
        this.lotSize = lotSize;
    }
    
    @Override
    public double getRent(){
        return rent * lotSize;
    }
}
