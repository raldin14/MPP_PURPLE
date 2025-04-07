package edu.miu.lab5.prob2.implement;

import edu.miu.lab5.prob2.ICustomer;
import edu.miu.lab5.prob2.IOrder;

import java.util.ArrayList;
import java.util.List;

public class Customer implements ICustomer {
    private String name;

    private List<IOrder> orders = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    @Override
    public void addOrder(IOrder order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Customer: ").append(name).append("\nOrders:\n");
        for (IOrder order : orders) {
            sb.append(order.toString()).append("\n");
        }
        return sb.toString();
    }

}
