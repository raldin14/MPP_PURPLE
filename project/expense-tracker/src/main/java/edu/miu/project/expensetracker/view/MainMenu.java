package edu.miu.project.expensetracker.view;

import edu.miu.project.expensetracker.model.Report;
import edu.miu.project.expensetracker.model.User;
import edu.miu.project.expensetracker.service.CategoryService;
import edu.miu.project.expensetracker.service.ReportService;
import edu.miu.project.expensetracker.service.UserService;
import edu.miu.project.expensetracker.session.Session;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private Scanner scanner = new Scanner(System.in);

    private UserService userService = new UserService();

    private CategoryService categoryService = new CategoryService();

    private ReportService reportService = new ReportService();

    public void start() {
        while (true) {
            if (!Session.isLoggedIn()) {
                showLoginMenu();
            } else {
                User user = Session.getCurrentUser();
                if ("ADMIN".equalsIgnoreCase(user.getRole())) {
                    showAdminMenu();
                } else {
                    showUserMenu();
                }
            }
        }
    }

    private void showLoginMenu() {
        System.out.println("===== Expense Tracker =====");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                handleLogin();
                break;
            case "2":
                handleRegister();
                break;
            case "0":
                System.exit(0);
            default:
                System.out.println("Invalid choice!");
        }
    }

    private String promptForRole() {
        while (true) {
            System.out.println("Select Role:");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.print("Enter choice (1 or 2): ");
            String roleChoice = scanner.nextLine();

            switch (roleChoice) {
                case "1":
                    return "ADMIN";
                case "2":
                    return "USER";
                default:
                    System.out.println("Invalid choice. Please select 1 or 2.");
            }
        }
    }


    private void handleLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = userService.login(username, password);
        if (user != null) {
            Session.setCurrentUser(user);

            System.out.println("Login successful!\n");
        } else {
            System.out.println("Login failed. Invalid credentials.\n");
        }
    }


    private void handleRegister() {
        User userRole = Session.getCurrentUser();
        while (true) {
            System.out.print("Choose a username: ");
            String username = scanner.nextLine();

            if (username.isBlank() || username.length() < 4) {
                System.out.println("Username must be at least 4 characters and not blank.");
                continue;
            }


            System.out.print("Choose a password: ");
            String password = scanner.nextLine();

            String role = userRole == null ? "USER" : promptForRole();
            double budget;

            if (role.equals("USER")) {
                System.out.print("Enter budget limit: ");

                try {
                    budget = Double.parseDouble(scanner.nextLine());
                    if (budget <= 0) {
                        System.out.println("Budget must be a positive number.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Budget must be a numeric value.");
                    continue;
                }

            } else {
                budget = 0.0;
            }


            User user = new User(username, password, role, budget);
            if (userService.register(user)) {
                System.out.println("Registration successful. Please Login\n");

                break; // Exit loop after successful registration


            }
            ;
            System.out.println("Registration failed.\n");
            continue;


        }
    }

    private void handleReportMenu(int userId) {
        System.out.println("===== Report Menu =====");
        System.out.println("1. Report by Category");
        System.out.println("2. Report by Date Range");
        System.out.print("Select: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Enter category ID: ");
                int categoryId = Integer.parseInt(scanner.nextLine());
                Report report1 = reportService.generateByCategory(userId, categoryId);
                System.out.println(report1);
                break;
            case "2":
                LocalDate start = readDate("Start date (yyyy-MM-dd): ");
                LocalDate end = readDate("End date (yyyy-MM-dd): ");
                Report report2 = reportService.generateByDateRange(userId, start, end);
                System.out.println(report2);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private LocalDate readDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return LocalDate.parse(input); // ISO_LOCAL_DATE format：yyyy-MM-dd
            } catch (DateTimeParseException e) {
                System.out.println("❌ Invalid date format. Please use yyyy-MM-dd.");
            }
        }
    }

    private void showAdminMenu() {
        System.out.println("\n===== Admin Menu =====");
        System.out.println("1. View All Users");
        System.out.println("2. Register Users/Admin");
        System.out.println("3. Manage Categories");
        System.out.println("0. Logout");
        System.out.print("Select: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                List<User> users = userService.getAllUsers();
                users.forEach(user -> {
                    System.out.println("Id: " + user.getId() + " Username: " + user.getUsername() + " Role: " + user.getRole() + " Budget Limit: $" + user.getBudgetLimit());
                });
                break;
            case "2":
                handleRegister();
                break;
            case "3":
                AdminCategoryManagement adminCategoryManagement = new AdminCategoryManagement();
                adminCategoryManagement.start();
                break;
            case "0":
                Session.logout();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void showUserMenu() {
        System.out.println("\n===== User Menu =====");
        System.out.println("1. View Categories");
        System.out.println("2. Expenses Management");
        System.out.println("3. View Reports");
        System.out.println("0. Logout");
        System.out.print("Select: ");
        String choice = scanner.nextLine();

        int userId = Session.getCurrentUser().getId();
        double budgetLimit = Session.getCurrentUser().getBudgetLimit();
        ExpenseManagement exMnt = new ExpenseManagement(userId, budgetLimit);
        switch (choice) {
            case "1":
                categoryService.getCategoriesByUserId(userId).forEach(System.out::println);
                break;
            case "2":
                exMnt.startExpenses();
                break;
            case "3":
                handleReportMenu(userId);
                break;
            case "0":
                Session.logout();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
