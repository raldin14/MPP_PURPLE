package edu.miu.lab2.prob2B;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem("Notebook");
        order.addItem("Pen");
        order.addItem("Eraser");

        System.out.println(order);
    }
}
