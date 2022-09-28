package ru.netology.skokDmitriy.service;

import lombok.AllArgsConstructor;
import ru.netology.skokDmitriy.domain.operation.Currency;
import ru.netology.skokDmitriy.domain.operation.Operation;
import ru.netology.skokDmitriy.exception.CurrencyUnknownException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

import static ru.netology.skokDmitriy.domain.operation.OperationCreditType.CREDIT;

@AllArgsConstructor
public class OperationService {


    private StatementService statementService;
    private final StorageService storageService;
    private final IOService ioService;

    private static Currency parseCurrency(String currencyCode) {
        switch (currencyCode) {
            case "RUB":
                return Currency.RUB;
            case "USD":
                return Currency.USD;
            default:
                throw new CurrencyUnknownException();
        }
    }

    public void fillOperations() {
        for (int operationId = 0; operationId < storageService.getOperation().length; operationId++) {

            System.out.println("Customer ID: ");
            int customerId = Integer.parseInt(ioService.getNextInput());

            if (!statementService.customerCanStoreNextTransaction(customerId)) {
                System.out.println("No transaction can be written for Customer" + customerId);
                return;
            }

            System.out.println("Input amount: ");
            int sum = Integer.parseInt(ioService.getNextInput());

            System.out.println("Input currency: ");
            Currency currency = parseCurrency(ioService.getNextInput());

            System.out.println("Selling point: ");
            String merchant = ioService.getNextInput();

            Operation newOperation = new Operation(operationId, CREDIT, sum, currency, merchant, LocalDateTime.now());
            storageService.getOperation()[operationId] = newOperation;
            statementService.saveOperationToStatement(customerId, operationId);

            System.out.println("END? y/n");
            if (ioService.getNextInput().equals("y")) {
                break;
            }
        }
    }

    public String getOperations() {
        return Arrays.toString(storageService.getOperation());
    }
}