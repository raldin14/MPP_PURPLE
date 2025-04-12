package edu.miu.project.expensetracker.service;

import java.time.LocalDate;
import java.util.List;

import edu.miu.project.expensetracker.dao.ExpenseDao;
import edu.miu.project.expensetracker.model.Expense;

public class ExpenseService {
    private ExpenseDao expenseDao = new ExpenseDao();

    public void addExpense(Expense expense) {
        expenseDao.save(expense);
    }

    public List<Expense> getExpensesByUserId(int userId) {
        return expenseDao.findByUserId(userId);
    }

    public List<Expense> searchExpenses(int userId, int categoryId, String description, LocalDate date){
        return expenseDao.searchExpenses(userId, categoryId, description, date);
    }
}
