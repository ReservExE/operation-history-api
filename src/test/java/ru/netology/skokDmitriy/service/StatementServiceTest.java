package ru.netology.skokDmitriy.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.skokDmitriy.domain.Customer;
import ru.netology.skokDmitriy.domain.operation.Currency;
import ru.netology.skokDmitriy.domain.operation.Operation;
import ru.netology.skokDmitriy.domain.operation.OperationCreditType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//addOperation(new Operation(OperationCreditType.CREDIT, 100, Currency.RUB, "testShop", 1));
//addOperation(new Operation(OperationCreditType.CREDIT, 200, Currency.RUB, "testShop", 2));
//addOperation(new Operation(OperationCreditType.CREDIT, 300, Currency.RUB, "testShop", 2));
class StatementServiceTest {
    @Autowired
    StatementService statementService;

    @Test
    public void getStatementTest(){
        List<Operation> operations = statementService.getAllOperations();
        Operation operation1 = operations.get(1);
        Operation operation2 = operations.get(2);

        assertEquals(100, operation1.getSum());
        assertEquals("testShop", operation1.getMerchant());
    }

    @Test
    public void deleteStatementTest(){
        statementService.saveOperation(new Operation(OperationCreditType.CREDIT, 100, Currency.RUB, "testShop", 1));
        statementService.saveOperation(new Operation(OperationCreditType.CREDIT, 200, Currency.RUB, "testShop", 2));
        statementService.saveOperation(new Operation(OperationCreditType.CREDIT, 300, Currency.RUB, "testShop", 2));
        List<Operation> operations = statementService.getAllOperations();
        assertEquals(3, operations.size());

        Operation operation1 = operations.get(1);
        statementService.deleteOperation(operation1.hashCode());
        List<Operation> operations2 = statementService.getAllOperations();
        assertEquals(2, operations.size());
    }
}