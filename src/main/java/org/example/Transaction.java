package org.example;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction implements Serializable {
    private double amount;
    private String category;
    private String subCategory;
    private String type;
    private Date date;

    public Transaction(double amount, String category, String subCategory, String type, Date date) {
        this.amount = amount;
        this.category = category;
        this.subCategory = subCategory;
        this.type = type;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public String toString() {
        return String.format("%s | %s | %.2f | %s > %s",
                new SimpleDateFormat("yyyy-MM-dd").format(date),
                type, amount, category, subCategory);
    }
}
