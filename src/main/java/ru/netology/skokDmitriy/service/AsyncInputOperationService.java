package ru.netology.skokDmitriy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.netology.skokDmitriy.configuration.OperationProcessingProperties;
import ru.netology.skokDmitriy.domain.operation.Currency;
import ru.netology.skokDmitriy.domain.operation.Operation;
import ru.netology.skokDmitriy.domain.operation.OperationCreditType;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Queue;
@Component
@RequiredArgsConstructor
public class AsyncInputOperationService {
    private final Queue<Operation> operations = new LinkedList<>();
    private final StatementService statementService;
    private final OperationProcessingProperties properties;

    public boolean addOperation(Operation operation) {
        System.out.println("Operation added for processing " + operation);
        return operations.offer(operation);
    }

    public void startProcessing() {
        Thread t = new Thread() {
            @Override
            public void run() {
                processQueue();

            }
        };
        t.start();
    }

    private void processQueue() {
        while (true) {
            Operation operation = operations.poll();
            if (operation == null) {
                try {
                    System.out.println("No operations");
                    Thread.sleep(properties.getSleepMilliSeconds());
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("Processing operation " + operation);
                processOperation(operation);
            }
        }
    }

    private void processOperation(Operation operation) {
        statementService.saveOperation(operation);
    }
    @PostConstruct
    public void init(){

        this.startProcessing();
        addOperation(new Operation(OperationCreditType.CREDIT, 100, Currency.RUB, "testShop", 1));
        addOperation(new Operation(OperationCreditType.CREDIT, 200, Currency.RUB, "testShop", 2));
        addOperation(new Operation(OperationCreditType.CREDIT, 300, Currency.RUB, "testShop", 2));
    }
}
