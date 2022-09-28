package ru.netology.skokDmitriy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class BaseOperation {
    private int id;
    private LocalDateTime time;
}
