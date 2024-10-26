/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yoel
 */
import java.util.Scanner;
import java.util.Stack; //For Data Structure Stack
import java.util.LinkedList; //for linklist in fiture 4
import java.util.Queue; //for queue in feature 4
import java.util.Arrays;
import java.util.Comparator;



// For feature 1
class ExpenseNode {
    String category;
    double amount;
    ExpenseNode next;

    public ExpenseNode(String category, double amount) {
        this.category = category;
        this.amount = amount;
        this.next = null;
    }
}

class ExpenseList {
    private ExpenseNode head;

    public ExpenseList() {
        this.head = null;
    }

    //Method for adding expenses
    public void addExpense(String category, double amount) {
        ExpenseNode newNode = new ExpenseNode(category, amount);
        if (head == null) {
            head = newNode;
        } else {
            ExpenseNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Expenses added successfully: " + category + " - Rp" + amount);
    }

    // Method to display all expenses
    public void displayExpenses() {
        if (head == null) {
            System.out.println("No expenses recorded.");
            return;
        }

        System.out.println("Daily Expense List:");
        ExpenseNode current = head;
        while (current != null) {
            System.out.println("Category: " + current.category + ", Total: Rp" + current.amount);
            current = current.next;
        }
    }
}

//For feature 2
class IncomeNode {
    String category;
    double amount;
    IncomeNode next;

    public IncomeNode(String category, double amount) {
        this.category = category;
        this.amount = amount;
        this.next = null;
    }
}

class IncomeList {
    private IncomeNode head;

    public IncomeList() {
        this.head = null;
    }

    // Method for adding income
    public void addIncome(String category, double amount) {
        IncomeNode newNode = new IncomeNode(category, amount);
        if (head == null) {
            head = newNode;
        } else {
            IncomeNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Income added successfully: " + category + " - Rp" + amount);
    }

    // Method to display all income
    public void displayIncomes() {
        if (head == null) {
            System.out.println("No income recorded.");
            return;
        }

        System.out.println("Daily Income List:");
        IncomeNode current = head;
        while (current != null) {
            System.out.println("Category: " + current.category + ", Total: Rp" + current.amount);
            current = current.next;
        }
    }
}

//For feature 3
class FinancialStack {
    private Stack<Double> incomeStack;
    private Stack<Double> expenseStack;

    public FinancialStack() {
        this.incomeStack = new Stack<>();
        this.expenseStack = new Stack<>();
    }

    // Method to add DealyIncome
    public void addIncome(double amount) {
        incomeStack.push(amount);
    }

    // Method to add MonthlyExpense
    public void addExpense(double amount) {
        expenseStack.push(amount);
    }

    // Method for calculating total Dealyincome
    public double getTotalIncome() {
        double total = 0;
        for (double income : incomeStack) {
            total += income;
        }
        return total;
    }

    // Method for calculating total Dealyexpenses
    public double getTotalExpenses() {
        double total = 0;
        for (double expense : expenseStack) {
            total += expense;
        }
        return total;
    }

    // Method for calculating profit/loss
    public double getProfitLoss() {
        return getTotalIncome() - getTotalExpenses();
    }
}

//For feature 4

// Classes for BST Nodes
class TreeNode {
    String month;
    double income;
    double expense;
    TreeNode left, right;

    public TreeNode(String month) {
        this.month = month;
        this.income = 0;
        this.expense = 0;
        left = right = null;
    }
}

// Classes for Binary Search Tree
class BST {
    public TreeNode root;

    public BST() {
        this.root = null;
    }

    // Method to add monthly income and expense data
    public void addMonthlyData(String month, double income, double expense) {
        root = addRecursive(root, month, income, expense);
    }

    private TreeNode addRecursive(TreeNode current, String month, double income, double expense) {
        if (current == null) {
            TreeNode newNode = new TreeNode(month);
            newNode.income = income;
            newNode.expense = expense;
            return newNode;
        }

        int cmp = month.compareTo(current.month);
        if (cmp < 0) {
            current.left = addRecursive(current.left, month, income, expense);
        } else if (cmp > 0) {
            current.right = addRecursive(current.right, month, income, expense);
        } else {
            // If the month already exists, add it to the total
            current.income += income;
            current.expense += expense;
        }
        return current;
    }

    // Method to get monthly data by month
    public TreeNode getMonthlyData(String month) {
        return getMonthlyDataRecursive(root, month);
    }

    private TreeNode getMonthlyDataRecursive(TreeNode current, String month) {
        if (current == null) {
            return null;
        }
        int cmp = month.compareTo(current.month);
        if (cmp < 0) {
            return getMonthlyDataRecursive(current.left, month);
        } else if (cmp > 0) {
            return getMonthlyDataRecursive(current.right, month);
        } else {
            return current; // moon found
        }
    }

    // Method to display all data in BST (in-order traversal)
    public void displayAll(TreeNode node) {
        if (node != null) {
            displayAll(node.left);
            System.out.println("Month: " + node.month + ", Income: Rp" + node.income + ", Expense: Rp" + node.expense);
            displayAll(node.right);
        }
    }

    // Added method to get the root
    public TreeNode getRoot() {
        return root;
    }
}


//For feature 5
// Classes for AVL Tree Nodes
class AVLNode {
    String type;
    double targetAmount;
    double currentAmount;
    AVLNode left, right;
    int height;

    public AVLNode(String type, double targetAmount) {
        this.type = type;
        this.targetAmount = targetAmount;
        this.currentAmount = 0;
        this.left = null;
        this.right = null;
        this.height = 1; // The initial height of the node is 1
    }
}

// Classes for AVL Tree
class AVLTree {
    private AVLNode root;

    public AVLTree() {
        this.root = null;
    }

    public void add(String type, double targetAmount) {
        root = addRecursive(root, type, targetAmount);
    }

    private AVLNode addRecursive(AVLNode node, String type, double targetAmount) {
        if (node == null) {
            return new AVLNode(type, targetAmount);
        }
        if (type.compareTo(node.type) < 0) {
            node.left = addRecursive(node.left, type, targetAmount);
        } else if (type.compareTo(node.type) > 0) {
            node.right = addRecursive(node.right, type, targetAmount);
        } else {
            // If the savings type already exists, we don't add it
            return node;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        // If nodes are not balanced, perform rotation
        if (balance > 1 && type.compareTo(node.left.type) < 0) {
            return rotateRight(node);
        }
        if (balance < -1 && type.compareTo(node.right.type) > 0) {
            return rotateLeft(node);
        }
        if (balance > 1 && type.compareTo(node.left.type) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && type.compareTo(node.right.type) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private AVLNode rotateLeft(AVLNode z) {
        AVLNode y = z.right;
        AVLNode T2 = y.left;

        y.left = z;
        z.right = T2;

        z.height = 1 + Math.max(getHeight(z.left), getHeight(z.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    private AVLNode rotateRight(AVLNode z) {
        AVLNode y = z.left;
        AVLNode T3 = y.right;

        y.right = z;
        z.left = T3;

        z.height = 1 + Math.max(getHeight(z.left), getHeight(z.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    private int getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public void viewSavings(AVLNode node) {
        if (node != null) {
            viewSavings(node.left);
            System.out.println("Saving: " + node.type + ", Target: Rp" + node.targetAmount + ", Current: Rp" + node.currentAmount);
            viewSavings(node.right);
        }
    }

    public AVLNode getRoot() {
        return root;
    }
}

// Classes for Circular Linked List Nodes
class CircularNode {
    String type;
    double targetAmount;
    CircularNode next;

    public CircularNode(String type, double targetAmount) {
        this.type = type;
        this.targetAmount = targetAmount;
        this.next = null;
    }
}

// Class for Circular Linked List
class CircularLinkedList {
    private CircularNode head;

    public CircularLinkedList() {
        head = null;
    }

    public void add(String type, double targetAmount) {
        CircularNode newNode = new CircularNode(type, targetAmount);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Set next to head for circular
        } else {
            CircularNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head; // Keeping it circular
        }
    }

    public void viewSavings() {
        if (head != null) {
            CircularNode temp = head;
            do {
                System.out.println("Saving: " + temp.type + ", Target: Rp" + temp.targetAmount);
                temp = temp.next;
            } while (temp != head);
        }
    }
}

//For feature 6
class Debt {
    String type;
    double amount;
    String dueDate;

    public Debt(String type, double amount, String dueDate) {
        this.type = type;
        this.amount = amount;
        this.dueDate = dueDate;
    }
}

class SortedArray {
    private Debt[] debts;
    private int size;

    public SortedArray(int capacity) {
        debts = new Debt[capacity];
        size = 0;
    }

    public void addDebt(Debt debt) {
        if (size < debts.length) {
            debts[size] = debt;
            size++;
            Arrays.sort(debts, 0, size, Comparator.comparingDouble(d -> d.amount)); // Sort by debt amount
        } else {
            System.out.println("Array is full, can't add new debt.");
        }
    }

    public void viewDebtsByAmount() {
        System.out.println("Debt by amount (largest):");
        for (int i = size - 1; i >= 0; i--) {
            System.out.println("Type: " + debts[i].type + ", Amount: Rp" + debts[i].amount + ", Deadline Date: " + debts[i].dueDate);
        }
    }

    public void viewDebtsByDate() {
        System.out.println("Debt by date:");
        for (int i = 0; i < size; i++) {
            System.out.println("Type: " + debts[i].type + ", Amount: Rp" + debts[i].amount + ", Deadline Date: " + debts[i].dueDate);
        }
    }

    public Debt findDebt(String type) {
        for (Debt debt : debts) {
            if (debt != null && debt.type.equals(type)) {
                return debt;
            }
        }
        return null; // If the debt is not found
    }

    public void reduceDebt(String type, double payment) {
        Debt debt = findDebt(type);
        if (debt != null) {
            debt.amount -= payment;
            if (debt.amount <= 0) {
                System.out.println("Utang " + type + " sudah lunas.");
                // Remove debt from array (by shifting elements)
                int index = Arrays.asList(debts).indexOf(debt);
                for (int i = index; i < size - 1; i++) {
                    debts[i] = debts[i + 1];
                }
                debts[size - 1] = null; // Set the last element to null
                size--;
            }
        } else {
            System.out.println("Debt not found.");
        }
    }
}

public class FinancialManagementApp {
    public static void main(String[] args) {
        // Introduction program
        System.out.println("Welcome to the Financial Management App By : @ELL!");
        System.out.println("Organize your finances well and achieve your financial goals.");

        // Membuat menu utama
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        ExpenseList expenseList = new ExpenseList(); //feature 1
        IncomeList incomeList = new IncomeList();//feature 2
        FinancialStack financialStack = new FinancialStack(); // Inisialisasi stack  for analysis feature 3
        BST monthlyDataBST = new BST(); //for feature 4
        CircularLinkedList savingsList = new CircularLinkedList(); // Inisialisasi Circular Linked List untuk tabungan feature 5
        AVLTree savingsTree = new AVLTree(); // Inisialisasi AVL Tree untuk tabungan feature 5
        SortedArray debtArray = new SortedArray(100); // Inisialisasi Sorted Array untuk utang feature 6
        Queue<Double> paymentQueue = new LinkedList<>(); // Inisialisasi Queue untuk pembayaran feature 6
        
        while (running) {
            System.out.println("\nChoose Fiture:");
            System.out.println("1. Daily Expense Record");
            System.out.println("2. Daily Income Record");
            System.out.println("3. Daily Financial Analysis");
            System.out.println("4. Monthly Financial Analysis");
            System.out.println("5. Savings Goal Tracker");
            System.out.println("6. Debt Monitoring");
            System.out.println("7. Exit");

            System.out.print("Enter your choice (1-7):");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("You select the Daily Expense Record feature.");
                    System.out.print("Enter expense category: ");
                    String category = scanner.next();
                    System.out.print("Enter the amount of expenses: ");
                    double expenseAmount = scanner.nextDouble();
                    expenseList.addExpense(category, expenseAmount); // Add expenses
                    expenseList.displayExpenses(); // view the lsit of expense pengeluaran
                    financialStack.addExpense(expenseAmount);
                    break;
                case 2:
                    System.out.println("You select the Daily Income Record feature.");
                    System.out.print("Enter income category: ");
                    String incomeCategory = scanner.next();
                    System.out.print("Enter income amount: ");
                    double incomeAmount = scanner.nextDouble();
                    incomeList.addIncome(incomeCategory, incomeAmount); // adding income
                    incomeList.displayIncomes(); // view the list of income
                    financialStack.addIncome(incomeAmount);
                    break;
                case 3:
                    System.out.println("You select the Daily Financial Analysis feature.");
                    double totalIncome = financialStack.getTotalIncome();
                    double totalExpenses = financialStack.getTotalExpenses();
                    double profitLoss = financialStack.getProfitLoss();
                    System.out.println("Total Income: Rp" + totalIncome);
                    System.out.println("Total Expenses: Rp" + totalExpenses);
                    System.out.println("Profit/Loss: Rp" + profitLoss);
                    break;
                case 4:
                    System.out.println("You select the Monthly Financial Analysis feature.");
                    boolean monthlyRunning = true;
                    while (monthlyRunning) {
                        System.out.println("Select Operation:");
                        System.out.println("1. Enter Monthly Expenses");
                        System.out.println("2. Enter Monthly Incomes");
                        System.out.println("3. View Data");
                        System.out.println("4. Keluar");

                        System.out.print("Enter your choice (1-4): ");
                        int monthlyChoice = scanner.nextInt();

                        switch (monthlyChoice) {
                            case 1: // Monthly Expenses Input
                                System.out.print("Enter the month in English (Example: January, February): ");
                                String expenseMonth = scanner.next(); // Save the month name for expenses
                                System.out.print("Enter the amount of expenses: ");
                                double monthlyExpenseAmount = scanner.nextDouble(); // Variable for expense
                                monthlyDataBST.addMonthlyData(expenseMonth, 0, monthlyExpenseAmount); // adding expensive
                                System.out.println("Expenses for the month " + expenseMonth + " has been added.");
                                break;

                            case 2: // Input income Monthly
                                System.out.print("Enter the month in English (Example: January, February): ");
                                String incomeMonth = scanner.next(); //  Save the month name for Income
                                System.out.print("Enter the amount of Income: ");
                                double monthlyIncomeAmount = scanner.nextDouble(); // Variable for Income
                                monthlyDataBST.addMonthlyData(incomeMonth, monthlyIncomeAmount, 0); // adding Income
                                System.out.println("Expenses for the month " + incomeMonth + " Expenses for the month");
                                break;

                            case 3: // View Data
                                System.out.println("Monthly Financial Data:");
                                monthlyDataBST.displayAll(monthlyDataBST.root);
                                break;

                            case 4: // Exit
                                monthlyRunning = false;
                                break;  

                            default:
                                System.out.println("Invalid selection. Please select between 1-4.");
                                break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("You select the Savings Goal Tracker feature.. ");
                    System.out.println("Choose the type of savings:");
                    System.out.println("1. Holiday");
                    System.out.println("2. Education");
                    System.out.println("3. Emergency Funds");
                    System.out.print("Enter your choice (1-3)): ");
                    int savingsChoice = scanner.nextInt();
                    String savingsType = "";
                    switch (savingsChoice) {
                        case 1:
                            savingsType = "Holiday";
                            break;
                        case 2:
                            savingsType = "Education";
                            break;
                        case 3:
                            savingsType = "Emergency Funds";
                            break;
                        default:
                            System.out.println("Invalid selection.");
                            continue; //return loop if not have selection (invalid)
                    }

                    // Menu for the selected savings goal
                    boolean savingsRunning = true;
                    while (savingsRunning) {
                        System.out.println("1) Enter target amount");
                        System.out.println("2) Enter money");
                        System.out.println("3) View savings");
                        System.out.println("4) Back");
                        System.out.print("Enter your choice (1-4): ");
                        int savingsOperation = scanner.nextInt();

                        switch (savingsOperation) {
                            case 1:
                                System.out.print("Enter the target amount: ");
                                double targetAmount = scanner.nextDouble();
                                savingsList.add(savingsType, targetAmount); // Adding to Circular Linked List
                                savingsTree.add(savingsType, targetAmount); // Adding to the AVL Tree
                                System.out.println("Target amount for" + savingsType + " has been added.");
                                break;

                            case 2:
                                System.out.print("Enter the money saved: ");
                                double amountSaved = scanner.nextDouble();
                                // Find the corresponding node in the AVL Tree and update currentAmount
                                AVLNode node = savingsTree.getRoot();
                                while (node != null) {
                                    if (node.type.equals(savingsType)) {
                                        node.currentAmount += amountSaved;
                                        System.out.println("The amount of money has been updated to " + savingsType + ".");
                                        break;
                                    }
                                    node = (savingsType.compareTo(node.type) < 0) ? node.left : node.right;
                                }
                                break;

                            case 3:
                                System.out.println("Savings:");
                                savingsTree.viewSavings(savingsTree.getRoot());
                                break;

                            case 4:
                                savingsRunning = false; // back to main menu
                                break;

                            default:
                                System.out.println("Choose is Invalid.");
                                break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("You select the Debt Monitoring feature.");
                     boolean debtRunning = true;

                    while (debtRunning) {
                        System.out.println("1) Enter debt");
                        System.out.println("2) Pay off debts");
                        System.out.println("3) View debt");
                        System.out.println("4) Back");
                        System.out.print("Enter your choice (1-4): ");
                        int debtChoice = scanner.nextInt();

                        switch (debtChoice) {
                            case 1:
                                System.out.print("Debt type:: ");
                                String debtType = scanner.next();
                                System.out.print("Debt amount: ");
                                double debtAmount = scanner.nextDouble();
                                System.out.print("Payment deadline date (format: YYYY-MM-DD):  ");
                                String dueDate = scanner.next();
                                debtArray.addDebt(new Debt(debtType, debtAmount, dueDate));
                                System.out.println("The debt has been added..");
                                break;

                            case 2:
                                System.out.print("Which type of debt??");
                                String paymentType = scanner.next();
                                System.out.print("Enter payment: ");
                                double paymentAmount = scanner.nextDouble();
                                debtArray.reduceDebt(paymentType, paymentAmount);
                                break;

                            case 3:
                                System.out.println("1) View by largest payment");
                                System.out.println("2) View by date entered");
                                System.out.print("Enter your choice (1-2): ");
                                int viewChoice = scanner.nextInt();
                                if (viewChoice == 1) {
                                    debtArray.viewDebtsByAmount();
                                } else if (viewChoice == 2) {
                                    debtArray.viewDebtsByDate();
                                } else {
                                    System.out.println("Invalid choice.");
                                }
                                break;

                            case 4:
                                debtRunning = false; // Back to main menu 
                                break;

                            default:
                                System.out.println("Invalid Choice");
                                break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("Thank you for using this app. See you soon\n" +
                                       "Save your money!!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid selection. Please select between (1-7.");
                    break;
            }
        }
        scanner.close();
    }
}
