package ru.netology.skokDmitriy.domain.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class BaseOperation {
    private int id;
    private LocalDateTime time;
}
