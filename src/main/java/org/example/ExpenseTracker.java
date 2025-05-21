package org.example;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExpenseTracker {
    private List<Transaction> transactions = new ArrayList<>();
    private final String FILE_NAME = "expenses.dat";
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ExpenseTracker() {
        loadFromFile();
    }

    public void addTransaction(double amount, String category, String subCategory, String type, Date date) {
        transactions.add(new Transaction(amount, category, subCategory, type, date));
        System.out.println("Transaction added.");
    }

    public void addTransactionFromInput(Scanner sc, String type) {
        sc.nextLine(); // consume newline
        System.out.print("Enter category (e.g., Salary, Food, Rent): ");
        String category = sc.nextLine();
        System.out.print("Enter sub-category (optional): ");
        String subCategory = sc.nextLine();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.print("Enter date (yyyy-MM-dd) or press Enter to use today: ");
        String dateInput = sc.nextLine();
        Date date;
        try {
            if (dateInput.trim().isEmpty()) {
                date = new Date();
            } else {
                date = sdf.parse(dateInput);
            }
        } catch (Exception e) {
            System.out.println("Invalid date format. Using today's date.");
            date = new Date();
        }

        addTransaction(amount, category, subCategory, type, date);
    }

    public void showMonthlySummary(int month, int year) {
        double totalIncome = 0.0;
        double totalExpense = 0.0;

        System.out.println("\n--- Monthly Summary ---");
        for (Transaction t : transactions) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(t.getDate());

            if (cal.get(Calendar.MONTH) + 1 == month && cal.get(Calendar.YEAR) == year) {
                System.out.println(t);
                if (t.getType().equalsIgnoreCase("Income")) {
                    totalIncome += t.getAmount();
                } else {
                    totalExpense += t.getAmount();
                }
            }
        }

        System.out.printf("Total Income: %.2f\n", totalIncome);
        System.out.printf("Total Expenses: %.2f\n", totalExpense);
        System.out.printf("Net Balance: %.2f\n", totalIncome - totalExpense);
    }

    public void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(transactions);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            transactions = (List<Transaction>) in.readObject();
            System.out.println("Data loaded successfully.");
        } catch (Exception e) {
            transactions = new ArrayList<>();
            System.out.println("No previous data found. Starting fresh.");
        }
    }

    public void loadFromTextFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String type = parts[0].trim();
                    double amount = Double.parseDouble(parts[1].trim());
                    String category = parts[2].trim();
                    String subCategory = parts[3].trim();
                    Date date = sdf.parse(parts[4].trim());
                    addTransaction(amount, category, subCategory, type, date);
                }
            }
            System.out.println("Data loaded from text file successfully.");
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
