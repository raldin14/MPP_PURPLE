package edu.miu.lab3.prob3.inheritance;

public class Circle {
    private double radius;

    Circle(double radius){
        this.radius = radius;
    }

    public  double computeArea(){
         return Math.PI *radius *radius;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Area of circle: " + circle.computeArea());
    }

    
    
}
