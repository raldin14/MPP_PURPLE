package edu.miu.project.expensetracker.dao;

import edu.miu.project.expensetracker.db.JdbcUtil;
import edu.miu.project.expensetracker.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    public List<Category> listCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                categories.add(new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("user_id")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    public List<Category> findByUserId(int userId) {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories WHERE user_id = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                categories.add(new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("user_id")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    public void save(Category category) {
        String sql = "INSERT INTO categories (name, description, user_id) VALUES (?, ?, ?)";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.setInt(3, category.getUserId());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
