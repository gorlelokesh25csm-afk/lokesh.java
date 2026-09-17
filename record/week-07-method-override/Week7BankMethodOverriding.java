import java.util.Scanner;

class RBI {
    double getInterestRate() { return 4.0; }
}

class SBI extends RBI {
    @Override double getInterestRate() { return 7.0; }
}

class ICICI extends RBI {
    @Override double getInterestRate() { return 6.5; }
}

class PNB extends RBI {
    @Override double getInterestRate() { return 6.0; }
}

public class Week7BankMethodOverriding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter bank name (RBI/SBI/ICICI/PNB): ");
        String bankName = scanner.nextLine().trim().toUpperCase();
        RBI bank;
        switch (bankName) {
            case "SBI": bank = new SBI(); break;
            case "ICICI": bank = new ICICI(); break;
            case "PNB": bank = new PNB(); break;
            default: bank = new RBI(); bankName = "RBI";
        }
        System.out.printf("%s rate of interest is: %.1f%%%n", bankName, bank.getInterestRate());
        scanner.close();
    }
}
