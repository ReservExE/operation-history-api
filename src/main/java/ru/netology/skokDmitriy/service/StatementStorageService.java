package ru.netology.skokDmitriy.service;

import static ru.netology.skokDmitriy.utils.Constants.MAX_CUSTOMERS;
import static ru.netology.skokDmitriy.utils.Constants.OPERATIONS_PER_USER;

public class StatementStorageService {
    public static final int[][] statement = new int[MAX_CUSTOMERS][OPERATIONS_PER_USER];
    public static int[][] getStatement(){return statement;}
}
