import java.util.Scanner;

// Step 4: Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        }
    }

    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Successfully deposited $" + amount + ". Current balance: $" + balance;
        } else {
            return "Deposit amount should be greater than zero.";
        }
    }

    public String withdraw(double amount) {
        if (amount <= 0) {
            return "Withdrawal amount should be greater than zero.";
        } else if (amount > balance) {
            return "Insufficient funds.";
        } else {
            balance -= amount;
            return "Successfully withdrew $" + amount + ". Current balance: $" + balance;
        }
    }

    public String checkBalance() {
        return "Current balance: $" + balance;
    }
}

// Step 1 & 2: Class to represent the ATM machine & Design the user interface
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount account) {
        this.bankAccount = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM!");
        
        boolean running = true;
        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println(bankAccount.withdraw(withdrawAmount));
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(bankAccount.deposit(depositAmount));
                    break;
                case 3:
                    System.out.println(bankAccount.checkBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
}

// Main class to run the ATM
public class task3 {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000); // Initial balance of 1000
        ATM atm = new ATM(myAccount);
        atm.start();
    }
}
