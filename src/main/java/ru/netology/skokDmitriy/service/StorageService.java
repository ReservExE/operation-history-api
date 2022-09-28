package ru.netology.skokDmitriy.service;

import ru.netology.skokDmitriy.domain.Customer;
import ru.netology.skokDmitriy.domain.operation.Operation;

public class StorageService {

    public static final int MAX_CUSTOMERS = 100;
    public static final int OPERATIONS_PER_USER = 100;

    private final Customer[] customers = new Customer[MAX_CUSTOMERS];
    private  final Operation[] operations = new Operation[OPERATIONS_PER_USER * MAX_CUSTOMERS];
    public  final int[][] statement = new int[MAX_CUSTOMERS][OPERATIONS_PER_USER];

    public Customer[] getCustomers(){
        return customers;
    }
    public Operation[] getOperation(){
        return operations;
    }
    public int[][] getStatement(){
        return statement;
    }
}
