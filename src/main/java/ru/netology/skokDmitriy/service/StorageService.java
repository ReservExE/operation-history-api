package ru.netology.skokDmitriy.service;

import ru.netology.skokDmitriy.domain.Customer;
import ru.netology.skokDmitriy.domain.operation.Operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StorageService<T> {
    private final List<T> storage = new ArrayList<>();

    public void setElement(T element){
        storage.add(element);
    }

    public T getElement(int position){
        return storage.get(position);
    }

    public int getLength(){
        return storage.size();
    }

    public String toString(){
        return storage.toString();
    }

}
