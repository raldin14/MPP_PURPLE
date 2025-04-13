package edu.miu.project.expensetracker.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.miu.project.expensetracker.db.JdbcUtil;
import edu.miu.project.expensetracker.model.Expense;

public class ExpenseDao {
    public List<Expense> findByUserId(int userId){
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses WHERE user_id = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            
                stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                expenses.add(new Expense(
                    rs.getInt("id"),
                    rs.getDouble("amount"), 
                    rs.getString("description"), 
                    rs.getDate("date").toLocalDate(), 
                    rs.getInt("user_id"), 
                    rs.getInt("category_id"))
                );
            }
            
        } catch (Exception e) {
            e.getStackTrace();
        }
        return expenses;
    }

    public Expense findById(int userId, int id){
        Expense expenses = new Expense();
        String sql = "SELECT * FROM expenses WHERE user_id = ? AND id = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            
                stmt.setInt(1, userId);
                stmt.setInt(2, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                expenses.setId(rs.getInt("id"));
                expenses.setAmount(rs.getDouble("amount"));
                expenses.setDescription(rs.getString("description"));
                expenses.setDate(rs.getDate("date").toLocalDate());
                expenses.setUserId(rs.getInt("user_id"));
                expenses.setCategoryId(rs.getInt("category_id"));
            }
            
        } catch (Exception e) {
            e.getStackTrace();
        }
        return expenses;
    }

    //Search expenses by category, date, or description
    public List<Expense> searchExpenses(int userId, int categoryId, String description, LocalDate date){
        List<Expense> expenses = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM expenses WHERE 1=1 AND user_id = ?");

        if(categoryId != 0){
            sql.append(" AND category_id = ? ");
        }

        if(description != null && !description.isEmpty()){
            sql.append(" AND description like ? ");
        }

        if(date != null ){
            sql.append(" AND date = ? ");
        }

        try (Connection conn = JdbcUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            stmt.setInt(1, userId);

            int index = 2;
            if (categoryId != 0) {
                stmt.setInt(index++, categoryId);
            }
            if (date != null) {
                stmt.setDate(index++, Date.valueOf(date));
            }
            if (description != null && !description.isEmpty()) {
                stmt.setString(index++, "%" + description + "%");
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                expenses.add(new Expense(
                    rs.getInt("id"),
                    rs.getDouble("amount"), 
                    rs.getString("description"), 
                    rs.getDate("date").toLocalDate(), 
                    rs.getInt("user_id"), 
                    rs.getInt("category_id"))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }
    
    public void save(Expense expense) {
        String sql = "INSERT INTO expenses (amount, description,date, user_id,category_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, expense.getAmount());
            stmt.setString(2, expense.getDescription());
            stmt.setDate(3, Date.valueOf(expense.getDate()));
            stmt.setInt(4, expense.getUserId());
            stmt.setInt(5, expense.getCategoryId());

            stmt.executeUpdate();

            System.out.println("\nExpense added : \nDescription : "+expense.getDescription()+"\nAmount : "+expense.getAmount()+"\nDate : "+expense.getDate()+"\nCategory : "+expense.getCategoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateExpense(Expense expense){
        String sql = "UPDATE expenses set amount = ?, description = ?, date = ?,category_id = ? WHERE user_id = ? AND id = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, expense.getAmount());
            stmt.setString(2, expense.getDescription());
            stmt.setDate(3, Date.valueOf(expense.getDate()));
            stmt.setInt(4, expense.getCategoryId());
            stmt.setInt(5, expense.getUserId());
            stmt.setInt(6, expense.getId());

            stmt.executeUpdate();

            System.out.println("\nExpense updated : \nDescription : "+expense.getDescription()+"\nAmount : "+expense.getAmount()+"\nDate : "+expense.getDate());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteExpense(Expense expense){
        String sql = "DELETE FROM expenses WHERE user_id = ? AND id = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, expense.getUserId());
            stmt.setInt(2, expense.getId());

            stmt.executeUpdate();

            System.out.println("\nExpense Deleted : \nDescription : "+expense.getDescription()+"\nAmount : "+expense.getAmount()+"\nDate : "+expense.getDate());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
