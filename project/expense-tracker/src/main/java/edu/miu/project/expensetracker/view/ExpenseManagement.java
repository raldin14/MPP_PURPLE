package edu.miu.project.expensetracker.view;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
    private double totalRexpnse;
    private double budgetLimit;
    private boolean mnt;
    public ExpenseManagement(int userId, double budgetLimit){
        this.userId = userId;
        this.budgetLimit = budgetLimit;
        this.totalRexpnse = getTotalAmount();
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
                    System.out.println(" ID: "+exp.getId()+" Amount: "+exp.getAmount()+" Description: "+exp.getDescription()+" Date: "+exp.getDate()+" CategoryID: "+exp.getCategoryId());
                });
                System.out.printf("Total Amount of Expenses : %.2f",getTotalAmount());
                break;
            case "3":
                do{
                    try {
                        System.out.print("Amount: ");
                        double amount = budgetLimit(Double.parseDouble(scanner.nextLine()));
                        System.out.print("Description: ");
                        String description = scanner.nextLine();
                        System.out.print("Date (yyyy-mm-dd): ");
                        LocalDate date = checkDate(scanner.nextLine() );// LocalDate.parse(scanner.nextLine());
                        System.out.println("List of all categories");
                        categoryService.getCategories().forEach(System.out::println);
                        System.out.print("Category ID: ");
                        int categoryId = Integer.parseInt(scanner.nextLine());
                        Expense expense = new Expense(0, amount, description, date, userId, categoryId);
                        if(expense != null){
                            expenseService.addExpense(expense);
                            System.out.print("Expense added. Do you want to add one more? y/n: ");
                            choice = scanner.nextLine();
                        }else {System.out.println("Cannot add empty information");}                        
                        
                    } catch (Exception e) {
                        System.out.println("Something went wrong, please add the values again");
                    }
                    
                }while (choice.equals("y"));
                
                break;
            case "4":
                do{
                    try {
                        expenseService.getExpensesByUserId(userId).forEach(System.out::println);
                        System.out.print("Choose expense to update: ");
                        //int expenseId = checkExpenseId(Integer.parseInt(scanner.nextLine()), userId);
                        Expense expenseById = checkExpenseId(Integer.parseInt(scanner.nextLine()), userId);//expenseService.getExpensesById(userId, expenseId);
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
                            expenseById.setDate(checkDate(scanner.nextLine()));//LocalDate.parse(scanner.nextLine()));;
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
                    } catch (Exception e) {
                        System.out.println("Something went wrong, please add the values again");
                    }                    
                }while (choice.equals("y"));

                break;
            case "5":
                do {
                    expenseService.getExpensesByUserId(userId).forEach(System.out::println);
                    System.out.print("Choose expense to Delete: ");
                    //int expenseId = checkExpenseId(Integer.parseInt(scanner.nextLine()), userId);//Integer.parseInt(scanner.nextLine());
                    Expense expenseById = checkExpenseId(Integer.parseInt(scanner.nextLine()), userId);//expenseService.getExpensesById(userId, expenseId);
                    System.out.print("Are you sure you want to delete expense with ID "+expenseById.getId()+"? y/n: ");
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
        String choice = "";
        do {
            System.out.println("\n===== Search Menu =====");
            System.out.println("1. Search by Category");
            System.out.println("2. Search by Description");
            System.out.println("3. Search by Date");
            System.out.println("0. Exit search menu");
            System.out.print("Select: ");
            choice = scanner.nextLine();
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
                    try {
                        System.out.print("Date (yyyy-mm-dd): ");
                        date = checkDate(scanner.nextLine() );//LocalDate.parse(scanner.nextLine());
                        expenseService.searchExpenses(userId,categoryId,description,date).forEach(System.out::println);
                        break;
                    } catch (Exception e) {
                        System.out.println("Something went wrong, please add the values again");
                    }
                case "0":
                    return;             
                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println("Do you want to keep searching? y/n: ");
            choice = scanner.nextLine();
        } while (choice.equals("y"));
        
    }

    private LocalDate checkDate(String date ){
        System.out.print(date);
        String input = date;
        while (true) {
            
            try {
                return LocalDate.parse(input); // ISO_LOCAL_DATE format：yyyy-MM-dd
            } catch (DateTimeParseException e) {
                System.out.print("❌ Invalid date format. Please use yyyy-MM-dd. ");
                input = scanner.nextLine();
            }
        }
    }

    private double getTotalAmount(){
        return expenseService.getExpensesByUserId(userId).stream().mapToDouble(t -> t.getAmount()).sum();
    }

    private double budgetLimit(double amount){
        double newamount = totalRexpnse + amount;
        while (true){
            if(newamount > budgetLimit){
                System.out.println("the amount is over the budget limit");
                System.out.println("Budget Limit: "+ budgetLimit);
                System.out.println("Total Expenses: "+ totalRexpnse);
                System.out.print("please choose anotehr amount");
                newamount = Double.parseDouble(scanner.nextLine());
            }else{
                return newamount;
            }
        }      
    }

    private Expense checkExpenseId(int id, int userId){
        System.out.println(expenseService.getExpensesById(userId, id).getId());
        while (true) {
            if(expenseService.getExpensesById(userId, id).getId() != 0){
                return expenseService.getExpensesById(userId, id);
            }else{
                System.out.print("Id doesn't exist please select one: ");
                id = scanner.nextInt();
            }
        }        
    }
}
