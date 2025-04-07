package edu.miu.lab5.prob2.implement;

import edu.miu.lab5.prob2.ICustomer;
import edu.miu.lab5.prob2.IOrder;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Factory class to encapsulate the creation of Customer and Order instances.
 * Enforces package-level constructor access and centralizes the creation logic.
 */
public class CustOrderFactory {

    // Private constructor to prevent instantiation
    private CustOrderFactory() {}

    /**
     * Creates a new Customer instance.
     * <p>
     * This method validates the input name and ensures customers
     * can only be created through the factory.
     *
     * @param name Name of the customer (must not be null or blank)
     * @return ICustomer interface representing the new Customer
     * @throws IllegalArgumentException if name is null or blank
     */
    public static ICustomer createCustomer(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer name must not be empty");
        }
        return new Customer(name);
    }


    /**
     * Creates a new Order for a specific customer and adds it to the customer's order list.
     * @param customer Customer placing the order
     * @param date Date of the order
     * @return IOrder reference
     */
    public static IOrder createOrder(ICustomer customer, LocalDate date) {
        Objects.requireNonNull(customer, "Customer must not be null");
        Objects.requireNonNull(date, "Order date must not be null");

        IOrder order = new Order(date); // Note: Order constructor is package-private
        customer.addOrder(order);
        return order;
    }

    /**
     * Adds an item to a given order.
     *
     * @param order IOrder object to which the item should be added
     * @param itemName Name of the item to add
     * @throws NullPointerException if order or item name is null
     * @throws IllegalArgumentException if item name is blank
     */
    public static void addItemToOrder(IOrder order, String itemName) {
        Objects.requireNonNull(order, "Order cannot be null");
        Objects.requireNonNull(itemName, "Item name cannot be null");

        // Downcast to access package-private method
        if (order instanceof Order concreteOrder) {
            concreteOrder.addItem(new Item(itemName));
        } else {
            throw new IllegalArgumentException("Unsupported IOrder implementation");
        }
    }

}
