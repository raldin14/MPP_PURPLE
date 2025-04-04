package edu.miu.lab5.prob2.factory;

import edu.miu.lab5.prob2.Customer;
import edu.miu.lab5.prob2.Order;

import java.time.LocalDate;
import java.util.Objects;

public class CustOrderFactory {

    /**
     * Creates a new Customer instance.
     *
     * @param name Name of the customer
     * @return Customer object
     */
    public static Customer createCustomer(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer name must not be empty");
        }
        return new Customer(name);
    }

    /**
     * Creates a new Order for the specified customer and date.
     * The order is automatically added to the customer's order list.
     *
     * @param customer Target customer
     * @param date     Date of the order
     * @return Order object
     */
    public static Order createOrder(Customer customer, LocalDate date) {
        Objects.requireNonNull(customer, "Customer cannot be null");
        Objects.requireNonNull(date, "Order date cannot be null");
        return Order.newOrder(customer, date);
    }

    /**
     * Adds an item to the specified order.
     *
     * @param order    Target order
     * @param itemName Name of the item
     */
    public static void addItemToOrder(Order order, String itemName) {
        Objects.requireNonNull(order, "Order cannot be null");
        if (itemName == null || itemName.isBlank()) {
            throw new IllegalArgumentException("Item name must not be empty");
        }
        order.addItem(itemName);
    }

}
