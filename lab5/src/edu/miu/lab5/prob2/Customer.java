package edu.miu.lab5.prob2;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;

    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        orders = new ArrayList<Order>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" Orders:\n");
        sb.append("----------------\n");
        for (Order order : orders) {
            sb.append(order.toString()).append("\n");
        }
        return sb.toString();
    }

}
