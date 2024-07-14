import java.util.Scanner;

public class Withdrawal {
    public static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= ATM.getBalance()) {
            ATM.setBalance(ATM.getBalance() - amount);
            ATM.getTransactionHistory().addTransaction("Withdrawal: " + amount);
            System.out.println("Withdrawal successful. Your new balance is: " + ATM.getBalance());
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }
}