package edu.miu.project.expensetracker.view;

import java.time.LocalDate;
import java.util.Scanner;

import edu.miu.project.expensetracker.model.Expense;
import edu.miu.project.expensetracker.service.CategoryService;
import edu.miu.project.expensetracker.service.ExpenseService;
import edu.miu.project.expensetracker.session.Session;

public class ExpenseManagement {
    private Scanner scanner = new Scanner(System.in);
    private CategoryService categoryService = new CategoryService();
    private ExpenseService expenseService = new ExpenseService();

    private int userId;
    private double totalRexpnse = 0;
    private boolean mnt;
    public ExpenseManagement(int userId){
        this.userId = userId;
        mnt = true;
    }

    public void startExpenses() {
        while (mnt) {
            if (!Session.isLoggedIn()) {
                Session.logout();
            } else {
                showExpenseMenu();
            }
        }
    }

    private void showExpenseMenu() {
        System.out.println("\n===== Expenses Management =====");
        System.out.println("1. Search Expense");
        System.out.println("2. View Expenses");
        System.out.println("3. Add Expense");
        System.out.println("4. Update Expense");
        System.out.println("5. Delete Expense");
        System.out.println("0. Exit");
        System.out.print("Select: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                showSearchMenu();
                break;
            case "2":
                expenseService.getExpensesByUserId(userId).forEach(exp -> {
                    totalRexpnse += exp.getAmount();
                    System.out.println(" ID: "+exp.getId()+" Amount: "+exp.getAmount()+" Description: "+exp.getDescription()+" Date: "+exp.getDate()+" CategoryID: "+exp.getCategoryId());
                });
                System.out.printf("Total Amount of Expenses : %.2f",totalRexpnse);
                break;
            case "3":
                do{
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
                    System.out.print("Expense added. Do you want to add one more? y/n: ");
                    choice = scanner.nextLine();
                }while (choice.equals("y"));
                
                break;
            case "4":
                do{
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
                    System.out.print("Do you want to update one more? y/n: ");
                    choice = scanner.nextLine();
                }while (choice.equals("y"));

                break;
            case "5":
                do {
                    expenseService.getExpensesByUserId(userId).forEach(System.out::println);
                    System.out.print("Choose expense to Delete: ");
                    int expenseId = Integer.parseInt(scanner.nextLine());
                    Expense expenseById = expenseService.getExpensesById(userId, expenseId);
                    System.out.print("Are you sure you want to delete expense with ID "+expenseId+"? y/n: ");
                    String select = scanner.nextLine();
                    if(select.equals("y")){
                        expenseService.deleteExpense(expenseById);
                    }else{
                        System.out.println("No expense was deleted!");
                    }
                    System.out.print("Do you want to delete one more? y/n: ");
                    choice = scanner.nextLine();
                }while (choice.equals("y"));
                break;
            case "0":
                mnt = false;
                break;
            default:
                System.out.println("Ivalid choise");
                break;
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
            default:
                System.out.println("Invalid choice.");
        }
    }
}
