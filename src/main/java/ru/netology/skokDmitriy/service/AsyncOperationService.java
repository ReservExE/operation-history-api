package ru.netology.skokDmitriy.service;

import ru.netology.skokDmitriy.domain.operation.Operation;

import java.util.LinkedList;
import java.util.Queue;

public class AsyncOperationService {
    private final Queue<Operation> operations = new LinkedList<>();

    private final OperationService operationService;

    public boolean addOperation(Operation operation, int customerId) {
        return operations.offer(operation, );
    }

    public void startProcessing() {
        Thread t = new Thread() {
            @Override
            public void run() {
                processQueue();

            }
        };
    }

    private void processQueue() {
        while (true) {
            Operation operation = operations.poll();
            if (operation == null) {
                try {
                    System.out.println("No operations");
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                //TODO wait
            } else {
                System.out.println("Processing operation " + operation);
                processOperation(operation);
            }
        }
    }

    private void processOperation(Operation operation, int customerId) {
        operationService.processOperation(operation, customerId);
    }
}
