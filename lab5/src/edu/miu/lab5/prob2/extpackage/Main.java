package edu.miu.lab5.prob2.extpackage;

import edu.miu.lab5.prob2.Customer;
import edu.miu.lab5.prob2.Order;
import edu.miu.lab5.prob2.factory.CustOrderFactory;

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
        // Create a Customer through the factory
        Customer dylan = CustOrderFactory.createCustomer("Dylan");
        Order order1 = CustOrderFactory.createOrder(dylan, LocalDate.now());
        CustOrderFactory.addItemToOrder(order1, "Strawberries");
        CustOrderFactory.addItemToOrder(order1, "Carrots");

        Order order2 = CustOrderFactory.createOrder(dylan, LocalDate.now());
        CustOrderFactory.addItemToOrder(order2, "Crisp Apples");

        System.out.println(dylan);

    }
}

		
