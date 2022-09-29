package ru.netology.skokDmitriy.service;

import lombok.AllArgsConstructor;

import static ru.netology.skokDmitriy.utils.Constants.MAX_CUSTOMERS;
import static ru.netology.skokDmitriy.utils.Constants.OPERATIONS_PER_USER;

@AllArgsConstructor
public class StatementService {


    public static final int[] customerNextTransactionIdArray = new int[MAX_CUSTOMERS];

    public static int findCustomerNextTransaction(int CustomerId) {
        return customerNextTransactionIdArray[CustomerId];
    }

    public void saveOperationToStatement(int customerId, int operationId) {
        int customerNextTransactionId = findCustomerNextTransaction(customerId);
        StatementStorageService.getStatement()[customerId][customerNextTransactionId] = operationId;
        customerNextTransactionIdArray[customerId] = customerNextTransactionIdArray[customerId] + 1;
    }

    public static boolean customerCanStoreNextTransaction(int CustomerId) {
        return customerNextTransactionIdArray[CustomerId] != OPERATIONS_PER_USER;
    }
}
