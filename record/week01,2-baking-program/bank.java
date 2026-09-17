import java.util.Scanner;
class Account {
    int accNo;
    String name;
    double bal;
    String accType;
    public Account(int accNo, String name, double bal, String accType) {
        this.accNo = accNo;
        this.name = name;
        this.bal = bal;
        this.accType = accType;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            bal += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount <= bal) {
            bal -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
    public void transfer(Account rec, double amount) {
        if (amount <= bal) {
            bal -= amount;
            rec.bal += amount;
            System.out.println("₹" + amount + " transferred to " + rec.name);
        } else {
            System.out.println("Transfer Failed! Insufficient Balance.");
        }
    }
    public void calInterest() {
        System.out.println("Interest calculation not applicable.");
    }
    public void displayAccount() {
        System.out.println("\n----------------------------");
        System.out.println("Account Number : " + accNo);
        System.out.println("Account Holder : " + name);
        System.out.println("Account Type   : " + accType);
        System.out.println("Balance        : ₹" + bal);
    }
}
class SavingsAcc extends Account {
    double interestRate;
    public SavingsAcc(int accNo, String name, double bal, double interestRate) {
        super(accNo, name, bal, "Savings");
        this.interestRate = interestRate;
    }
    @Override
    public void calInterest() {
        double interest = bal * interestRate / 100;
        System.out.println("Interest Earned : ₹" + interest);
    }
}
class CurrentAcc extends Account {
    double overdraftLimit;
    public CurrentAcc(int accNo, String name, double bal, double overdraftLimit) {
        super(accNo, name, bal, "Current");
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public void withdraw(double amount) {
        if (bal + overdraftLimit >= amount) {
            bal -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Overdraft Limit Exceeded!");
        }
    }
    public void showOverdraftLimit() {
        System.out.println("Overdraft Limit : ₹" + overdraftLimit);
    }
}
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingsAcc customer1 = new SavingsAcc(1001, "Bunny", 10000, 5);
        CurrentAcc customer2 = new CurrentAcc(2001, "Arya", 5000, 3000);
        int choice;
        do {
            System.out.println("\n========= BANK MENU =========");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Calculate Interest");
            System.out.println("5. Display Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Select Account:");
                    System.out.println("1. Bunny (Savings)");
                    System.out.println("2. Arya (Current)");
                    int dAcc = sc.nextInt();
                    System.out.print("Enter amount: ");
                    double dAmt = sc.nextDouble();
                    if (dAcc == 1)
                        customer1.deposit(dAmt);
                    else if (dAcc == 2)
                        customer2.deposit(dAmt);
                    else
                        System.out.println("Invalid Account!");
                    break;
                case 2:
                    System.out.println("Select Account:");
                    System.out.println("1. Bunny (Savings)");
                    System.out.println("2. Arya (Current)");
                    int wAcc = sc.nextInt();
                    System.out.print("Enter amount: ");
                    double wAmt = sc.nextDouble();
                    if (wAcc == 1)
                        customer1.withdraw(wAmt);
                    else if (wAcc == 2)
                        customer2.withdraw(wAmt);
                    else
                        System.out.println("Invalid Account!");
                    break;
                case 3:
                    System.out.println("Transfer:");
                    System.out.println("1. Bunny -> Arya");
                    System.out.println("2. Arya -> Bunny");
                    int t = sc.nextInt();
                    System.out.print("Enter amount: ");
                    double tAmt = sc.nextDouble();
                    if (t == 1)
                        customer1.transfer(customer2, tAmt);
                    else if (t == 2)
                        customer2.transfer(customer1, tAmt);
                    else
                        System.out.println("Invalid Choice!");
                    break;
                case 4:
                    System.out.println("1. Bunny (Savings)");
                    System.out.println("2. Arya (Current)");
                    int i = sc.nextInt();
                    if (i == 1)
                        customer1.calInterest();
                    else if (i == 2)
                        customer2.calInterest();
                    else
                        System.out.println("Invalid Choice!");
                    break;
                case 5:
                    customer1.displayAccount();
                    customer2.displayAccount();
                    customer2.showOverdraftLimit();
                    break;
                case 6:
                    System.out.println("Thank you for using Bank Management System.");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 6);
    }
}
