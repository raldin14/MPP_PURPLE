package edu.miu.lab5.prob2.implement;

import edu.miu.lab5.prob2.IItem;

public class Item implements IItem {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
