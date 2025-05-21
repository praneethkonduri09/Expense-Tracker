# Expense Tracker

A simple command-line application built in Java to manage your income and expenses. This tool helps you track your financial transactions and view monthly summaries.

##  Features

- Add income transactions
- Add expense transactions
- View monthly summary (total income, expenses, and balance)
- Load transactions from a file
- Save and exit with persistence

##  File Format

The file used for loading transactions should follow this format:

Income,2025-05-01,Salary,50000
Expense,2025-05-03,Rent,12000
Expense,2025-05-04,Groceries,3000

markdown
Copy
Edit

## 🛠 Technologies Used

- Java
- File I/O

##  How to Run

1. Compile the Java program:
   ```bash
   javac ExpenseTracker.java
Run the program:

java ExpenseTracker
Choose options from the menu to add/view/save your transactions.

Screenshots:

1)Expense Tracker Menu:
1. Add Income
2. Add Expense
3. View Monthly Summary
4. Load from Input File
5. Save and Exit
Choose an option: 1
Enter category (e.g., Salary, Food, Rent): Salary
Enter sub-category (optional): 
Enter amount: 50000
Enter date (yyyy-MM-dd) or press Enter to use today: 2025-05-01
Transaction added.

Link:https://drive.google.com/file/d/1Whi6V43AyjNZ1hDLIGWbo0mClhcv-uhp/view?usp=sharing

2)Expense Tracker Menu:
1. Add Income
2. Add Expense
3. View Monthly Summary
4. Load from Input File
5. Save and Exit
Choose an option: 2
Enter category (e.g., Salary, Food, Rent): Rent
Enter sub-category (optional): 
Enter amount: 20000
Enter date (yyyy-MM-dd) or press Enter to use today: 2025-05-05
Transaction added.

Link:https://drive.google.com/file/d/1W-Z8q0N226NicjhZXgPliEz6aGqTjhU9/view?usp=sharing

3)Expense Tracker Menu:
1. Add Income
2. Add Expense
3. View Monthly Summary
4. Load from Input File
5. Save and Exit
Choose an option: 3
Enter month (1-12): 5
Enter year: 2025

--- Monthly Summary ---
2025-05-01 | Income | 5000.00 | Salary > Monthly

2025-05-02 | Expense | 150.00 | Food > Lunch

2025-05-01 | Expense | 700.00 | Rent > Apartment

2025-05-10 | Income | 200.00 | Business > Freelance

2025-05-15 | Expense | 100.00 | Travel > Taxi

2025-05-20 | Income | 1200.00 | Salary > Bonus

2025-05-22 | Expense | 300.00 | Food > Grocery

2025-05-01 | Income | 50000.00 | Salary >

2025-05-21 | Expense | 15.00 | Food >

2025-05-05 | Expense | 20000.00 | Rent >

Total Income: 56400.00

Total Expenses: 21265.00

Net Balance: 35135.00

Link:https://drive.google.com/file/d/1SmLf3VpV9w_8kUaXW3nB93arLe_cSZ_x/view?usp=sharing

4)Expense Tracker Menu:
1. Add Income
2. Add Expense
3. View Monthly Summary
4. Load from Input File
5. Save and Exit
Choose an option: 4
Enter file name (e.g., data.txt): sample_transactions.txt
Transaction added.
Transaction added.
Transaction added.
Transaction added.
Transaction added.
Transaction added.
Transaction added.
Data loaded from text file successfully.

Link:https://drive.google.com/file/d/14_vKDWk6N7gMmNPI1gdOKP615Qy61pJv/view?usp=sharing

5)Expense Tracker Menu:
1. Add Income
2. Add Expense
3. View Monthly Summary
4. Load from Input File
5. Save and Exit
Choose an option: 3
Enter month (1-12): 5
Enter year: 2025

--- Monthly Summary ---
2025-05-01 | Income | 5000.00 | Salary > Monthly
2025-05-02 | Expense | 150.00 | Food > Lunch
2025-05-01 | Expense | 700.00 | Rent > Apartment
2025-05-10 | Income | 200.00 | Business > Freelance
2025-05-15 | Expense | 100.00 | Travel > Taxi
2025-05-20 | Income | 1200.00 | Salary > Bonus
2025-05-22 | Expense | 300.00 | Food > Grocery
2025-05-01 | Income | 50000.00 | Salary > 
2025-05-21 | Expense | 15.00 | Food > 
2025-05-05 | Expense | 20000.00 | Rent > 
2025-05-01 | Income | 5000.00 | Salary > Monthly
2025-05-02 | Expense | 150.00 | Food > Lunch
2025-05-01 | Expense | 700.00 | Rent > Apartment
2025-05-10 | Income | 200.00 | Business > Freelance
2025-05-15 | Expense | 100.00 | Travel > Taxi
2025-05-20 | Income | 1200.00 | Salary > Bonus
2025-05-22 | Expense | 300.00 | Food > Grocery
Total Income: 62800.00
Total Expenses: 22515.00
Net Balance: 40285.00

Link:https://drive.google.com/file/d/1dA3-_qsx25LTE0zsBAnSbu_x9UHVMyvo/view?usp=sharing

6)Expense Tracker Menu:
1. Add Income
2. Add Expense
3. View Monthly Summary
4. Load from Input File
5. Save and Exit
Choose an option: 5
Data saved successfully.

Link:https://drive.google.com/file/d/1955ktrwX0FaBojGfCdkOaXywY4Oqf3Ta/view?usp=sharing

 Author
Konduri Praneeth
GitHub
