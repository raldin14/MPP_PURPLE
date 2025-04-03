package edu.miu.lab2.prob2B;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderNum;

    private List<OrderLine> orderLines;

    public Order(String orderNum) {
        this.orderNum = orderNum;
        this.orderLines = new ArrayList<>();
    }

    public void addOrderLine(String productName) {
        OrderLine line = new OrderLine(productName);
        orderLines.add(line);
    }

    public String getOrderNum() {
        return orderNum;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    @Override
    public String toString() {
        return "Order #" + orderNum + ", lines: " + orderLines;
    }
}
