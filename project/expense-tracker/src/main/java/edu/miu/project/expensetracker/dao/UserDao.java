package edu.miu.project.expensetracker.dao;

import edu.miu.project.expensetracker.db.JdbcUtil;
import edu.miu.project.expensetracker.model.Category;
import edu.miu.project.expensetracker.model.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    public void saveUser(User user) {
        String query = "INSERT INTO users (username, password, role, budget_limit) VALUES(?,?, ?, ?)";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setBigDecimal(4, BigDecimal.valueOf(user.getBudgetLimit()));
            stmt.executeUpdate();
            System.out.println("User added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
