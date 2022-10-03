package ru.netology.skokDmitriy;
import ru.netology.skokDmitriy.domain.Customer;
import ru.netology.skokDmitriy.domain.operation.Operation;
import ru.netology.skokDmitriy.service.*;

import java.util.Scanner;

import static ru.netology.skokDmitriy.utils.Constants.MAX_CUSTOMERS;
import static ru.netology.skokDmitriy.utils.Constants.OPERATIONS_PER_USER;


public class Main {

    public static void main(String[] args) {


        IOService ioService = new IOService();

        StorageService<Customer> customerStorageService = new StorageService<>();
        StorageService<Operation> operationStorageService = new StorageService<>();

        StatementService statementService = new StatementService();
        CustomerService customerService = new CustomerService(customerStorageService, ioService);
        OperationService operationService = new OperationService(statementService, operationStorageService, ioService);

        customerService.fillCustomers();
        operationService.fillOperations();

        System.out.println(operationService.getOperations());
    }
}


