package edu.miu.lab4.probC.domain.payroll;

public interface Compensable {
    Paycheck calcCompensation(int month, int year);
    void print();
}
