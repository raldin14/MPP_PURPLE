package edu.miu.project.expensetracker.view;

import edu.miu.project.expensetracker.model.Category;
import edu.miu.project.expensetracker.service.CategoryService;
import edu.miu.project.expensetracker.session.Session;

import java.util.Scanner;

public class AdminCategoryManagement {

    private CategoryService categoryService = new CategoryService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n===== Category Management =====");
            System.out.println("1. View All Categories");
            System.out.println("2. Add Category");
            System.out.println("3. Update Category");
            System.out.println("4. Delete Category");
            System.out.println("0. Back");
            System.out.print("Select: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    categoryService.getCategories().forEach(System.out::println);
                    break;
                case "2":
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();
                    int adminId = Session.getCurrentUser().getId();
                    categoryService.addCategory(new Category(0, name, desc, adminId));
                    break;
                case "3":
                    System.out.print("Category ID to update: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    System.out.print("New name: ");
                    String newName = scanner.nextLine();
                    System.out.print("New description: ");
                    String newDesc = scanner.nextLine();
                    Category updateCat = new Category(updateId, newName, newDesc, 0);
                    categoryService.updateCategory(updateCat);
                    break;
                case "4":
                    System.out.print("Category ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    categoryService.deleteCategory(deleteId);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}