package lab3.src.edu.miu.lab3.prob3.composition;

public class Cylinder {
    private Circle base;
    private double height;
    

    public Cylinder(double radius, double height){
        this.base = new Circle(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

       public double computeVolume(){
        return base.computeArea() * height;

    }

       public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5, 10);
        System.out.println("Volume of Cylinder: " + cylinder.computeVolume());
    }




    
}
