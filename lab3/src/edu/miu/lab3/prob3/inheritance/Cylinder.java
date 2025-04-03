package edu.miu.lab3.prob3.inheritance;

public class Cylinder extends Circle{
    private  double height;
    
    Cylinder(double radius, double height){
        super(radius);
        this.height = height;
    }

     public double computeVolume(){
        return computeArea() * height;

    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5, 10);
        System.out.println("Volume of Cylinder: " + cylinder.computeVolume());
    }

}
