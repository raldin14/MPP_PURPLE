package edu.miu.project.expensetracker.model;

import java.time.LocalDate;

public class Expense {
    private int id;

    private double amount;

    private String description;

    private LocalDate date;

    private int userId;

    private int categoryId;

    public Expense() {
    }

    public Expense(int id, double amount, String description, LocalDate date, int userId, int categoryId) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                '}';
    }
}
