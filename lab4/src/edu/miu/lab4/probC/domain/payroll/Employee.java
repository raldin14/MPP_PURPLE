package edu.miu.lab4.probC.domain.payroll;

import edu.miu.lab4.probC.domain.payroll.util.TaxRates;

public abstract class Employee implements Compensable {

    protected String empId;

    public Employee(String empId) {
        this.empId = empId;
    }

    // Template method: returns a Paycheck object
    public Paycheck calcCompensation(int month, int year) {
        double gross = calcGrossPay(month, year);
        double fica = gross * TaxRates.FICA;
        double state = gross * TaxRates.STATE;
        double local = gross * TaxRates.LOCAL;
        double medicare = gross * TaxRates.MEDICARE;
        double socialSecurity = gross * TaxRates.SOCIAL_SECURITY;

        return new Paycheck(gross, fica, state, local, medicare, socialSecurity);
    }

    // Abstract method to be implemented by subclasses
    protected abstract double calcGrossPay(int month, int year);

    public void print() {
        System.out.println("Employee ID: " + empId);
    }
}
