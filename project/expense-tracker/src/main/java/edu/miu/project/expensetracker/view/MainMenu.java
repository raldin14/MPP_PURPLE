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

        User user = userService.login(username, password);
        if (user != null) {
            Session.setCurrentUser(user);
            System.out.println("Login successful!\n");
        } else {
            System.out.println("Login failed. Invalid credentials.\n");
        }
    }

    private void handleRegister() {
        System.out.print("Choose a username: ");
        String username = scanner.nextLine();
        System.out.print("Choose a password: ");
        String password = scanner.nextLine();
        System.out.print("Enter budget limit: ");
        double budget = Double.parseDouble(scanner.nextLine());

        User user = new User(0, username, password, "USER", budget);
        userService.register(user);
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
                List<User> users = userService.getAllUsers();
                users.forEach(System.out::println);
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
        System.out.println("3. View Expenses");
        System.out.println("4. Add Expense");
        System.out.println("5. Search Expense");
        System.out.println("6. Update Expense");
        System.out.println("7. Delete Expense");
        System.out.println("0. Logout");
        System.out.print("Select: ");
        String choice = scanner.nextLine();

        int userId = Session.getCurrentUser().getId();

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
                expenseService.getExpensesByUserId(userId).forEach(System.out::println);
                break;
            case "4":
                System.out.print("Amount: ");
                double amount = Double.parseDouble(scanner.nextLine());
                System.out.print("Description: ");
                String description = scanner.nextLine();
                System.out.print("Date (yyyy-mm-dd): ");
                LocalDate date = LocalDate.parse(scanner.nextLine());
                System.out.println("List of all categories");
                categoryService.getCategories().forEach(System.out::println);
                System.out.print("Category ID: ");
                int categoryId = Integer.parseInt(scanner.nextLine());
                Expense expense = new Expense(0, amount, description, date, userId, categoryId);
                expenseService.addExpense(expense);
                System.out.println("Expense added.");
                break;
            case "5":
                showSearchMenu();
                break;
            case "6":
                expenseService.getExpensesByUserId(userId).forEach(System.out::println);
                System.out.print("Choose expense to update: ");
                int expenseId = Integer.parseInt(scanner.nextLine());
                Expense expenseById = expenseService.getExpensesById(userId, expenseId);
                System.out.print("Do you want to update amount? y/n: ");
                String select = scanner.nextLine();
                if(select.equals("y")){
                    System.out.print("New amount: ");
                    expenseById.setAmount(Double.parseDouble(scanner.nextLine()));
                }
                System.out.print("Do you want to update description? y/n: ");
                select = scanner.nextLine();
                if(select.equals("y")){
                    System.out.print("New Description: ");
                    expenseById.setDescription(scanner.nextLine());
                }
                System.out.print("Do you want to update Date? y/n: ");
                select = scanner.nextLine();
                if(select.equals("y")){
                    System.out.print("New Date ex. (yyyy-mm-dd): ");
                    expenseById.setDate(LocalDate.parse(scanner.nextLine()));;
                }
                System.out.print("Do you want to update Category? y/n: ");
                select = scanner.nextLine();
                if(select.equals("y")){
                    categoryService.getCategories().forEach(System.out::println);
                    System.out.print("Choose new category ID: ");
                    expenseById.setCategoryId(Integer.parseInt(scanner.nextLine()));
                }
                expenseService.updateExpense(expenseById);
                break;
            case "0":
                Session.logout();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void showSearchMenu(){
        int categoryId = 0;
        String description = "";
        LocalDate date = null;
        int userId = Session.getCurrentUser().getId();
        
        System.out.println("\n===== Search Menu =====");
        System.out.println("1. Search by Category");
        System.out.println("2. Search by Description");
        System.out.println("3. Search by Date");
        System.out.println("0. Back to previous menu");
        System.out.print("Select: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.println("List of all categories");
                categoryService.getCategories().forEach(System.out::println);
                System.out.print("Category ID: ");
                categoryId = Integer.parseInt(scanner.nextLine());
                expenseService.searchExpenses(userId,categoryId,description,date).forEach(System.out::println);
                break;
            case "2":
                System.out.print("Description: ");
                description = scanner.nextLine();
                expenseService.searchExpenses(userId,categoryId,description,date).forEach(System.out::println);
                break;
            case "3":
                System.out.print("Date (yyyy-mm-dd): ");
                date = LocalDate.parse(scanner.nextLine());
                expenseService.searchExpenses(userId,categoryId,description,date).forEach(System.out::println);
                break;
            case "0":
                start();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
