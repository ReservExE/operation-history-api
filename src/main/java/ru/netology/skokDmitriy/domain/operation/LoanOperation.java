package ru.netology.skokDmitriy.domain.operation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanOperation extends Operation {
    private int loadId;

    @Override
    public void printToConsole(){
        super.printToConsole();
        System.out.println("LoadId = " + loadId);
    }
}
