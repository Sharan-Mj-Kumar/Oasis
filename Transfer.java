import java.util.Scanner;

public class Transfer {
    public static void transfer(Scanner scanner) {
        System.out.print("Enter account number to transfer to: ");
        String accountNumber = scanner.next();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= ATM.getBalance()) {
            ATM.setBalance(ATM.getBalance() - amount);
            ATM.getTransactionHistory().addTransaction("Transfer to " + accountNumber + ": " + amount);
            System.out.println("Transfer successful. Your new balance is: " + ATM.getBalance());
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }
}