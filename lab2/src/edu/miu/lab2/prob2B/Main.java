package edu.miu.lab2.prob2B;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("A123");

        order.addOrderLine("MacBook Pro");
        order.addOrderLine("Magic Mouse");
        order.addOrderLine("Apple Watch");

        System.out.println(order);
    }
}
