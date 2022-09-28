package ru.netology.skokDmitriy.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanTransaction extends Transaction{
    private int loadId;

    @Override
    public void printToConsole(){
        super.printToConsole();
        System.out.println("LoadId = " + loadId);
    }
}
