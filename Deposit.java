import java.util.Scanner;

public class Deposit {
    public static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            ATM.setBalance(ATM.getBalance() + amount);
            ATM.getTransactionHistory().addTransaction("Deposit: " + amount);
            System.out.println("Deposit successful. Your new balance is: " + ATM.getBalance());
        } else {
            System.out.println("Invalid amount.");
        }
    }
}