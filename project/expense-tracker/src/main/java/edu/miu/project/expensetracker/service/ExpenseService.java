package edu.miu.project.expensetracker.service;

import edu.miu.project.expensetracker.dao.ExpenseDao;
import edu.miu.project.expensetracker.model.Expense;

import java.util.List;

public class ExpenseService {
    private ExpenseDao expenseDao = new ExpenseDao();

    public void addExpense(Expense expense) {
        expenseDao.save(expense);
    }

    public List<Expense> getExpensesByUserId(int userId) {
        return expenseDao.findByUserId(userId);
    }
}
