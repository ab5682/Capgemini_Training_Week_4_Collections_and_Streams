import java.util.*;

class BankingSystem {
    private Map<String, Double> customerAccounts;
    private TreeMap<Double, String> sortedAccountsByBalance;
    private Queue<String> withdrawalQueue;

    public BankingSystem() {
        this.customerAccounts = new HashMap<>();
        this.sortedAccountsByBalance = new TreeMap<>();
        this.withdrawalQueue = new LinkedList<>();
    }

    public void createAccount(String accountNumber, double initialBalance) {
        customerAccounts.put(accountNumber, initialBalance);
        sortedAccountsByBalance.put(initialBalance, accountNumber);
    }

    public void deposit(String accountNumber, double amount) {
        if (customerAccounts.containsKey(accountNumber)) {
            double newBalance = customerAccounts.get(accountNumber) + amount;
            customerAccounts.put(accountNumber, newBalance);
            sortedAccountsByBalance.put(newBalance, accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (customerAccounts.containsKey(accountNumber)) {
            double currentBalance = customerAccounts.get(accountNumber);
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                customerAccounts.put(accountNumber, newBalance);
                withdrawalQueue.add(accountNumber);  
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            double currentBalance = customerAccounts.get(accountNumber);
            System.out.println("Withdrawal processed for account " + accountNumber + ". New balance: " + currentBalance);
        }
    }

    public void displaySortedAccountsByBalance() {
        System.out.println("\nAccounts sorted by balance:");
        for (Map.Entry<Double, String> entry : sortedAccountsByBalance.entrySet()) {
            System.out.println("Account: " + entry.getValue() + ", Balance: " + entry.getKey());
        }
    }

    public double getAccountBalance(String accountNumber) {
        return customerAccounts.getOrDefault(accountNumber, 0.0);
    }

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();

        bankingSystem.createAccount("A123", 500.00);
        bankingSystem.createAccount("B456", 1000.00);
        bankingSystem.createAccount("C789", 300.00);

        bankingSystem.deposit("A123", 200.00);
        bankingSystem.withdraw("B456", 150.00);
        bankingSystem.withdraw("C789", 50.00);

        bankingSystem.displaySortedAccountsByBalance();
        bankingSystem.processWithdrawals();

        System.out.println("\nBalance for A123: " + bankingSystem.getAccountBalance("A123"));
    }
}
