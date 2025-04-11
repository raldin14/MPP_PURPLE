package edu.miu.project.expensetracker.dao;

import edu.miu.project.expensetracker.db.JdbcUtil;
import edu.miu.project.expensetracker.model.Expense;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDao {
    public List<Expense> findByUserId(int userId) {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses WHERE user_id = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Expense expense = new Expense(
                        rs.getInt("id"),
                        rs.getDouble("amount"),
                        rs.getString("description"),
                        rs.getDate("date").toLocalDate(),
                        rs.getInt("user_id"),
                        rs.getInt("category_id")
                );
                expenses.add(expense);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expenses;
    }

    public void save(Expense expense) {
        String sql = "INSERT INTO expenses (amount, description, date, user_id, category_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, expense.getAmount());
            stmt.setString(2, expense.getDescription());
            stmt.setDate(3, Date.valueOf(expense.getDate()));
            stmt.setInt(4, expense.getUserId());
            stmt.setInt(5, expense.getCategoryId());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
