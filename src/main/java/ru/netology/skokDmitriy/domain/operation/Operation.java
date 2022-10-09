package ru.netology.skokDmitriy.domain.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.netology.skokDmitriy.domain.ConsolePrintable;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return sum == operation.sum && customerId == operation.customerId && OperationCreditType == operation.OperationCreditType && currency == operation.currency && Objects.equals(merchant, operation.merchant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(OperationCreditType, sum, currency, merchant, customerId);
    }
}
