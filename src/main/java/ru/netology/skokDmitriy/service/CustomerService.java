package ru.netology.skokDmitriy.service;

import lombok.AllArgsConstructor;
import ru.netology.skokDmitriy.domain.Customer;

import java.util.Scanner;

import static ru.netology.skokDmitriy.service.StorageService.MAX_CUSTOMERS;
@AllArgsConstructor
public class CustomerService {

    private final StorageService storageService;
    private final IOService ioService;
    public void fillCustomers() {
        for (int i = 0; i < storageService.getCustomers().length; i++) {
            System.out.println("Enter user name: " + i);
            String name = ioService.getNextInput();

            Customer newCustomer = new Customer(i, name);
            storageService.getCustomers()[i] = newCustomer;

            System.out.println("END? y/n");
            if (ioService.getNextInput().equals("y")) {
                break;
            }
        }
    }
}
