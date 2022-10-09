package ru.netology.skokDmitriy.controller;

//https://netology.com/api/operations/

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.netology.skokDmitriy.controller.dto.CustomerDTO;
import ru.netology.skokDmitriy.controller.dto.GetOperationResponse;
import ru.netology.skokDmitriy.controller.dto.OperationDTO;
import ru.netology.skokDmitriy.domain.Customer;
import ru.netology.skokDmitriy.domain.operation.Operation;
import ru.netology.skokDmitriy.service.AsyncInputOperationService;
import ru.netology.skokDmitriy.service.StatementService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/operations")
@RequiredArgsConstructor
public class OperationsController {
    private final AsyncInputOperationService asyncInputOperationService;
    private final StatementService statementService;

    @GetMapping
    public GetOperationResponse GetOperationResponse() {
        List<Operation> operations = statementService.getAllOperations();
        List<OperationDTO> operationDTOS = new ArrayList<>();

        for (Operation operation : operations) {
            OperationDTO operationDTO = new OperationDTO(operation.hashCode(), LocalDateTime.now(), operation.getOperationCreditType(), operation.getSum(), operation.getCurrency(), operation.getMerchant(), operation.getCustomerId());
            operationDTOS.add(operationDTO);
        }
        return new GetOperationResponse(operationDTOS);
    }
    //DRY???
    @GetMapping("/{customerID}")
    public GetOperationResponse getCustomerOperations(@PathVariable int customerID) {
        List<Operation> operations = statementService.getCustomerOperations(customerID);
        List<OperationDTO> operationDTOS = new ArrayList<>();

        for (Operation operation : operations) {
            OperationDTO operationDTO = new OperationDTO(operation.hashCode(), LocalDateTime.now(), operation.getOperationCreditType(), operation.getSum(), operation.getCurrency(), operation.getMerchant(), operation.getCustomerId());
            operationDTOS.add(operationDTO);
        }
        return new GetOperationResponse(operationDTOS);
    }

    @PostMapping(
            value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void postOperation(@RequestBody @NotNull Operation operation){
        System.out.println(operation);
        Operation newOperation = new Operation(operation.getOperationCreditType(), operation.getSum(), operation.getCurrency(), operation.getMerchant(), operation.getCustomerId());
        asyncInputOperationService.addOperation(newOperation);
        return;
    }

    @DeleteMapping("/delete/{OperationID}")
    public void deleteOperationById(@PathVariable int OperationID){
        statementService.deleteOperation(OperationID);
    }
}
