package ru.netology.skokDmitriy.service;

import lombok.AllArgsConstructor;
import ru.netology.skokDmitriy.domain.Customer;

import java.util.Scanner;

@AllArgsConstructor
public class CustomerService {

    private final StorageService<Customer> customerStorageService;
    private final IOService ioService;
    public void fillCustomers() {
        for (int i = 0; i < customerStorageService.getLength(); i++) {
            System.out.println("Enter user name: " + i);
            String name = ioService.getNextInput();

            Customer newCustomer = new Customer(i, name);

            customerStorageService.setElement(newCustomer);

            System.out.println("END? y/n");
            if (ioService.getNextInput().equals("y")) {
                break;
            }
        }
    }
}
