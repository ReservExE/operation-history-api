package ru.netology.skokDmitriy.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Transaction extends BaseOperation implements ConsolePrintable{
    private OperationCreditType OperationCreditType;
    private int transactionAmount;
    private Currency transactionCurrency;
    private String merchant;

    public Transaction(){

    }
    public Transaction(int id, OperationCreditType operationCreditType, int sum, Currency currency, String merchant, LocalDateTime time){
        super(id, time);
        this.OperationCreditType = operationCreditType;
        this.transactionAmount = sum;
        this.transactionCurrency = currency;
        this.merchant = merchant;

        System.out.println("Transaction created");
    }

    public String toString() {
        return "ID:" + super.getId() + " | Amount: " + this.transactionAmount + " | currency " +
                this.transactionCurrency + " | in " + merchant;
    }

    public void printToConsole(){
        System.out.println(this.toString());
    }
}
