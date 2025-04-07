package edu.miu.lab2.prob2B;

public class OrderLine {
    private String productName;

    private Order order; // Reference to the owning Order (bidirectional)

    public OrderLine(String productName, Order order) {
        this.productName = productName;
        this.order = order;
    }

    public String getProductName() {
        return productName;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return productName;
    }
}
