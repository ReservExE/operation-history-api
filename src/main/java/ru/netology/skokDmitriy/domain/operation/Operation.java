package ru.netology.skokDmitriy.domain.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.netology.skokDmitriy.domain.ConsolePrintable;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Operation extends BaseOperation {
    private ru.netology.skokDmitriy.domain.operation.OperationCreditType OperationCreditType;
    private int sum;
    private Currency currency;
    private String merchant;
    private int customerId;

    public Operation(){

    }

    public Operation(int sum, Currency currency, String merchant){
        this.sum = sum;
        this.currency = currency;
        this.merchant = merchant;

        System.out.println("Operation created");
    }

    public void printToConsole(){
        System.out.println(this.toString());
    }
}
