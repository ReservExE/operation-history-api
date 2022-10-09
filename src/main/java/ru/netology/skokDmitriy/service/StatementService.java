package ru.netology.skokDmitriy.service;

import lombok.AllArgsConstructor;
import ru.netology.skokDmitriy.domain.operation.Operation;

import java.util.*;

@AllArgsConstructor
public class StatementService {
    private final Map<Integer, List<Operation>> storage = new HashMap<>();

    public void saveOperation(Operation operation) {
        List<Operation> operations = storage.get(operation.getCustomerId());
        if (operations == null){
            List<Operation> customerOperations = new ArrayList<>();
            customerOperations.add(operation);
            storage.put(operation.getCustomerId(), customerOperations);
        } else {
            operations.add(operation);
        }
    }

    public String getOperations(){
        return storage.toString();
    }
}
