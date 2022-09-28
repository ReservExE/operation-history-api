package ru.netology.skokDmitriy.domain.operation;

import lombok.Getter;
import lombok.Setter;
import ru.netology.skokDmitriy.domain.ConsolePrintable;

@Getter
@Setter
public class CashbackOperation extends Operation implements ConsolePrintable {
    private int cashbackAmount;

    @Override
    public void printToConsole(){
        super.printToConsole();
        System.out.println("Cashback = " + cashbackAmount);
    }
}
