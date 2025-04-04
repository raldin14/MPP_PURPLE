package edu.miu.lab4.probC.app;

import edu.miu.lab4.probC.domain.order.Order;
import edu.miu.lab4.probC.domain.payroll.Commissioned;
import edu.miu.lab4.probC.domain.payroll.Compensable;
import edu.miu.lab4.probC.domain.payroll.Hourly;
import edu.miu.lab4.probC.domain.payroll.Salaried;

import java.time.LocalDate;

public class PayrollApp {
    public static void main(String[] args) {
        Compensable emp1 = new Hourly("RAL001", 20.0, 40);
        Compensable emp2 = new Salaried("DYLAN001", 5000.0);
        Commissioned emp3 = new Commissioned("NAU001", 3000.0, 0.10);

        emp3.addOrder(new Order(1, LocalDate.of(2025, 4, 1), 5000));
        emp3.addOrder(new Order(2, LocalDate.of(2025, 4, 1), 3000));
        emp3.addOrder(new Order(3, LocalDate.of(2025, 3, 1), 2000)); // Not included

        System.out.println("=== HOURLY ===");
        emp1.print();
        emp1.calcCompensation(4, 2025).print();

        System.out.println("\n=== SALARIED ===");
        emp2.print();
        emp2.calcCompensation(4, 2025).print();

        System.out.println("\n=== COMMISSIONED ===");
        emp3.print();
        emp3.calcCompensation(4, 2025).print();
    }
}
