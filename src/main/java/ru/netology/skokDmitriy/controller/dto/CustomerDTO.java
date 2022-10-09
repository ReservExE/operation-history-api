package ru.netology.skokDmitriy.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {
    private final int Id;
    private final String name;
}
