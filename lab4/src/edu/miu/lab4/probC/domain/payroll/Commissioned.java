package edu.miu.lab4.probC.domain.payroll;

import edu.miu.lab4.probC.domain.order.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee {
    private double baseSalary;

    private double commission;

    private List<Order> orders = new ArrayList<>();

    public Commissioned(String empId, double baseSalary, double commission) {
        super(empId);
        this.baseSalary = baseSalary;
        this.commission = commission;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    protected double calcGrossPay(int month, int year) {
        double total = 0.0;

        int prevMonth = (month == 1) ? 12 : month - 1;
        int prevYear = (month == 1) ? year - 1 : year;

        for (Order o : orders) {
            LocalDate d = o.getOrderDate();
            if (d.getYear() == prevYear && d.getMonthValue() == prevMonth) {
                total += o.getOrderAmount();
            }
        }
        return baseSalary + (total * commission);
    }
}
