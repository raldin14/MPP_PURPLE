package edu.miu.lab4.probC.domain.payroll;

public class Hourly extends Employee {
    private double hourlyWage;

    private double hoursPerWeek;

    public Hourly(String empId, double hourlyWage, double hoursPerWeek) {
        super(empId);
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    protected double calcGrossPay(int month, int year) {
        return hourlyWage * hoursPerWeek * 4;
    }
}
