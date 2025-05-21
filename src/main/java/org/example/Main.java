package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker();

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Monthly Summary");
            System.out.println("4. Load from Input File");
            System.out.println("5. Save and Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    tracker.addTransactionFromInput(sc, "Income");
                    break;
                case 2:
                    tracker.addTransactionFromInput(sc, "Expense");
                    break;
                case 3:
                    System.out.print("Enter month (1-12): ");
                    int month = sc.nextInt();
                    System.out.print("Enter year: ");
                    int year = sc.nextInt();
                    tracker.showMonthlySummary(month, year);
                    break;
                case 4:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter file name (e.g., data.txt): ");
                    String fileName = sc.nextLine();
                    tracker.loadFromTextFile(fileName);
                    break;
                case 5:
                    tracker.saveToFile();
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
