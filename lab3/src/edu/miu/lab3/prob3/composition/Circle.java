package lab3.src.edu.miu.lab3.prob3.composition;

public class Circle {
    private double radius;

   

    Circle(double radius){
        this.radius = radius;
    }

     public double getRadius() {
        return radius;
    }


    public double computeArea(){
        return Math.PI* radius * radius;
    }

 


    
}
