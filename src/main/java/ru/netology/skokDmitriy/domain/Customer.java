package ru.netology.skokDmitriy.domain;

import lombok.*;
import ru.netology.skokDmitriy.domain.ConsolePrintable;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer implements ConsolePrintable {
    private int id;
    private String name;

    public void printToConsole(){
        System.out.println(id + name);
    }


}

