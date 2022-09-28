package ru.netology.skokDmitriy.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashbackTransaction extends Transaction implements ConsolePrintable{
    private int cashbackAmount;

    @Override
    public void printToConsole(){
        super.printToConsole();
        System.out.println("Cashback = " + cashbackAmount);
    }
}
