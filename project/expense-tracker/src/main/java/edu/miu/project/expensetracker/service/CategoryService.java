package edu.miu.project.expensetracker.service;

import edu.miu.project.expensetracker.dao.CategoryDao;
import edu.miu.project.expensetracker.model.Category;

import java.util.List;

public class CategoryService {
    private CategoryDao categoryDao = new CategoryDao();

    public void addCategory(Category category) {
        categoryDao.save(category);
    }

    public List<Category> getCategories() {
        return categoryDao.listCategories();
    }

    public List<Category> getCategoriesByUserId(int userId) {
        return categoryDao.findByUserId(userId);
    }

    public void updateCategory(Category category) {
        categoryDao.update(category);
    }

    public void deleteCategory(int id) {
        categoryDao.delete(id);
    }
}
