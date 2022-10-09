package ru.netology.skokDmitriy;
import ru.netology.skokDmitriy.domain.Customer;
import ru.netology.skokDmitriy.domain.operation.Currency;
import ru.netology.skokDmitriy.domain.operation.Operation;
import ru.netology.skokDmitriy.domain.operation.OperationCreditType;
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

        AsyncOperationService asyncOperationService = new AsyncOperationService(operationService);
        asyncOperationService.startProcessing();

        Operation o1 = new Operation(OperationCreditType.CREDIT, 100, Currency.RUB, "shoko", 0);
        asyncOperationService.addOperation(o1);
        Operation o2 = new Operation(OperationCreditType.CREDIT, 200, Currency.RUB, "shoko", 0);
        asyncOperationService.addOperation(o2);

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Operation o3 = new Operation(OperationCreditType.CREDIT, 300, Currency.RUB, "shoko", 0);
        asyncOperationService.addOperation(o3);
        Operation o4 = new Operation(OperationCreditType.CREDIT, 400, Currency.RUB, "shoko", 0);
        asyncOperationService.addOperation(o4);


        //customerService.fillCustomers();
        //operationService.fillOperations();

        System.out.println(operationService.getOperations());
    }
}


