package edu.miu.lab3.prob2;

public class Appartment {
    private String appt;
    private double rent;

    public Appartment(String appt, double rent){
        this.appt = appt;
        this.rent = rent;
    }

    public String getAppt(){
        return appt;
    }
    
    public double getRent(){
        return rent;
    }
}
