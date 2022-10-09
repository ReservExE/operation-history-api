package ru.netology.skokDmitriy.service;

import lombok.AllArgsConstructor;
import ru.netology.skokDmitriy.domain.Customer;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class CustomerService {
    private final List<Customer> storage = new ArrayList<>();

    public void addCustomer(int id, String name){
        Customer customer = new Customer(id, name);
        storage.add(customer);
    }
}
