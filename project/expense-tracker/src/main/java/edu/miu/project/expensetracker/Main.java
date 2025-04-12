package edu.miu.project.expensetracker;

import edu.miu.project.expensetracker.db.JdbcUtil;
import edu.miu.project.expensetracker.view.MainMenu;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println(" Welcome to Expense Tracker Console App ");
        System.out.println("=====================================");

       try (Connection connection = JdbcUtil.getConnection()) {
           if (connection != null) {
                System.out.println("Database connection successful!");
            } else {
                System.out.println("Failed to connect to database.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return;
        }

        //
        MainMenu mainMenu = new MainMenu();
        mainMenu.start();
    }

}
