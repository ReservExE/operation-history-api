package ru.netology.skokDmitriy.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.skokDmitriy.domain.operation.Currency;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OperationDTO {
    private int id;
    private LocalDateTime time;
    private ru.netology.skokDmitriy.domain.operation.OperationCreditType OperationCreditType;
    private int sum;
    private Currency currency;
    private String merchant;
    private int customerId;
}
