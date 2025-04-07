package edu.miu.lab5.prob2.implement;

import edu.miu.lab5.prob2.IItem;
import edu.miu.lab5.prob2.IOrder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Order implements IOrder {
    private LocalDate orderDate;

    private List<IItem> items = new ArrayList<>();

    // Constructor is package-private to restrict access
    Order(LocalDate date) {
        this.orderDate = date;
    }

    void addItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order Date: ").append(orderDate).append("\n");
        for (IItem item : items) {
            sb.append("  - ").append(item.toString()).append("\n");
        }
        return sb.toString();
    }
}
