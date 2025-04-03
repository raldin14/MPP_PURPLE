package edu.miu.lab3.prob4;

public abstract class Property {
    private String address;
    private double rent;

    public Property(String address, double rent){
        this.address = address;
        this.rent = rent;
    }

    public abstract double getRent();

    public String getAddress(){
        return address;
    }
}
