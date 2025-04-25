package yash;

import java.util.List;

public interface BankingService {
    void addCustomer(Customer customer);
    void addAccount(Account account);
    void addTransaction(Transaction transaction);
    Customer findCustomerById(int id);
    List<Account> getAccountsByCustomerId(int customerId);
    List<Transaction> getTransactionsByAccountId(int accountId);
    double checkBalance(int accountId);
}
