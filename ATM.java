import java.util.Scanner;

public class ATM {
    private static double balance = 1000.0;
    private static TransactionHistory transactionHistory = new TransactionHistory();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. View Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    transactionHistory.viewTransactionHistory();
                    break;
                case 2:
                    Withdrawal.withdraw(scanner);
                    break;
                case 3:
                    Deposit.deposit(scanner);
                    break;
                case 4:
                    Transfer.transfer(scanner);
                    break;
                case 5:
                    Exit.exit();
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    public static double getBalance() {
        return balance;
    }

    public static void setBalance(double balance) {
        ATM.balance = balance;
    }

    public static TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }
}