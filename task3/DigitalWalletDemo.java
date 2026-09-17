// Interface
interface PaymentService {
    void pay(String upiId, double amount)
            throws InvalidUPIException,
                   InvalidAmountException,
                   InsufficientBalanceException;

    void checkBalance();
}


// Custom Exception 1
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}


// Custom Exception 2
class InvalidUPIException extends Exception {
    public InvalidUPIException(String message) {
        super(message);
    }
}


// Custom Exception 3
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}


// Wallet Class
class Wallet {

    // Private data members - Encapsulation
    private String userName;
    private String mobileNumber;
    private String upiId;
    private double balance;

    // Constructor
    public Wallet(String userName, String mobileNumber,
                  String upiId, double balance) {
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.upiId = upiId;
        this.balance = balance;
    }

    // Add money
    public void addMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Money added successfully: Rs. " + amount);
        } else {
            System.out.println("Invalid amount. Money cannot be added.");
        }
    }

    // Get balance
    public double getBalance() {
        return balance;
    }

    // Get UPI ID
    public String getUpiId() {
        return upiId;
    }

    // Deduct amount
    public void deductAmount(double amount) {
        balance -= amount;
    }

    // Display wallet details
    public void displayWalletDetails() {
        System.out.println("\n========== WALLET DETAILS ==========");
        System.out.println("User Name    : " + userName);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("UPI ID       : " + upiId);
        System.out.println("Balance      : Rs. " + balance);
    }
}


// UPI Payment Class
class UPIPayment implements PaymentService {

    private Wallet wallet;

    // Constructor
    public UPIPayment(Wallet wallet) {
        this.wallet = wallet;
    }

    // Payment method
    @Override
    public void pay(String upiId, double amount)
            throws InvalidUPIException,
                   InvalidAmountException,
                   InsufficientBalanceException {

        // Validate UPI ID using String operations
        if (upiId == null ||
            !upiId.contains("@") ||
            upiId.startsWith("@") ||
            upiId.endsWith("@")) {

            throw new InvalidUPIException(
                    "Invalid UPI ID: " + upiId
            );
        }

        // Validate amount
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Invalid payment amount: Rs. " + amount
            );
        }

        // Check balance
        if (amount > wallet.getBalance()) {
            throw new InsufficientBalanceException(
                    "Insufficient balance. Available balance: Rs. "
                    + wallet.getBalance()
            );
        }

        // Deduct amount
        wallet.deductAmount(amount);

        System.out.println("\n========== PAYMENT SUCCESSFUL ==========");
        System.out.println("Receiver UPI ID: " + upiId);
        System.out.println("Amount Paid    : Rs. " + amount);
        System.out.println("Remaining Balance: Rs. "
                           + wallet.getBalance());
    }

    // Check balance
    @Override
    public void checkBalance() {
        System.out.println(
                "Available Wallet Balance: Rs. "
                + wallet.getBalance()
        );
    }
}


// Main Class
public class DigitalWalletDemo {

    public static void main(String[] args) {

        // Create Wallet object
        Wallet wallet = new Wallet(
                "Rahul",
                "9876543210",
                "rahul@upi",
                5000
        );

        // Display initial wallet details
        wallet.displayWalletDetails();

        // Add money
        System.out.println("\n========== ADD MONEY ==========");
        wallet.addMoney(2000);

        // Create UPIPayment object
        UPIPayment payment = new UPIPayment(wallet);

        // Check balance
        System.out.println("\n========== BALANCE CHECK ==========");
        payment.checkBalance();

        // Payment transaction
        System.out.println("\n========== UPI PAYMENT ==========");

        try {
            payment.pay("friend@upi", 1500);
        }
        catch (InvalidUPIException e) {
            System.out.println("Transaction Failed: "
                               + e.getMessage());
        }
        catch (InvalidAmountException e) {
            System.out.println("Transaction Failed: "
                               + e.getMessage());
        }
        catch (InsufficientBalanceException e) {
            System.out.println("Transaction Failed: "
                               + e.getMessage());
        }
        finally {
            System.out.println("\nTransaction processing completed.");
        }

        // Display final details
        wallet.displayWalletDetails();

        // Final balance
        System.out.println("\nFinal Wallet Balance: Rs. "
                           + wallet.getBalance());
    }
}
