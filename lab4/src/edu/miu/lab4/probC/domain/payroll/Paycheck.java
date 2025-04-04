package edu.miu.lab4.probC.domain.payroll;

public final class Paycheck {

    private final double grossPay;

    private final double fica;

    private final double state;

    private final double local;

    private final double medicare;

    private final double socialSecurity;

    public Paycheck(double grossPay, double fica, double state,
                    double local, double medicare, double socialSecurity) {
        this.grossPay = grossPay;
        this.fica = fica;
        this.state = state;
        this.local = local;
        this.medicare = medicare;
        this.socialSecurity = socialSecurity;
    }

    public void print() {
        System.out.printf("Gross Pay: %.2f\nFICA: %.2f\nState: %.2f\nLocal: %.2f\nMedicare: %.2f\nSocial Security: %.2f\n",
                grossPay, fica, state, local, medicare, socialSecurity);
        System.out.printf("Net Pay: %.2f\n", getNetPay());
    }

    public double getNetPay() {
        return grossPay - (fica + state + local + medicare + socialSecurity);
    }
}
