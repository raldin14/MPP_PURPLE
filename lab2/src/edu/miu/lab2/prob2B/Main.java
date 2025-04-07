package edu.miu.lab2.prob2B;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("A123", "Apple Air");

        order.addOrderLine("MacBook Pro");
        order.addOrderLine("Magic Mouse");
        order.addOrderLine("Apple Watch");

        System.out.println(order);

        // Print each product and its associated order (bidirectional test)
        for (OrderLine line : order.getOrderLines()) {
            System.out.println("Product: " + line.getProductName() +
                    ", belongs to Order: " + line.getOrder().getOrderNum());
        }
    }
}
