package yash;

import java.util.*;

public class BankingServiceImpl implements BankingService {
    private Map<Integer, Customer> customers = new HashMap<>();
    private Map<Integer, Account> accounts = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerID(), customer);
    }

    @Override
    public void addAccount(Account account) {
        accounts.put(account.getAccountID(), account);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        Account acc = accounts.get(transaction.getAccountID());
        if (acc != null) {
            if ("Deposit".equalsIgnoreCase(transaction.getType())) 
                acc.deposit(transaction.getAmount());
            else if ("Withdraw".equalsIgnoreCase(transaction.getType())) 
                acc.withdraw(transaction.getAmount());
        }
    }

    @Override
    public Customer findCustomerById(int id) {
        return customers.get(id);
    }

    @Override
    public List<Account> getAccountsByCustomerId(int customerId) {
        List<Account> result = new ArrayList<>();
        for (Account acc : accounts.values()) {
            if (acc.getCustomerID() == customerId) result.add(acc);
        }
        return result;
    }

    @Override
    public List<Transaction> getTransactionsByAccountId(int accountId) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getAccountID() == accountId) result.add(t);
        }
        return result;
    }

    @Override
    public double checkBalance(int accountId) {
        Account acc = accounts.get(accountId);
        return (acc != null) ? acc.getBalance() : -1;
    }
}
