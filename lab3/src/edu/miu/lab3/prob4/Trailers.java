package edu.miu.lab3.prob4;

public class Trailers extends Property{
    private static double rent = 500;

    public Trailers(String trailerPark){
        super(trailerPark, rent);
        //this.trailerPark = trailerPark;
    }

    public double getRent(){
        return rent;
    }
}
