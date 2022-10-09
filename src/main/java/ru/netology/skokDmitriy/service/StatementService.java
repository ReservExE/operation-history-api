package ru.netology.skokDmitriy.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.skokDmitriy.domain.operation.Currency;
import ru.netology.skokDmitriy.domain.operation.Operation;
import ru.netology.skokDmitriy.domain.operation.OperationCreditType;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;
@Component
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

    public void deleteOperation(int operationID){
        for(List<Operation> list: storage.values()){
            for(Operation operationIter: list){
                if(operationIter.getId() == operationID){
                    list.remove(operationIter);
                    break;
                }
            }
        }
    }

    public List<Operation> getCustomerOperations(int customerID){
        List<Operation> operations = storage.get(customerID);
        return operations;
    }

    //выглядит тупо, десериализовать нормально
    //это точно надо сюда пихать?
    public List<Operation> getAllOperations(){
        List<Operation> operations = new ArrayList<>();
        for(int key: storage.keySet()){
            for(Operation operation: storage.get(key)){
                operations.add(operation);
            }
        }
        return operations;
    }

}
