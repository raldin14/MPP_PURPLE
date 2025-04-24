package edu.miu.project.expensetracker.service;

import edu.miu.project.expensetracker.dao.ReportDao;
import edu.miu.project.expensetracker.model.Expense;
import edu.miu.project.expensetracker.model.Report;
import edu.miu.project.expensetracker.model.ReportType;

import java.time.LocalDate;
import java.util.List;

public class ReportService {
    private ReportDao reportDao = new ReportDao();

    public Report generateByCategory(int userId, int categoryId) {
        List<Expense> list = reportDao.getExpensesByCategory(userId, categoryId);
        double total = list.stream().mapToDouble(Expense::getAmount).sum();
        return new Report(ReportType.BY_CATEGORY, total, list);
    }

    public Report generateByDateRange(int userId, LocalDate start, LocalDate end) {
        List<Expense> list = reportDao.getExpensesByDateRange(userId, start, end);
        double total = list.stream().mapToDouble(Expense::getAmount).sum();
        return new Report(ReportType.BY_DATE_RANGE, total, list);
    }
}