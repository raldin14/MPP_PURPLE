package edu.miu.project.expensetracker.model;

import java.util.List;

public class Report {
    private ReportType type;

    private double totalAmount;

    private List<Expense> expenses;

    public Report(ReportType type, double totalAmount, List<Expense> expenses) {
        this.type = type;
        this.totalAmount = totalAmount;
        this.expenses = expenses;
    }

    public ReportType getType() {
        return type;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Report Type: ").append(type).append(" ===\n");
        for (Expense expense : expenses) {
            sb.append(expense).append("\n");
        }
        sb.append("Total: $").append(totalAmount);
        return sb.toString();
    }
}