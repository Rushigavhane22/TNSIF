package yash;

public class Account {
    private int accountID, customerID;
    private String type;
    private double balance;

    public Account(int accountID, int customerID, String type, double balance) {
        this.accountID = accountID;
        this.customerID = customerID;
        this.type = type;
        this.balance = balance;
    }

    public int getAccountID() { return accountID; }
    public int getCustomerID() { return customerID; }
    public String getType() { return type; }
    public double getBalance() { return balance; }

    public void deposit(double amount) { balance += amount; }
    public boolean withdraw(double amount) { 
        if (balance >= amount) { 
            balance -= amount; 
            return true;
        } 
        return false;
    }

    @Override
    public String toString() {
        return "Account ID: " + accountID + ", Balance: " + balance;
    }
}
