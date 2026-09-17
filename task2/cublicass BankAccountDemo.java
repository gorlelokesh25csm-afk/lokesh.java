// Base class
class Account {
    // Attributes
    protected int accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected String accountType;

    // Constructor
    Account(int accountNumber, String accountHolderName,
            double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs. " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs. " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Transfer method
    public void transfer(Account receiver, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            receiver.balance += amount;

            System.out.println("Transferred: Rs. " + amount);
            System.out.println("From Account: " + this.accountNumber);
            System.out.println("To Account: " + receiver.accountNumber);
        } else {
            System.out.println("Transfer failed: Insufficient balance.");
        }
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Account Number    : " + accountNumber);
        System.out.println("Account Holder    : " + accountHolderName);
        System.out.println("Account Type      : " + accountType);
        System.out.println("Balance           : Rs. " + balance);
    }
}


// SavingsAccount inherits Account
class SavingsAccount extends Account {
    // Additional attribute
    private double interestRate;

    // Constructor
    SavingsAccount(int accountNumber, String accountHolderName,
                   double balance, double interestRate) {

        super(accountNumber, accountHolderName, balance, "Savings");
        this.interestRate = interestRate;
    }

    // Calculate interest
    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;

        System.out.println("Interest Rate     : " + interestRate + "%");
        System.out.println("Interest Earned   : Rs. " + interest);
    }

    // Override display method to show interest rate
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Interest Rate     : " + interestRate + "%");
    }
}


// CurrentAccount inherits Account
class CurrentAccount extends Account {
    // Additional attribute
    private double overdraftLimit;

    // Constructor
    CurrentAccount(int accountNumber, String accountHolderName,
                   double balance, double overdraftLimit) {

        super(accountNumber, accountHolderName, balance, "Current");
        this.overdraftLimit = overdraftLimit;
    }

    // Override withdraw method
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance + overdraftLimit) {
            balance -= amount;

            System.out.println("Withdrawn: Rs. " + amount);
            System.out.println("Withdrawal allowed using overdraft facility.");
        } else {
            System.out.println("Withdrawal failed: Overdraft limit exceeded.");
        }
    }

    // Display current account details
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Overdraft Limit   : Rs. " + overdraftLimit);
    }
}


// Main classlp
 cublicass BankAccountDemo {
    public static void main(String[] args) {

        // Creating SavingsAccount object
        SavingsAccount savings = new SavingsAccount(
                101,
                "Rahul",
                10000,
                5.0
        );

        // Creating CurrentAccount object
        CurrentAccount current = new CurrentAccount(
                102,
                "Arun",
                5000,
                3000
        );

        // Display initial details
        System.out.println("========== INITIAL ACCOUNT DETAILS ==========");

        System.out.println("\nSavings Account:");
        savings.displayAccountDetails();

        System.out.println("\nCurrent Account:");
        current.displayAccountDetails();


        // Deposit operation
        System.out.println("\n========== DEPOSIT ==========");

        savings.deposit(2000);
        current.deposit(3000);


        // Withdrawal operation
        System.out.println("\n========== WITHDRAWAL ==========");

        savings.withdraw(1500);

        // Current account can use overdraft
        current.withdraw(9000);


        // Interest calculation
        System.out.println("\n========== INTEREST CALCULATION ==========");

        savings.calculateInterest();


        // Fund transfer
        System.out.println("\n========== FUND TRANSFER ==========");

        savings.transfer(current, 2000);


        // Display final details
        System.out.println("\n========== FINAL ACCOUNT DETAILS ==========");

        System.out.println("\nSavings Account:");
        savings.displayAccountDetails();

        System.out.println("\nCurrent Account:");
        current.displayAccountDetails();


        // Final balances
        System.out.println("\n========== FINAL BALANCES ==========");

        System.out.println("Savings Account Balance : Rs. " + savings.balance);
        System.out.println("Current Account Balance : Rs. " + current.balance);
    }
}
