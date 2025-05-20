//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExpenseTracker {
    private List<Transaction> transactions = new ArrayList();
    private final String FILE_NAME = "expenses.dat";
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ExpenseTracker() {
        this.loadFromFile();
    }

    public void addTransaction(double amount, String category, String subCategory, String type, Date date) {
        this.transactions.add(new Transaction(amount, category, subCategory, type, date));
        System.out.println("Transaction added.");
    }

    public void addTransactionFromInput(Scanner sc, String type) {
        sc.nextLine();
        System.out.print("Enter category (e.g., Salary, Food, Rent): ");
        String category = sc.nextLine();
        System.out.print("Enter sub-category (optional): ");
        String subCategory = sc.nextLine();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        Date date = new Date();
        this.addTransaction(amount, category, subCategory, type, date);
    }

    public void showMonthlySummary(int month, int year) {
        double totalIncome = 0.0;
        double totalExpense = 0.0;
        System.out.println("\n--- Monthly Summary ---");
        Iterator var7 = this.transactions.iterator();

        while(var7.hasNext()) {
            Transaction t = (Transaction)var7.next();
            Calendar cal = Calendar.getInstance();
            cal.setTime(t.getDate());
            if (cal.get(2) + 1 == month && cal.get(1) == year) {
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
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("expenses.dat"));

            try {
                out.writeObject(this.transactions);
                System.out.println("Data saved successfully.");
            } catch (Throwable var5) {
                try {
                    out.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            out.close();
        } catch (IOException var6) {
            System.out.println("Error saving data: " + var6.getMessage());
        }

    }

    public void loadFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("expenses.dat"));

            try {
                this.transactions = (List)in.readObject();
                System.out.println("Data loaded successfully.");
            } catch (Throwable var5) {
                try {
                    in.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            in.close();
        } catch (Exception var6) {
            this.transactions = new ArrayList();
            System.out.println("No previous data found. Starting fresh.");
        }

    }

    public void loadFromTextFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            try {
                while(true) {
                    String line;
                    if ((line = reader.readLine()) == null) {
                        System.out.println("Data loaded from text file successfully.");
                        break;
                    }

                    String[] parts = line.split(",");
                    if (parts.length >= 5) {
                        String type = parts[0].trim();
                        double amount = Double.parseDouble(parts[1].trim());
                        String category = parts[2].trim();
                        String subCategory = parts[3].trim();
                        Date date = this.sdf.parse(parts[4].trim());
                        this.addTransaction(amount, category, subCategory, type, date);
                    }
                }
            } catch (Throwable var12) {
                try {
                    reader.close();
                } catch (Throwable var11) {
                    var12.addSuppressed(var11);
                }

                throw var12;
            }

            reader.close();
        } catch (Exception var13) {
            System.out.println("Error reading file: " + var13.getMessage());
        }

    }
}
