package edu.miu.project.expensetracker.view;

import edu.miu.project.expensetracker.model.Category;
import edu.miu.project.expensetracker.model.Expense;
import edu.miu.project.expensetracker.model.User;
import edu.miu.project.expensetracker.service.CategoryService;
import edu.miu.project.expensetracker.service.ExpenseService;
import edu.miu.project.expensetracker.service.UserService;
import edu.miu.project.expensetracker.session.Session;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private Scanner scanner = new Scanner(System.in);
    private UserService userService = new UserService();
    private CategoryService categoryService = new CategoryService();
    private ExpenseService expenseService = new ExpenseService();

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
        System.out.print("Select: ");
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

    private void handleLogin() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // User user = userService.login(username, password);
        // if (user != null) {
        //     Session.setCurrentUser(user);
        //     System.out.println("Login successful!\n");
        // } else {
        //     System.out.println("Login failed. Invalid credentials.\n");
        // }
    }

    private void handleRegister() {
        System.out.print("Choose a username: ");
        String username = scanner.nextLine();
        System.out.print("Choose a password: ");
        String password = scanner.nextLine();
        System.out.print("Enter budget limit: ");
        double budget = Double.parseDouble(scanner.nextLine());

        User user = new User(0, username, password, "USER", budget);
        // userService.register(user);
        System.out.println("Registration complete. Please login.\n");
    }

    private void showAdminMenu() {
        System.out.println("\n===== Admin Menu =====");
        System.out.println("1. View All Users");
        System.out.println("0. Logout");
        System.out.print("Select: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                // List<User> users = userService.getAllUsers();
                // users.forEach(System.out::println);
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
        System.out.println("2. Add Category");
        System.out.println("3. Expenses Management");
        System.out.println("0. Logout");
        System.out.print("Select: ");
        String choice = scanner.nextLine();

        int userId = Session.getCurrentUser().getId();
        ExpenseManagement exMnt = new ExpenseManagement(userId);
        switch (choice) {
            case "1":
                categoryService.getCategoriesByUserId(userId).forEach(System.out::println);
                break;
            case "2":
                System.out.print("Category name: ");
                String name = scanner.nextLine();
                System.out.print("Description: ");
                String desc = scanner.nextLine();
                categoryService.addCategory(new Category(0, name, desc, userId));
                System.out.println("Category added.");
                break;
            case "3":
                exMnt.startExpenses();
                break;
            case "0":
                Session.logout();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
