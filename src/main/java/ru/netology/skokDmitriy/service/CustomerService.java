package ru.netology.skokDmitriy.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.skokDmitriy.domain.Customer;

import javax.annotation.PostConstruct;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@AllArgsConstructor
public class CustomerService {
    private final List<Customer> storage = new ArrayList<>();

    public void addCustomer(int id, String name){
        Customer customer = new Customer(id, name);
        storage.add(customer);
    }
    public List<Customer> getCustomers() {
        return storage;
    }
    @PostConstruct
    public void init(){
        storage.add(new Customer(1, "Spring"));
        storage.add(new Customer(2, "Boot"));
    }
}
