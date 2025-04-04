package edu.miu.lab4.probC.domain.order;

import java.time.LocalDate;

public class Order {
    private int orderNo;

    private LocalDate orderDate;

    private double orderAmount;

    public Order(int orderNo, LocalDate orderDate, double orderAmount) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}
