import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleBankingApp {
    private static Map<String, Double> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the banking app...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
        } else {
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            accounts.put(accountNumber, initialBalance);
            System.out.println("Account created successfully!");
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.print("Enter deposit amount: ");
            double depositAmount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character

            double currentBalance = accounts.get(accountNumber);
            double newBalance = currentBalance + depositAmount;
            accounts.put(accountNumber, newBalance);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Account does not exist!");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character

            double currentBalance = accounts.get(accountNumber);

            if (withdrawalAmount <= currentBalance) {
                double newBalance = currentBalance - withdrawalAmount;
                accounts.put(accountNumber, newBalance);
                System.out.println("Withdrawal successful!");
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("Account does not exist!");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            System.out.println("Account balance: " + balance);
        } else {
            System.out.println("Account does not exist!");
        }
    }
}
