package edu.miu.lab5.prob2.extpackage;

import edu.miu.lab5.prob2.ICustomer;
import edu.miu.lab5.prob2.IOrder;
import edu.miu.lab5.prob2.implement.CustOrderFactory;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        // =================== OLD APPROACH (without factory) ===================
        /*
        Customer cust = new Customer("Bob");
        Order order1 = Order.newOrder(cust, LocalDate.now());
        order1.addItem("Shirt");
        order1.addItem("Laptop");

        order1 = Order.newOrder(cust, LocalDate.now());
        order1.addItem("Pants");
        order1.addItem("Knife set");

        System.out.println(cust.getOrders());
        */
        // =======================================================================


        // NEW APPROACH (using CustOrderFactory)
        // Step 1: Create a customer using the factory
        ICustomer dylan = CustOrderFactory.createCustomer("Dylan");

        // Step 2: Create first order for the customer
        IOrder order1 = CustOrderFactory.createOrder(dylan, LocalDate.now());
        CustOrderFactory.addItemToOrder(order1, "Strawberries");
        CustOrderFactory.addItemToOrder(order1, "Carrots");

        // Step 3: Create second order for the same customer
        IOrder order2 = CustOrderFactory.createOrder(dylan, LocalDate.now());
        CustOrderFactory.addItemToOrder(order2, "Crisp Apples");

        // Step 4: Display the customer's order summary
        System.out.println(dylan);

    }
}

		
