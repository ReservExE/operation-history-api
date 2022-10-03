package ru.netology.skokDmitriy.domain.operation;

import lombok.Getter;
import lombok.Setter;
import ru.netology.skokDmitriy.domain.ConsolePrintable;

import java.time.LocalDateTime;

@Getter
@Setter
public class Operation extends BaseOperation implements ConsolePrintable {
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
    public Operation(int id, OperationCreditType operationCreditType, int sum, Currency currency, String merchant, LocalDateTime time){
        super(id, time);
        this.OperationCreditType = operationCreditType;
        this.sum = sum;
        this.currency = currency;
        this.merchant = merchant;

        System.out.println("Operation created");
    }

    public String toString() {
        return "ID:" + super.getId() + " | Amount: " + this.sum + " | currency " +
                this.currency + " | in " + merchant;
    }

    public void printToConsole(){
        System.out.println(this.toString());
    }
}
