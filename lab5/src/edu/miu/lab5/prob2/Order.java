package edu.miu.lab5.prob2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private LocalDate orderDate;

    private List<Item> items;

    //use a factory method
    private Order(LocalDate orderDate) {
        this.orderDate = orderDate;
        items = new ArrayList<Item>();
    }

    public static Order newOrder(Customer cust, LocalDate date) {
        if (cust == null) throw new NullPointerException("Null customer");
        Order ord = new Order(date);
        cust.addOrder(ord);
        return ord;
    }

    public void addItem(String name) {
        items.add(new Item(name));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Date: ").append(orderDate).append("\n");
        for (Item item : items) {
            sb.append("  - ").append(item.toString()).append("\n");
        }
        return sb.toString();
    }
}
