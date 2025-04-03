package edu.miu.lab2.prob2B;

public class OrderLine {
    private String productName;

    public OrderLine(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return productName;
    }
}
