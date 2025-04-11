package edu.miu.project.expensetracker.model;

public class User {
    private int id;

    private String username;

    private String password;

    private String role; // "ADMIN" or "USER"

    private double budgetLimit;

    public User() {
    }

    public User(int id, String username, String password, String role, double budgetLimit) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.budgetLimit = budgetLimit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getBudgetLimit() {
        return budgetLimit;
    }

    public void setBudgetLimit(double budgetLimit) {
        this.budgetLimit = budgetLimit;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", budgetLimit=" + budgetLimit +
                '}';
    }
}
