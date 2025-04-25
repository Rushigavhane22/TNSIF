package yash;

import java.util.Scanner;


public class BankingSystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingService service = new BankingServiceImpl();
        int choice;

        do {
            System.out.println("\nBanking System");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Account");
            System.out.println("3. Add Transaction");
            System.out.println("4. Find Customer by ID");
            System.out.println("5. List Accounts of Customer");
            System.out.println("6. List Transactions of Account");
            System.out.println("7. Check Account Balance");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int cid = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();
                    service.addCustomer(new Customer(cid, name, address, contact));
                    break;

                case 2:
                    System.out.print("Enter Account ID: ");
                    int aid = scanner.nextInt();
                    System.out.print("Enter Customer ID: ");
                    int custId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Account Type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    service.addAccount(new Account(aid, custId, type, balance));
                    break;

                case 3:
                    System.out.print("Enter Transaction ID: ");
                    int tid = scanner.nextInt();
                    System.out.print("Enter Account ID: ");
                    int accId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Type (Deposit/Withdraw): ");
                    String ttype = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    service.addTransaction(new Transaction(tid, accId, ttype, amount));
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    System.out.println(service.findCustomerById(scanner.nextInt()));
                    break;

                case 5:
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    for (Account acc : service.getAccountsByCustomerId(customerId))
                        System.out.println(acc);
                    break;

                case 6:
                    System.out.print("Enter Account ID: ");
                    int accountId = scanner.nextInt();
                    for (Transaction t : service.getTransactionsByAccountId(accountId))
                        System.out.println(t);
                    break;

                case 7:
                    System.out.print("Enter Account ID: ");
                    int checkAccId = scanner.nextInt();
                    double accBalance = service.checkBalance(checkAccId);
                    if (accBalance != -1) {
                        System.out.println("Account Balance: " + accBalance);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 8:
                    System.out.println("Thank you!");
                    break;
            }
        } while (choice != 8);
    }
}
