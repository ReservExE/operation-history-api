package ru.netology.skokDmitriy;
import ru.netology.skokDmitriy.domain.*;
import ru.netology.skokDmitriy.exception.CurrencyUnknownException;

import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDateTime;

import static ru.netology.skokDmitriy.domain.OperationCreditType.*;


public class Main {
    //public static final int MAX_OPERATIONS = 1_000;
    public static final int MAX_CUSTOMERS = 100;
    public static final int  OPERATIONS_PER_USER = 100;
    public static final Transaction[] transactions = new Transaction[OPERATIONS_PER_USER*MAX_CUSTOMERS];
    public static final Customer[] customers = new Customer[MAX_CUSTOMERS];
    public static final int[][] statement = new int[MAX_CUSTOMERS][OPERATIONS_PER_USER];
    public static final int[] customerNextTransactionIdArray = new int[MAX_CUSTOMERS];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Transaction[] transactions1 = new Transaction[10];
        //Transaction transaction = new Transaction();

        //CashbackTransaction cashbackTransaction = new CashbackTransaction();
        //cashbackTransaction.setCashbackAmount(100);

        //LoanTransaction loanTransaction = new LoanTransaction();
        //loanTransaction.setLoadId(1);

        fillCustomers(customers, scanner);
        fillTransactions(transactions, scanner);
        System.out.println(Arrays.toString(transactions));
    }

    public static Currency parseCurrency(String currencyCode) {
        switch (currencyCode) {
            case "RUB":
                return Currency.RUB;
            case "USD":
                return Currency.USD;
            default:
                throw new CurrencyUnknownException();
        }
    }

    private static void fillCustomers(Customer[] customers, Scanner scanner) {
        for (int i = 0; i < transactions.length; i++) {
            System.out.println("Enter user name: " + i);
            String name = scanner.nextLine();

            Customer newCustomer = new Customer(i, name);
            customers[i] = newCustomer;

            System.out.println("END? y/n");
            if (scanner.nextLine().equals("y")) {
                break;
            }
        }
    }
    private static int findCustomerNextTransaction(int CustomerId){
        return customerNextTransactionIdArray[CustomerId];
    }

    private static boolean customerCanStoreNextTransaction(int CustomerId) {
        return customerNextTransactionIdArray[CustomerId] != OPERATIONS_PER_USER;
    }
    private static void fillTransactions(Transaction[] transactions, Scanner scanner) {
        for (int transactionId = 0; transactionId < transactions.length; transactionId++) {

            System.out.println("Customer ID: ");
            int CustomerId = Integer.parseInt(scanner.nextLine());

            if (!customerCanStoreNextTransaction(CustomerId)){
                System.out.println("No transaction can be written for Customer" + CustomerId);
                return;
            }

            System.out.println("Input amount: ");
            int sum = Integer.parseInt(scanner.nextLine());

            System.out.println("Input currency: ");
            Currency currency = parseCurrency(scanner.nextLine());

            System.out.println("Selling point: ");
            String merchant = scanner.nextLine();

            Transaction newTransaction = new Transaction(transactionId, CREDIT, sum, currency, merchant, LocalDateTime.now());
            transactions[transactionId] = newTransaction;

            int customerNextTransactionId = findCustomerNextTransaction(CustomerId);
            statement[CustomerId][customerNextTransactionId] = transactionId;
            customerNextTransactionIdArray[CustomerId] = customerNextTransactionIdArray[CustomerId] + 1;

            System.out.println("END? y/n");
            if (scanner.nextLine().equals("y")) {
                break;
            }
        }
    }
}


