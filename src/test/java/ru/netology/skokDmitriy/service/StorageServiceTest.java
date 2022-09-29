package ru.netology.skokDmitriy.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.skokDmitriy.domain.operation.Currency;
import ru.netology.skokDmitriy.domain.operation.Operation;
import ru.netology.skokDmitriy.domain.operation.OperationCreditType;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StorageServiceTest {
    @Test
    public void getElementTest(){
        StorageService<Operation> operationStorageService = new StorageService<Operation>();
        Operation operation = new Operation(0, OperationCreditType.CREDIT, 100, Currency.RUB, "shoko", LocalDateTime.now());
        operationStorageService.setElement(operation);

        Operation storageOperation = operationStorageService.getElement(0);

        Assertions.assertEquals("shoko", storageOperation.getMerchant());
    }
}