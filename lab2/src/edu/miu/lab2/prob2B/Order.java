package edu.miu.lab2.prob2B;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items = new ArrayList<>();

    public void addItem(String name) {
        items.add(new Item(name));
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order with items: " + items;
    }
}
