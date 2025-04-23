package edu.miu.project.expensetracker.dao;

import edu.miu.project.expensetracker.db.JdbcUtil;
import edu.miu.project.expensetracker.model.Category;
import edu.miu.project.expensetracker.model.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public boolean saveUser(User user) {

        if (usernameExists(user.getUsername())) {
            System.out.println("Username already exists. Please choose another.");
            return false;
        }

        String query = "INSERT INTO users (username, password, role, budget_limit) VALUES(?,?, ?, ?)";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setBigDecimal(4, BigDecimal.valueOf(user.getBudgetLimit()));
            stmt.executeUpdate();
            System.out.println("User added");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean usernameExists(String username) {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // or use a logger
        }
        return false;
    }


    public User findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String role = rs.getString("role");
                    double budget = rs.getDouble("budget_limit");
                    return new User(id,username, null, role, budget);


                } else {
                    System.out.println("Invalid username or password.");
                    return null;
                }
            }

        } catch (SQLException e) {
            System.out.println("An error occurred during login.");
            e.printStackTrace();
            return null;
        }
    }


    public List<User> listAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT id, username, role,budget_limit FROM users";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));
                user.setBudgetLimit((rs.getDouble("budget_limit")));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // or use a logger
        }

        return users;
    }



}
