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
        return this.amount;
    }

    public String getCategory() {
        return this.category;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public String getType() {
        return this.type;
    }

    public Date getDate() {
        return this.date;
    }

    public String toString() {
        return String.format("%s | %s | %.2f | %s > %s", (new SimpleDateFormat("yyyy-MM-dd")).format(this.date), this.type, this.amount, this.category, this.subCategory);
    }
}
