package ru.netology.skokDmitriy;
import ru.netology.skokDmitriy.service.*;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        IOService ioService = new IOService();
        StorageService storageService = new StorageService();
        StatementService statementService = new StatementService(storageService);
        CustomerService customerService = new CustomerService(storageService, ioService);
        OperationService operationService = new OperationService(statementService, storageService, ioService);

        customerService.fillCustomers();
        operationService.fillOperations();

        System.out.println(operationService.getOperations());
    }






}


