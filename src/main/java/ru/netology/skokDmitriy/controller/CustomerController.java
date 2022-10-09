package ru.netology.skokDmitriy.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.skokDmitriy.controller.dto.CustomerDTO;
import ru.netology.skokDmitriy.controller.dto.GetClientsResponse;
import ru.netology.skokDmitriy.domain.Customer;
import ru.netology.skokDmitriy.service.AsyncInputOperationService;
import ru.netology.skokDmitriy.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

//https://netology.com/api/customers/
@RestController
@RequestMapping(path = "/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public GetClientsResponse getClients(){
        List<Customer> customers = customerService.getCustomers();

//       List<CustomerDTO> customerDTOS = customers.stream()
//               .map(customer -> new CustomerDTO(customer.getId(), customer.getName()))
//               .collect(toList());

        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for(Customer customer: customers){
            CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName());
            customerDTOS.add(customerDTO);
        }
        return new GetClientsResponse(customerDTOS);
    }

    @GetMapping("/{customerID}")
    public CustomerDTO getCustomer(@PathVariable int customerID){
        return customerService.getCustomers().stream()
                .filter(customer -> customer.getId() == customerID)
                .map(customer -> new CustomerDTO(customer.getId(), customer.getName()))
                .findFirst().orElse(null);
    }

    @PostMapping(
            value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void postCustomer(@RequestBody @NotNull Customer customer){
        customerService.addCustomer(customer.getId(), customer.getName());
        return;
    }
}
