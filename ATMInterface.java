import java.util.ArrayList;
import java.util.Scanner;

class ATM {
    private double balance;
    private ArrayList<String> transactionHistory;
    private final int userId = 12345;
    private final int userPin = 6789;
    
    public ATM() {
        this.balance = 1000.00; // Default balance
        this.transactionHistory = new ArrayList<>();
    }
    
    public boolean authenticate(int id, int pin) {
        return (id == userId && pin == userPin);
    }
    
    public void transactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
    
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrawn: $" + amount);
            System.out.println("Withdrawal successful. Current balance: $" + balance);
        }
    }
    
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
        System.out.println("Deposit successful. Current balance: $" + balance);
    }
    
    public void transfer(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            transactionHistory.add("Transferred: $" + amount);
            System.out.println("Transfer successful. Current balance: $" + balance);
        }
    }
    
    public double getBalance() {
        return balance;
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();
        
        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        
        if (!atm.authenticate(id, pin)) {
            System.out.println("Invalid credentials. Exiting...");
            return;
        }
        
        while (true) {
            System.out.println("\nATM INTERFACE");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    atm.transactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    atm.transfer(transferAmount);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
