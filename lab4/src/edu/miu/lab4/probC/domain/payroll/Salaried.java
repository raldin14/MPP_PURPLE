package edu.miu.lab4.probC.domain.payroll;

public class Salaried extends Employee {
    private double salary;

    public Salaried(String empId, double salary) {
        super(empId);
        this.salary = salary;
    }

    @Override
    protected double calcGrossPay(int month, int year) {
        return salary;
    }
}
